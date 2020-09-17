package servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletcontextDemo2")
public class servletcontextDemo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("servletcontextDemo2:。。。。。。。。。。 ").append(request.getContextPath());
		
		
		
		//2.通过HttpServlet对象获取
		
				ServletContext context2 = this.getServletContext();
//		 接收共享数据
			Object msg = context2.getAttribute("msg");   //用Object 接收
		        System.out.println(msg);     //作用范围非常大
		
		
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
