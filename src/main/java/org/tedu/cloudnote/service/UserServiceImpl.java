package org.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.util.NoteResult;
import org.tedu.cloudnote.util.NoteUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//ע��
	@Resource
	private UserDao userDao;
	//��¼���
	public NoteResult checkLogin(String name, String password) {
		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		//����û���
		if(user == null){
			result.setStatus(1);
			result.setMsg("�û�������");
			return result;
		}
		//�������
		if(!user.getCn_user_password().equals(NoteUtil.md5(password))){//���û���������ļ��ܺ�ȶ�
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		//�û�����������ȷ
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		//���û����ID����
		result.setData(user.getCn_user_id());
		return result;
	}
	
	//�û�ע��
	public NoteResult registUser(String name, String nick, String password) {
		NoteResult result = new NoteResult();
		//����û����Ƿ����
		User has_user = userDao.findByName(name);
		if(has_user!=null){//�Ѵ���
			result.setStatus(1);
			result.setMsg("�û����Ѵ���");
			return result;
		}
		//ִ��ע���߼�
		User user = new User();
		user.setCn_user_name(name);//�����û���
		user.setCn_user_nick(nick);//�����ǳ�
		user.setCn_user_password(NoteUtil.md5(password));//md5����password
		user.setCn_user_id(NoteUtil.createId());//UUID����user_id
		userDao.save(user);//����û�
		
		
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
	}
	
}
