package test_dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tedu.cloudnote.dao.UserDao;
import org.tedu.cloudnote.entity.User;
import org.tedu.cloudnote.service.UserService;
import org.tedu.cloudnote.util.NoteResult;

public class TestUserDao {
	
	/**
	 * ≤‚ ‘DBCP
	 * @throws SQLException 
	 */
	@Test
	public void test() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		DataSource ds = ac.getBean("dbcp",DataSource.class);
		System.out.println(ds.getConnection());
	}
	/**
	 * ≤‚ ‘Dao
	 * @throws SQLException 
	 */
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findByName("demo");
		System.out.println(user);
	}
	@Test
	public void test2(){
		String[] conf = {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserService service = ac.getBean("userService",UserService.class);
		NoteResult result = service.checkLogin("demo", "c8837b23ff8aaa8a2dde915473ce0991");
		System.out.println(result);
	}
}
