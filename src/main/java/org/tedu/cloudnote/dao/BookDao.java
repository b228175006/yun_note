package org.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import org.tedu.cloudnote.entity.Book;

public interface BookDao {
	public List<Book> findByUserId(String userId);
	public Book findByBookName(Map map);
	public Book findByBookId(String bookId);
	public int saveBook(Book book);
	public int rename(Book book);
	
}
