package loginDemo;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import  java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;;

//jabc工具类  Druid
public class JdbcUtils {

	// 定义数据源
	public static DataSource ds;
//	public static  Properties pro;
//	
	
	
	static {
		
	  
		try {
			
			
			//1.加载配置文件
			Properties pro = new Properties();
			//通过本类加载配置文件 获取字节输入流
			
			pro.load(new  FileInputStream("D:\\Myjava\\javawebdemo\\javawebb\\javae\\src\\loginDemo\\produrid"));
			//2.初始化连接池
			System.out.println(pro.toString());
		ds = (DataSource) DruidDataSourceFactory.createDataSource(pro);
		  	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//1.获取连接池对象
	public static DataSource getDataSource() {
		
//		if(ds==null)
//			System.out.println(1);
//		else
//			System.out.println(2);
		return ds;
	}
	
	
	
	
	
	//2.获取连接对象
	
	public static Connection getconnection() throws SQLException{
		return ((JdbcUtils) ds).getconnection();
	}
	
}
