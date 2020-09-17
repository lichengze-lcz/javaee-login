package loginDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.support.DaoSupport;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type","text/html;charset=GBK");
		
		
		//2.��ȡ�������---�û��� ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//3.��װuser����
		User loginuser = new User();
		
		//�� ����Ĳ��� �û��� ����  ���ݸ� user  
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		
		//4.����Userdao��login����               ���̨���ݿ����Ϣ  ����У��
		Userdao dao = new Userdao();
		
		//����һ�µ� User ���󣬳�ʼû��ֵ
		User user = dao.login(loginuser);   //�� Userdao    login����   ����loginuser  ���� User����   ��������User����//��ѯ����user
		
		
		
//		5.�ж� user ���� ����
		if(user == null) {//==null   userΪ�� ��¼ʧ��
			//û�鵽 ��¼ʧ��      //ת��   ��ת ҳ��
			request.getRequestDispatcher("/fail").forward(request, response);
			
		}else{
			//�鵽��¼�ɹ�
			//�洢����     ���û���
			request.setAttribute("user",user);
			
			//ת��
			request.getRequestDispatcher("/Success").forward(request, response);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
