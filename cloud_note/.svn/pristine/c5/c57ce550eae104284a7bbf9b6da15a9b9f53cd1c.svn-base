package org.tedu.cloudnote.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.BookDao;
import org.tedu.cloudnote.entity.Book;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao dao;
	/**
	 * 查询笔记本
	 */
	public NoteResult loadUserBooks(String userId) {
		NoteResult result = new NoteResult();
		List<Book> list = dao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("数据查询成功");
		result.setData(list);
		return result;
	}
	/**
	 * 新增笔记本
	 */
	public NoteResult saveBook(String bookName,String userId) {
		NoteResult result = new NoteResult();
		//查找是否有重复的笔记本
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bookName", bookName);
		map.put("userId", userId);
		if(dao.findByBookName(map)!=null){
			result.setStatus(1);
			result.setMsg("笔记本名称重复");
			return result;
		}
		//新增笔记本
		Book book = new Book();
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);//生成bookId
		book.setCn_user_id(userId);
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_name(bookName);
		book.setCn_notebook_desc("");
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		int i = dao.saveBook(book);
		if(i>0){
			result.setStatus(0);
			result.setMsg("新增笔记本成功");
			result.setData(bookId);
		}
		return result;
	}
	/** 
	 * 重命名笔记本
	 */
	public NoteResult rename(String rename, String bookId,String userId) {
		NoteResult result = new NoteResult();
		//查找是否有重复的笔记本
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("bookName", rename);
		map.put("userId", userId);
		if(dao.findByBookName(map)!=null){
			result.setStatus(1);
			result.setMsg("笔记本名称重复");
			return result;
		}
		//不重复获取笔记本并修改名称
		Book book = dao.findByBookId(bookId);
		book.setCn_notebook_name(rename);
		int i = dao.rename(book);
		if(i>0){
			result.setStatus(0);
			result.setMsg("笔记本重命名成功");
		}
		return result;
	}

}
