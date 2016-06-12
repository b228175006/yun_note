package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.BookDao;
import org.tedu.cloudnote.entity.Book;
import org.tedu.cloudnote.util.NoteResult;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao dao;
	
	public NoteResult loadUserBooks(String userId) {
		NoteResult result = new NoteResult();
		List<Book> list = dao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("数据查询成功");
		result.setData(list);
		return result;
	}

}
