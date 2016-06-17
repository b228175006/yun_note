package org.tedu.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.BookService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 根据用户Id获取笔记本列表
 * @author Java
 *
 */
@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/loadbooks")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result = bookService.loadUserBooks(userId);
		return result;
	}
}
