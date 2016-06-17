package org.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.tedu.cloudnote.entity.Note;

public interface NoteDao {
	/**
	 * ���ݱʼǱ�Id����
	 * @param bookId �ʼǱ�Id
	 * @return
	 */
	public List<Note> findByBookId(String bookId);
	/**
	 * ���ݱʼ�Id����
	 * @param noteId �ʼ�Id
	 * @return
	 */
	public Note findByNoteId(String noteId);
	/**
	 * ���±ʼ�����
	 * @param note �ʼ�ʵ����
	 * @return
	 */
	public int updateNote(Note note);
	/**
	 * �½��ʼ�
	 * @param note
	 * @return
	 */
	public int saveNote(Note note);
	/**
	 * ���ıʼ�״̬
	 * @param statusId(1��������2������վ) noteId(�ʼ�Id)
	 * @return
	 */
	public int updateStatus(Map<String,Object> map);
	
	/**
	 * ���ݱʼ�Id���±ʼǱ�Id
	 * @param bookId���ʼǱ�Id��noteId���ʼ�Id
	 * @return
	 */
	public int updateBookId(Map<String,Object>map);
	/**
	 * �鿴����վ�ʼ�
	 * @param userId �û�Id
	 * @return
	 */
	public List<Note> findByRecycle(String userId);
}