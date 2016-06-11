package club.nextcoder.yunnote.dao;

import club.nextcoder.yunnote.entity.User;

public interface UserDao {
	public User findByName(String name);
	public int saveUser(User user);
}
