package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 根据笔记本Id获取笔记列表
 * @author Java
 *
 */
@Controller
@RequestMapping("/note")
public class LoadNotesController {
	@Resource
	NoteService noteService;
	
	@RequestMapping("/loadnotes")
	@ResponseBody
	public NoteResult execute(String bookId){
		NoteResult result = noteService.loadBookNotes(bookId);
		return result;
	}
}
