package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 根据笔记Id获取笔记
 * @author Java
 *
 */
@Controller
@RequestMapping("/note")
public class LoadOneNoteController {
	@Resource
	NoteService noteService;
	@RequestMapping("/load")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = noteService.loadNote(noteId);
		return result;
	}
}
