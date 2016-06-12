package org.tedu.cloudnote.dao;

import java.util.List;

import org.tedu.cloudnote.entity.Note;

public interface NoteDao {
	public List<Note> findByBookId(String bookId);
}
