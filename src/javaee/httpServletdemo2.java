package javaee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class httpServletdemo2
 */
@WebServlet("/d5")
public class httpServletdemo2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served atd44444d4d444444444444444: ").append(request.getContextPath());
		System.out.println("dddddddddddddd5 被访问了");
		
		
		
		
		
		//存储数据到 resquest 域中
		request.setAttribute("meg", "I am get a message");
		
		
		
		//2.请求转发
		//转发到d4资源
		
		//步骤  1.通过request 获取转发对象
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/d4");
		//2.使用RequestDispatche对象进行转发  写 响应  和请求
		requestDispatcher.forward(request, response);
		
		
//		2.特点；
//		       1.地址栏没有变  浏览器请求信息 一个文件
//		       2.只能转发服务器内部资源
//		       3.转发是一次请求  浏览器请求信息 一个文件
		
		
		
		
		
		
//		3.共享数据
//		    *域对象，一个有范围的对象,可以在范围内共享数据
//		    request域：代表一个请求的范围，一般用于请求转发的多个资源中 共享资源
//		               方法：
//		          1.void  setAttribute(String name,Object obj):存储数据
//		          2.Object getAttitude(String name): 通过键获取值
//		          3.void  removeAttribute(String name): 通过键移除键值对
		
		
		
		
		
//		4.获取ServletContext
		     ServletContext servletContext = request.getServletContext();
		     System.out.println(servletContext);
		
		
		
		
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
