package org.tedu.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.BookService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/book")
public class RenameBookController {
	@Resource
	BookService bookService;
	
	@RequestMapping("/rename")
	@ResponseBody
	public NoteResult renameBook(String rename,String bookId,String userId){
		NoteResult result = bookService.rename(rename, bookId,userId);
		return result;
	}
}
