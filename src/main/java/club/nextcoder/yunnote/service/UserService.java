package club.nextcoder.yunnote.service;
import club.nextcoder.yunnote.entity.User;
import club.nextcoder.yunnote.util.NoteResult;


public interface UserService {
	public NoteResult checkLogin(String name,String password);
	
	public NoteResult checkSgin(String name);
	
	public NoteResult saveUser(User user);
}
