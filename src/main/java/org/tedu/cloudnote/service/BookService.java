package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface BookService {
	public NoteResult loadUserBooks(String userId);
	public NoteResult saveBook(String bookName,String userId);
	public NoteResult rename (String rename,String bookId,String userId);
}
