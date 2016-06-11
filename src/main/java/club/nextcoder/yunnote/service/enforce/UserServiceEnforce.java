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
		//�����û��������ݿ��в�������
		User user = dao.findByName(name);
		//�û������󣬷���
		if(user == null){
			result = new NoteResult("1","�û�������",null);
			return result;
		}
		//�����û������ҵ�����ƥ������
		String psd = user.getCn_user_password();
		if(!psd.equals(password)){
			result = new NoteResult("2","�������",null);
			return result;
		}
		//�û������붼��ȷ������
		result = new NoteResult("0","��¼�ɹ�",null);
		return result;
	}
	//ע����
	public NoteResult checkSgin(String name) {
		NoteResult result = null;
		User user = dao.findByName(name);
		if(user==null){
			result = new NoteResult("0","���û�������ע��",null);
		}else{
			result = new NoteResult("1","���û�����ռ��",null);
		}
		return result;
	}
	//ע���û�
	public NoteResult saveUser(User user) {
		dao.saveUser(user);
		return new NoteResult("0","ע��ɹ�",null);
	}

}
