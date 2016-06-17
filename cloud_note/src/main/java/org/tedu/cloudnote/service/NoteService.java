package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface NoteService {
	/**
	 * 根据笔记本Id查找笔记
	 * @param bookId 笔记本Id
	 * @return
	 */
	public NoteResult loadBookNotes(String bookId);
	/**
	 * 根据笔记Id查找笔记
	 * @param noteId 笔记Id
	 * @return
	 */
	public NoteResult loadNote(String noteId);
	/**
	 * 修改笔记标题和内容
	 * @param title 笔记标题
	 * @param body 笔记内容
	 * @param noteId 笔记Id
	 * @return
	 */
	public NoteResult updateNote(String title,String body,String noteId);
	/**
	 * 新建笔记
	 * @param userId 用户Id
	 * @param bookId 笔记本Id
	 * @param name 笔记名称
	 * @return
	 */
	public NoteResult saveNote(String userId,String bookId,String name);
	/**
	 * 删除笔记至回收站
	 * @param noteId 笔记Id
	 * @return
	 */
	public NoteResult recycleNote(String noteId);
	/**
	 * 移动笔记至其他笔记本
	 * @param noteId 笔记Id
	 * @param bookId 笔记本Id
	 * @return
	 */
	public NoteResult moveNote(String noteId,String bookId);
	/**
	 * 查看用户的回收站
	 * @param userId 用户Id
	 * @return
	 */
	public NoteResult recycleList(String userId);
}
