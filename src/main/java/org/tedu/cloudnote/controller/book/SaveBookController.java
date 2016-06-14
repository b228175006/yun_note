package org.tedu.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.BookService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/book")
public class SaveBookController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/save")
	@ResponseBody
	public NoteResult saveBook(String bookName,String userId){
		NoteResult result = bookService.saveBook(bookName, userId);
		return result;
	}
}
