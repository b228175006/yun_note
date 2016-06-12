package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name,String password);
	public NoteResult registUser(String name,String nick,String password);
}
