package loginupchockcode;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import loginDemo.JdbcUtils;

//��ѯ���ݿ��װ����һ��user

public class Userdao {

	   JdbcUtils jdbcUtils=new JdbcUtils();
		JdbcTemplate template = new JdbcTemplate((DataSource) jdbcUtils.getDataSource());
	

	
//	��¼����

	//���ص� user  �����û���ȫ������ 
	//����Ϣ�� User��
	public User login(User loginUser){      //������װ��һ������
		
		// 
		try {
			String sql = "select * from web51 where username =? and password =?";
			
	        //���÷���ִ��sql	
            User user = template.queryForObject(sql,
    		 
            //�Ѳ�ѯ��������װ��һ��user ���� ������ʽ              
	        new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());
	        //User�Ķ������ѯ���������Զ�����ӳ��		
     
 	        System.out.println("�򵥵Ĳ鿴һ�µ�ǰUser"+user);
 	     
 	        //user �����û�ȫ�����ݣ�û�в�ѯ������null ��½ʧ��    
 	       
			return user;    
			
		 
		  } catch (DataAccessException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	
}
