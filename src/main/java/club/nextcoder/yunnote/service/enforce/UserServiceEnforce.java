package club.nextcoder.yunnote.service.enforce;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import club.nextcoder.yunnote.dao.UserDao;
import club.nextcoder.yunnote.entity.User;
import club.nextcoder.yunnote.service.UserService;
import club.nextcoder.yunnote.util.NoteResult;



@Service("userService")
public class UserServiceEnforce implements UserService {
	
	@Resource(name="userDao")
	private UserDao dao;
	
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = null;
		//根据用户名从数据库中查找数据
		User user = dao.findByName(name);
		//用户名错误，返回
		if(user == null){
			result = new NoteResult("1","用户名错误",null);
			return result;
		}
		//根据用户名查找的数据匹配密码
		String psd = user.getCn_user_password();
		if(!psd.equals(password)){
			result = new NoteResult("2","密码错误",null);
			return result;
		}
		//用户名密码都正确，返回
		result = new NoteResult("0","登录成功",null);
		return result;
	}
	//注册检查
	public NoteResult checkSgin(String name) {
		NoteResult result = null;
		User user = dao.findByName(name);
		if(user==null){
			result = new NoteResult("0","此用户名可以注册",null);
		}else{
			result = new NoteResult("1","此用户名被占用",null);
		}
		return result;
	}
	//注册用户
	public NoteResult saveUser(User user) {
		dao.saveUser(user);
		return new NoteResult("0","注册成功",null);
	}

}
