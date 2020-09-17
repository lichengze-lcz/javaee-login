package javaee;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class kk
 */
@WebServlet("/kk")
public class kk extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.服务器从客户端获取 Cookie 拿到数据     再次响应时    (客户端给服务器Cookie)//Cookie
		
		
		//设置流的编码
		response.setCharacterEncoding("GBK");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type", "text/html;charset=GBK");

		
		
		Cookie[] cookies =request.getCookies();  
		boolean flag = false;  //代表没有cookie 为lasetime

		//进行遍历   

		if(cookies!=null && cookies.length>0) {
			for(Cookie c:cookies) {       
		  
		   //获取 cookie名称	
			String name = c.getName();    
			
		   //判断名称是否有：lasttime
			if("lasttime".equals(name)) {
				//有该Cookie  不是第一次访问
				flag = true;  //代表找到Cookie 
				
				//设置Cookie的value 当前时间段    重新设置Cookie的值，重新发送Cookie
				Date date = new Date();
				//改成中国时间格式
				SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
				//解析格式
				String str_date = sdf.format(date);
				
				System.out.println("编码前的："+str_date);
				
				
				//URL编码解决特殊符号问题
				str_date = URLEncoder.encode(str_date,"utf-8");
				
				System.out.println("编码后的"+str_date);
				
				
				
				//设置Value值  ： 时间
			    c.setValue(str_date);
				//发送cookie  重新发送回去   键名称还是lasttime 值变了
			    
			    //设置cookie存活时间
			    c.setMaxAge(60*10);
			    
			    response.addCookie(c);
			    
			    
				//响应数据
				//获取cookie数据value （时间）
				String value =c.getValue();
				
				
				
				
				System.out.println("解码前value"+value);
				//URL解码
				value = URLDecoder.decode(value,"utf-8");
				System.out.println("解码后value"+value);
				
				response.getWriter().write("欢迎回来，您上次访问的时间为："+value);
				
				break;
			   }
			 }
		}



		//没找到Cookie
		if(cookies == null || cookies.length == 0|| flag == false) {

			 //没找到，要记录第一次时间
			 
			//设置Cookie的value 当前时间段    重新设置Cookie的值，重新发送Cookie
			Date date = new Date();
			//改成中国时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
			
			//解析格式
			String str_date = sdf.format(date);
			
			

			Cookie c= new Cookie("lasttime","str_date"); //必须加""
		    		
		    
		    
		 //URL编码解决特殊符号问题
			str_date = URLEncoder.encode(str_date,"utf-8");  	    
		    
		    //设置cookie存活时间
		    c.setMaxAge(60*10);
		    
		    //发送
		    response.addCookie(c);
			 
			 
			response.getWriter().write("欢迎首次访问"); 
			 
			 
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
