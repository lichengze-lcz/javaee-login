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
		//response.getWriter().append("summit for fail�� request  ").append(request.getContextPath());
	    //��ҳ��дһ�仰
		response.setCharacterEncoding("gbk");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type","text/html;charset=gbk");
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setCharacterEncoding("GBK");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type","text/html;charset=GBK");
		
		
//	         �� ��
		
		response.getWriter().write("��¼ʧ�ܣ��û������������ ");
		
	}

}
