package javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *     
 * 
 */
@WebServlet("/RDemo2")
public class ResponseDemo2 extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 原编码 iso-8859-1
		
		//设置流的编码
		response.setCharacterEncoding("gbk");
		
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type", "text/html;charset=gbk");

		
		
		
		
		System.out.println("post 方式执行啦");
	      //获取字符输出流
			PrintWriter pw = response.getWriter();

	      //输出数据
			pw.write("试一下中文执行了没 lichengze李承泽");   //流自动刷新   里面可以写html
			
			
			
			
			//  获取字节输出流
			//ServletOutputStream sos = response.getOutputStream();
			//sos.write("hellow lichengze".getBytes());
			
			
			
			
			
			
			
			
			
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		this.doPost(request, response);
		

		
	   System.out.println("Demo2被访问了");
		
		
		
		
	}

	
	

}
