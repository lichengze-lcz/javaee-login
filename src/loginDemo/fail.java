package loginDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fail
 */
@WebServlet("/fail")
public class fail extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//response.getWriter().append("summit for fail： request  ").append(request.getContextPath());
	    //给页面写一句话
		response.setCharacterEncoding("gbk");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type","text/html;charset=gbk");
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setCharacterEncoding("GBK");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type","text/html;charset=GBK");
		
		
//	         输 出
		
		response.getWriter().write("登录失败，用户名或密码错误 ");
		
	}

}
