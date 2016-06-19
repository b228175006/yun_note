package org.tedu.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.NoteService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 获取收藏笔记列表
 * @author Java
 *
 */
@Controller
@RequestMapping("/note")
public class LoadFavorController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadfavor")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result = noteService.loadFavorList(userId);
		return result;
	}
}
