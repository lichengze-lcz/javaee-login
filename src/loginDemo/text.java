  package loginDemo;

import org.junit.Test;
import org.springframework.dao.support.DaoSupport;
//测试类
public class text {

	
	public static void main(String args[]) {
	testlogin();
		
	}
	
	public static void testlogin() {
		
		//验证参数
		User loginuser = new User();
		loginuser.setUsername("tom");
		loginuser.setPassword("123");
		
		
		
		//把loginuser 传进来
		Userdao dao = new Userdao();
	User user =	dao.login(loginuser);
	System.out.println(user);
		
		
	
	
	}
}
