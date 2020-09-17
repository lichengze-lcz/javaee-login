package loginDemo;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

//操作数据库中useruser表中的类
public class Userdao {
//	public static void main(String []args) {
	   JdbcUtils jdbcUtils=new JdbcUtils();
		JdbcTemplate template = new JdbcTemplate((DataSource) jdbcUtils.getDataSource());
	

	
//	登录方法
//	loginUser 只有用户名，密码
//	返回的 user  包含用户的全部数据 
	//把信息给 User类
	public User login(User loginUser){      //把它封装到一个类里
		// 
		try {
			String sql = "select * from web51 where username =? and password =?";
			System.out.println("----------------");
	//调用方法执行sql	
     User user = template.queryForObject(sql,
    		 
    		        //把查询到的它封装成一个user 对象 集合形式               校验指定 参数       //***校验用户名和密码  二者缺一数据库就查不到       因此user返回为空，登陆失败
					new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());
//	                User的对象与查询到的数据自动进行映射		
     
 	System.out.println(user);
 	System.out.println(loginUser.getUsername());
			
			return user;    //user 包含用户全部数据，没有查询到返回null 登陆失败    //返回查到的  用户名 密码的信息   有值 登录成功
			
		
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
