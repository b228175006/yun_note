package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNotesController {
	@Resource
	NoteService noteService;
	
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult loadNotes(String bookId){
		NoteResult result = noteService.loadBookNotes(bookId);
		return result;
	}
}
