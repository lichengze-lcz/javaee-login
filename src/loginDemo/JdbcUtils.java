package loginDemo;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import  java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.Connection;;

//jabc������  Druid
public class JdbcUtils {

	// ��������Դ
	public static DataSource ds;
//	public static  Properties pro;
//	
	
	
	static {
		
	  
		try {
			
			
			//1.���������ļ�
			Properties pro = new Properties();
			//ͨ��������������ļ� ��ȡ�ֽ�������
			
			pro.load(new  FileInputStream("D:\\Myjava\\javawebdemo\\javawebb\\javae\\src\\loginDemo\\produrid"));
			//2.��ʼ�����ӳ�
			System.out.println(pro.toString());
		ds = (DataSource) DruidDataSourceFactory.createDataSource(pro);
		  	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//1.��ȡ���ӳض���
	public static DataSource getDataSource() {
		
//		if(ds==null)
//			System.out.println(1);
//		else
//			System.out.println(2);
		return ds;
	}
	
	
	
	
	
	//2.��ȡ���Ӷ���
	
	public static Connection getconnection() throws SQLException{
		return ((JdbcUtils) ds).getconnection();
	}
	
}
