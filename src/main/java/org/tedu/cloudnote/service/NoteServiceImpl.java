package org.tedu.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.NoteDao;
import org.tedu.cloudnote.entity.Note;
import org.tedu.cloudnote.util.NoteResult;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	NoteDao noteDao;
	public NoteResult loadBookNotes(String bookId) {
		NoteResult result = new NoteResult();
		List<Note> list = noteDao.findByBookId(bookId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}

}
