package loginDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/Success")
public class SuccessServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置流的编码
				response.setCharacterEncoding("GBK");
				//告诉浏览器发送消息的编码   让浏览器解码
				response.setHeader("content-type","text/html;charset=GBK");
				
				
		doGet(request, response);
		
		
		
//        输 出
	   //获取request 域中共享的user对象
		
	   //是User对象   强制类型转换
	   User user = (User)request.getAttribute("user");
		
		if(user != null) {
			response.setCharacterEncoding("gbk");
			//告诉浏览器发送消息的编码   让浏览器解码
			response.setHeader("content-type","text/html;charset=gbk");
			
	   response.getWriter().write("亲爱的： "+user.getUsername()+"欢迎您成功登录..");
	
		}
		
		
	}

}
