package org.tedu.cloudnote.dao;

import org.tedu.cloudnote.entity.User;

public interface UserDao {
	/**
	 * 根据用户名查找
	 * @param name用户名
	 * @return
	 */
	public User findByName(String name);
	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	public int save(User user);
}
