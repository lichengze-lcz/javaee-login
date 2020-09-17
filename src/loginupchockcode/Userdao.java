package loginupchockcode;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import loginDemo.JdbcUtils;

//查询数据库封装到另一个user

public class Userdao {

	   JdbcUtils jdbcUtils=new JdbcUtils();
		JdbcTemplate template = new JdbcTemplate((DataSource) jdbcUtils.getDataSource());
	

	
//	登录方法

	//返回的 user  包含用户的全部数据 
	//把信息给 User类
	public User login(User loginUser){      //把它封装到一个类里
		
		// 
		try {
			String sql = "select * from web51 where username =? and password =?";
			
	        //调用方法执行sql	
            User user = template.queryForObject(sql,
    		 
            //把查询到的它封装成一个user 对象 集合形式              
	        new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());
	        //User的对象与查询到的数据自动进行映射		
     
 	        System.out.println("简单的查看一下当前User"+user);
 	     
 	        //user 包含用户全部数据，没有查询到返回null 登陆失败    
 	       
			return user;    
			
		 
		  } catch (DataAccessException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	
}
