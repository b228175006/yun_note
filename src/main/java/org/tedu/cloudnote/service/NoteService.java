package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface NoteService {
	public NoteResult loadBookNotes(String bookId);
	public NoteResult loadNote(String noteId);
	public NoteResult updateNote(String title,String body,String noteId);
	public NoteResult saveNote(String userId,String bookId,String name);
}
