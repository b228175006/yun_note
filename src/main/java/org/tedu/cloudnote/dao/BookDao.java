package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Book;

public interface BookDao {
	public List<Book> findByUserId(String userId);
}
