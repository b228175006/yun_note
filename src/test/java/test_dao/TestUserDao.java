package test_dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.nextcoder.yunnote.dao.UserDao;
import club.nextcoder.yunnote.entity.User;
import club.nextcoder.yunnote.service.UserService;
import club.nextcoder.yunnote.util.NoteResult;

public class TestUserDao {
	/**
	 * �������ݿ�����
	 */
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		DataSource ds = ac.getBean("dbcp",DataSource.class);
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test //����UserDao��findByName
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo1");
		System.out.println(user);
	}
	@Test //����UserService
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/*.xml");
		UserService us = ac.getBean("userService",UserService.class);
//		NoteResult result = us.checkLogin("demo1", "c8837b23ff8aaa8a2dde915473ce0991");
		NoteResult result = us.checkLogin("demo1", "");
		System.out.println(result);
		
	}
	@Test 
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/*.xml");
		UserService us = ac.getBean("userService",UserService.class);
//		NoteResult result = us.checkLogin("demo1", "c8837b23ff8aaa8a2dde915473ce0991");
		User user = new User();
		user.setCn_user_id("1");
		user.setCn_user_name("test11");
		user.setCn_user_nick("注册测试");
		user.setCn_user_password("123123");
		user.setCn_user_token("1");
		NoteResult result = us.saveUser(user);
		System.out.println(result);
		
	}
	
}
