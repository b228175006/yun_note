package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//注入
	@Resource
	private UserDao userDao;
	//登录检查
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		//检测用户名
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名错误");
			return result;
		}
		//检测密码
		if(!user.getCn_user_password().equals(NoteUtil.md5(password))){//将用户输入的明文加密后比对
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		//用户名和密码正确
		result.setStatus(0);
		result.setMsg("登录成功");
		//将用户身份ID返回
		result.setData(user.getCn_user_id());
		return result;
	}
	
	//用户注册
	public NoteResult registUser(String name, String nick, String password) {
		NoteResult result = new NoteResult();
		//检测用户名是否存在
		User has_user = userDao.findByName(name);
		if(has_user!=null){//已存在
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;
		}
		//执行注册逻辑
		User user = new User();
		user.setCn_user_name(name);//设置用户名
		user.setCn_user_nick(nick);//设置昵称
		user.setCn_user_password(NoteUtil.md5(password));//md5加密password
		user.setCn_user_id(NoteUtil.createId());//UUID生成user_id
		userDao.save(user);//添加用户
		
		
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}
	
}
