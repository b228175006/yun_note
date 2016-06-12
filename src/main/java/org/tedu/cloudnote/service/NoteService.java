package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface NoteService {
	public NoteResult loadBookNotes(String bookId);
}
