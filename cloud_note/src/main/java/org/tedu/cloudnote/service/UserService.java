package org.tedu.cloudnote.service;

import org.tedu.cloudnote.util.NoteResult;

public interface UserService {
	/**
	 * ��¼���
	 * @param name �û���
	 * @param password ����
	 * @return
	 */
	public NoteResult checkLogin(String name,String password);
	/**
	 * ע�����û�
	 * @param name �û���
	 * @param nick �ǳ�
	 * @param password ����
	 * @return
	 */
	public NoteResult registUser(String name,String nick,String password);
}
