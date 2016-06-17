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
	 * ���ݱʼ�Id���ӱʼǱ��ѯ�ʼǲ����뵽�������
	 */
	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		//��ѯ����Id���鿴�ʼ��Ƿ��Ѿ�����
		if(shareDao.findByNoteId(noteId)!=null){
			result.setStatus(1);
			result.setMsg("�ʼ��Ѿ�����");
			return result;
		}
		//���ݱʼ�Id����ѯ�ʼ�
		Note note = noteDao.findByNoteId(noteId);
		//�½�Shareʵ�������
		Share share = new Share();
		share.setCn_share_id(NoteUtil.createId());//���÷���Id
		share.setCn_note_id(noteId);//���ñʼ�Id
		share.setCn_share_title(note.getCn_note_title());//���÷������
		share.setCn_share_body(note.getCn_note_body());//���÷�������
		//�������
		shareDao.saveShare(share);
		result.setStatus(0);
		result.setMsg("�ʼǷ���ɹ�");
		return result;
	}
	/** 
	 * ���ݱʼǱ���ģ������
	 */
	public NoteResult searchShare(String keyword) {
		NoteResult result = new NoteResult();
		String title = "%";
		if(keyword!=null&&!"".equals(keyword)){
			title = "%"+keyword+"%";
		}
		List<Share> shares = shareDao.search(title);
		result.setStatus(0);
		result.setMsg("������ϣ�");
		result.setData(shares);
		return result;
	}
	/**
	 * ���ݷ���Id���в�ѯ��Ԥ���ʼ�
	 * @param shareId ����Id
	 * @return
	 */
	public NoteResult loadShare(String shareId) {
		NoteResult result = new NoteResult();
		Share share = shareDao.findByShareId(shareId);
		result.setStatus(0);
		result.setMsg("��ѯ�ɹ�");
		result.setData(share);
		return result;
	}
	
	/**
	 * �ղرʼ�
	 * @param shareId ����ʼ�Id
	 * @return
	 */
	public NoteResult favorShare(String shareId,String userId) {
		NoteResult result = new NoteResult();
		//��ȡ����ʼǵ�����
		Share share = shareDao.findByShareId(shareId);
		//�ж��Ƿ����û��Լ�����ıʼǣ�����ǣ������ղ�
		Note userNote = noteDao.findByNoteId(share.getCn_note_id());//���ݷ����noteId��ѯ�����ĸ��û�
		//�ж�userId�Ƿ����
		if(userId==""&&"".equals(userId)){
			result.setStatus(2);
			result.setMsg("���ȵ�¼");
			return result;
		}
		//�ж��Ƿ����Լ��ķ���
		if(userId.equals(userNote.getCn_user_id())){
			result.setStatus(1);
			result.setMsg("�������ղ��Լ�����ıʼ�");
			return result;
		}
		//�ж��Ƿ��Ѿ��ղ�
		Favor favor = new Favor();
		favor.setCn_user_id(userId);
		favor.setCn_share_id(shareId);
		int i = favorDao.findFavor(favor);
		if(i>0){
			result.setStatus(3);
			result.setMsg("�ñʼ����ղ� ");
			return result;
		}
		
		//ת�浽�û��ıʼ���
		Note note = new Note();
		//�ʼ�id
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(shareId);//�ʼǱ�Id
		note.setCn_user_id(userId);//�û�Id
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("2");//�ղ�״̬
		note.setCn_note_title(share.getCn_share_title());//�ʼǱ���
		note.setCn_note_body(share.getCn_share_body());
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.saveNote(note);
		//�ղؼ�¼������Ӽ�¼
		
		favorDao.save(favor);
		//��������
		result.setStatus(0);
		result.setMsg("�ղسɹ�");
		result.setData(noteId);
		return result;
	}


}
