  package loginDemo;

import org.junit.Test;
import org.springframework.dao.support.DaoSupport;
//������
public class text {

	
	public static void main(String args[]) {
	testlogin();
		
	}
	
	public static void testlogin() {
		
		//��֤����
		User loginuser = new User();
		loginuser.setUsername("tom");
		loginuser.setPassword("123");
		
		
		
		//��loginuser ������
		Userdao dao = new Userdao();
	User user =	dao.login(loginuser);
	System.out.println(user);
		
		
	
	
	}
}
