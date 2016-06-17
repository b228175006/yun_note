package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.FavorDao;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Favor;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;


@Service("shareService")
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	@Resource
	private FavorDao favorDao;
	/** 
	 * 根据笔记Id，从笔记表查询笔记并插入到分享表中
	 */
	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//查询分享Id，查看笔记是否已经分享
		if(shareDao.findByNoteId(noteId)!=null){
			result.setStatus(1);
			result.setMsg("笔记已经分享");
			return result;
		}
		//根据笔记Id，查询笔记
		Note note = noteDao.findByNoteId(noteId);
		//新建Share实体类对象
		Share share = new Share();
		share.setCn_share_id(NoteUtil.createId());//设置分享Id
		share.setCn_note_id(noteId);//设置笔记Id
		share.setCn_share_title(note.getCn_note_title());//设置分享标题
		share.setCn_share_body(note.getCn_note_body());//设置分享内容
		//保存分享
		shareDao.saveShare(share);
		result.setStatus(0);
		result.setMsg("笔记分享成功");
		return result;
	}
	/** 
	 * 根据笔记标题模糊搜索
	 */
	public NoteResult searchShare(String keyword) {
		NoteResult result = new NoteResult();
		String title = "%";
		if(keyword!=null&&!"".equals(keyword)){
			title = "%"+keyword+"%";
		}
		List<Share> shares = shareDao.search(title);
		result.setStatus(0);
		result.setMsg("搜索完毕！");
		result.setData(shares);
		return result;
	}
	/**
	 * 根据分享Id进行查询，预览笔记
	 * @param shareId 分享Id
	 * @return
	 */
	public NoteResult loadShare(String shareId) {
		NoteResult result = new NoteResult();
		Share share = shareDao.findByShareId(shareId);
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(share);
		return result;
	}
	
	/**
	 * 收藏笔记
	 * @param shareId 分享笔记Id
	 * @return
	 */
	public NoteResult favorShare(String shareId,String userId) {
		NoteResult result = new NoteResult();
		//获取分享笔记的数据
		Share share = shareDao.findByShareId(shareId);
		//判断是否是用户自己分享的笔记，如果是，则不能收藏
		Note userNote = noteDao.findByNoteId(share.getCn_note_id());//根据分享的noteId查询属于哪个用户
		//判断userId是否存在
		if(userId==""&&"".equals(userId)){
			result.setStatus(2);
			result.setMsg("请先登录");
			return result;
		}
		//判断是否是自己的分享
		if(userId.equals(userNote.getCn_user_id())){
			result.setStatus(1);
			result.setMsg("您不能收藏自己分享的笔记");
			return result;
		}
		//判断是否已经收藏
		Favor favor = new Favor();
		favor.setCn_user_id(userId);
		favor.setCn_share_id(shareId);
		int i = favorDao.findFavor(favor);
		if(i>0){
			result.setStatus(3);
			result.setMsg("该笔记已收藏 ");
			return result;
		}
		
		//转存到用户的笔记中
		Note note = new Note();
		//笔记id
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(shareId);//笔记本Id
		note.setCn_user_id(userId);//用户Id
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("2");//收藏状态
		note.setCn_note_title(share.getCn_share_title());//笔记标题
		note.setCn_note_body(share.getCn_share_body());
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.saveNote(note);
		//收藏记录表中添加记录
		
		favorDao.save(favor);
		//返回数据
		result.setStatus(0);
		result.setMsg("收藏成功");
		result.setData(noteId);
		return result;
	}


}
