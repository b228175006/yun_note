package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource
	NoteService noteService;
	@RequestMapping("/add")
	@ResponseBody
	public NoteResult execute(String userId,String bookId,String name){
		NoteResult result = noteService.saveNote(userId, bookId, name);
		return result;
	}
}
