package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	NoteDao noteDao;
	//通过笔记本ID查找笔记本内所属的笔记
	public NoteResult loadBookNotes(String bookId) {
		NoteResult result = new NoteResult();
		List<Note> list = noteDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}
	//通过笔记id查找单一笔记
	public NoteResult loadNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findByNoteId(noteId);
		result.setStatus(0);
		result.setMsg("加载笔记内容成功");
		result.setData(note);
		return result;
	}
	//保存笔记的修改
	public NoteResult updateNote(String title, String body, String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findByNoteId(noteId);
		//如果内容和原有的内容不变直接返回
		if(note.getCn_note_title().equals(title)&&note.getCn_note_body().equals(body)){
			result.setStatus(1);
			result.setMsg("未更新内容");
			return result;
		}
		//修改后返回
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		noteDao.updateNote(note);
		result.setStatus(0);
		result.setMsg("修改成功");
		return result;
	}
	/**
	 * 新增笔记
	 */
	public NoteResult saveNote(String userId, String bookId, String name) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		//笔记id
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);//笔记本Id
		note.setCn_user_id(userId);//用户Id
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_title(name);//笔记标题
		note.setCn_note_body("");
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		//保存
		noteDao.saveNote(note);
		result.setStatus(0);
		result.setMsg("新增笔记成功");
		result.setData(noteId);
		return result;
	}

}
