package club.nextcoder.yunnote.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.nextcoder.yunnote.entity.User;
import club.nextcoder.yunnote.service.UserService;
import club.nextcoder.yunnote.util.NoteResult;

/**
 * user模块控制器
 * @author Gamon
 *
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource(name="userService")
	private UserService us;
	/**
	 * 登陆验证
	 * @param name 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(String name,String password){
		NoteResult result = us.checkLogin(name, password);
		System.out.println(name+":"+password);
		return result;
	}
	
	
	/**
	 * 注册用户名验证
	 * @param name 注册用户名
	 * @return
	 */
	@RequestMapping("/check.do")
	@ResponseBody
	public NoteResult checkName(String name){
		NoteResult result = us.checkSgin(name);
		return result;
	}
	
	/**
	 * 注册用户
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/sgin_up.do")
	@ResponseBody
	public NoteResult signUp(HttpServletRequest req) throws UnsupportedEncodingException{
		//设置字符集
		req.setCharacterEncoding("utf-8");
		//获取数据
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String nickname = req.getParameter("nickname");
		//保存数据到实体类
		User user = new User();
		user.setCn_user_id(new Date().toString());
		user.setCn_user_name(name);
		user.setCn_user_nick(nickname);
		user.setCn_user_password(password);
		user.setCn_user_token(null);
		//保存到数据库
		NoteResult result = us.saveUser(user);
		
		return result;
	}
	
}
