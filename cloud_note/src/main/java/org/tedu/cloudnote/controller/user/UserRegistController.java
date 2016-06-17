package org.tedu.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tedu.cloudnote.service.UserService;
import org.tedu.cloudnote.util.NoteResult;

/**
 * �û�ע��
 * @author Java
 *
 */
@Controller
@RequestMapping("/user")
public class UserRegistController {
	//ע�����
	@Resource
	private UserService userService;
	
	//ע�������
	@RequestMapping("/regist")
	@ResponseBody
	public NoteResult execute(String name,String nick,String password){
		NoteResult result = userService.registUser(name, nick, password);
		return result;
	}
}
