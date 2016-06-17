package org.tedu.cloudnote.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.dao.ShareDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.entity.Share;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	NoteDao noteDao;
	@Resource
	ShareDao shareDao;
	/**
	 * ͨ���ʼǱ�ID���ұʼǱ��������ıʼ�
	 */
	public NoteResult loadBookNotes(String bookId) {
		NoteResult result = new NoteResult();
		List<Note> list = noteDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(list);
		return result;
	}
	/**
	 * ͨ���ʼ�id���ҵ�һ�ʼ�
	 */
	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findByNoteId(noteId);
		result.setStatus(0);
		result.setMsg("���رʼ����ݳɹ�");
		result.setData(note);
		return result;
	}
	/**
	 * ����ʼǵ��޸�
	 */
	public NoteResult updateNote(String title, String body, String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findByNoteId(noteId);
		//������ݺ�ԭ�е����ݲ���ֱ�ӷ���
		if(note.getCn_note_title().equals(title)&&note.getCn_note_body().equals(body)){
			result.setStatus(1);
			result.setMsg("δ��������");
			return result;
		}
		//�޸ķ�����������
		Share share = shareDao.findByNoteId(noteId);
		share.setCn_share_title(title);
		share.setCn_share_body(body);
		shareDao.updateShare(share);
		//�޸ĺ󷵻�
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.updateNote(note);
		result.setStatus(0);
		result.setMsg("�޸ĳɹ�");
		return result;
	}
	/**
	 * �����ʼ�
	 */
	public NoteResult saveNote(String userId, String bookId, String name) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		//�ʼ�id
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);//�ʼǱ�Id
		note.setCn_user_id(userId);//�û�Id
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_title(name);//�ʼǱ���
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		//����
		noteDao.saveNote(note);
		result.setStatus(0);
		result.setMsg("�����ʼǳɹ�");
		result.setData(noteId);
		return result;
	}
	/**
	 * ɾ���ʼ�������վ
	 */
	public NoteResult recycleNote(String noteId) {
		NoteResult result = new NoteResult();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statusId", "2");
		map.put("noteId", noteId);
		//���±ʼ���Ϣ
		noteDao.updateStatus(map);
		//TODO ɾ����������
		result.setStatus(0);
		result.setMsg("ɾ���ɹ�");
		return result;
	}
	/**
	 * �ƶ��ʼ��������ʼǱ�
	 */
	public NoteResult moveNote(String noteId, String bookId) {
		NoteResult result = new NoteResult();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bookId", bookId);
		map.put("noteId", noteId);
		//���±ʼ������ʼǱ�
		noteDao.updateBookId(map);
		result.setStatus(0);
		result.setMsg("�ƶ��ɹ�");
		return result;
	}
	/**
	 * �鿴�û��Ļ���վ
	 * @param userId �û�Id
	 * @return
	 */
	public NoteResult recycleList(String userId) {
		NoteResult result = new NoteResult();
		result.setStatus(1);
		result.setMsg("��ȡ����վ�б�ʧ��");
		List<Note> list = new ArrayList<Note>();
		if(userId != null && !"".equals(userId)){
			list = noteDao.findByRecycle(userId);
			result.setStatus(0);
			result.setMsg("��ȡ����վ�б��ɹ�");
			result.setData(list);
		}
		return result;
	}

}