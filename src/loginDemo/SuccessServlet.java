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
		//�������ı���
				response.setCharacterEncoding("GBK");
				//���������������Ϣ�ı���   �����������
				response.setHeader("content-type","text/html;charset=GBK");
				
				
		doGet(request, response);
		
		
		
//        �� ��
	   //��ȡrequest ���й����user����
		
	   //��User����   ǿ������ת��
	   User user = (User)request.getAttribute("user");
		
		if(user != null) {
			response.setCharacterEncoding("gbk");
			//���������������Ϣ�ı���   �����������
			response.setHeader("content-type","text/html;charset=gbk");
			
	   response.getWriter().write("�װ��ģ� "+user.getUsername()+"��ӭ���ɹ���¼..");
	
		}
		
		
	}

}
