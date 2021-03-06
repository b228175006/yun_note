package org.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.tedu.cloudnote.entity.Book;

public interface BookDao {
	/**
	 * 根据UserId 获取所属笔记本
	 * @param userId
	 * @return
	 */
	public List<Book> findByUserId(String userId);
	/**
	 * 根据笔记本名称查找
	 * @param bookName 笔记本名称，userId 用户Id
	 * @return
	 */
	public Book findByBookName(Map<String,Object> map);
	/**
	 * 根据笔记本Id查找
	 * @param bookId 笔记本Id
	 * @return
	 */
	public Book findByBookId(String bookId);
	/**
	 * 新建笔记本
	 * @param book
	 * @return
	 */
	public int saveBook(Book book);
	/**
	 * 重命名笔记本
	 * @param book
	 * @return
	 */
	public int rename(Book book);
	
}
