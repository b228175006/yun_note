package org.tedu.cloudnote.controller.share;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.ShareService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * 新增分享笔记
 * @author Java
 *
 */
@Controller
@RequestMapping("/share")
public class ShareNoteController {
	@Resource
	private ShareService shareService;
	@RequestMapping("/share.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = new NoteResult();
		result = shareService.shareNote(noteId);
		return result;
	}
}
