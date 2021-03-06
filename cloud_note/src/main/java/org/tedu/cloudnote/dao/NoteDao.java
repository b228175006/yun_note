package org.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.tedu.cloudnote.entity.Note;

public interface NoteDao {
	/**
	 * 根据笔记本Id查找
	 * @param bookId 笔记本Id
	 * @return
	 */
	public List<Note> findByBookId(String bookId);
	/**
	 * 根据笔记Id查找
	 * @param noteId 笔记Id
	 * @return
	 */
	public Note findByNoteId(String noteId);
	/**
	 * 更新笔记内容
	 * @param note 笔记实体类
	 * @return
	 */
	public int updateNote(Note note);
	/**
	 * 新建笔记
	 * @param note
	 * @return
	 */
	public int saveNote(Note note);
	/**
	 * 更改笔记状态
	 * @param statusId(1：正常，2：回收站) noteId(笔记Id)
	 * @return
	 */
	public int updateStatus(Map<String,Object> map);
	
	/**
	 * 根据笔记Id更新笔记本Id
	 * @param bookId：笔记本Id，noteId：笔记Id
	 * @return
	 */
	public int updateBookId(Map<String,Object>map);
	/**
	 * 查看回收站笔记
	 * @param userId 用户Id
	 * @return
	 */
	public List<Note> findByRecycle(String userId);
	/**
	 *  查找收藏笔记
	 * @param userId
	 * @return
	 */
	public List<Note> findByFavor(String userId);
}
