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
		response.getWriter().append("servletcontextDemo2:�������������������� ").append(request.getContextPath());
		
		
		
		//2.ͨ��HttpServlet�����ȡ
		
				ServletContext context2 = this.getServletContext();
//		 ���չ�������
			Object msg = context2.getAttribute("msg");   //��Object ����
		        System.out.println(msg);     //���÷�Χ�ǳ���
		
		
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
