package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface BookService {
	/**
	 * 根据用户Id查询笔记本
	 * @param userId 用户Id
	 * @return
	 */
	public NoteResult loadUserBooks(String userId);
	/**
	 * 新建笔记本
	 * @param bookName 笔记本名称
	 * @param userId 用户Id
	 * @return
	 */
	public NoteResult saveBook(String bookName,String userId);
	/**
	 * 重命名笔记本
	 * @param rename 笔记本名称
	 * @param bookId 笔记本Id
	 * @param userId 用户Id
	 * @return
	 */
	public NoteResult rename (String rename,String bookId,String userId);
}
