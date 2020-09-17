package loginupchockcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.support.DaoSupport;

/**
 * Servlet implementation class LoginServlet
 */
//�򵥵ļ����¼����

@WebServlet("/LoginSupc")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("GBK");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type","text/html;charset=GBK");
		
		
		//2.��ȡ�������---�û��� ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		
		//3.��װuser����
		User loginuser = new User();
		
		//�� ����Ĳ��� �û��� ����  ���ݸ� user  
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		
		//4.����Userdao��login����               ���̨���ݿ����Ϣ  ����У��
		Userdao dao = new Userdao();
		
		//����һ�µ� User ���󣬳�ʼû��ֵ
		User user = dao.login(loginuser);   //�� Userdao    login����   ����loginuser  ���� User����   ��������User����//��ѯ����user
		
		
//		�Ȼ�ȡ���ɵ���֤��
		HttpSession session1 = request.getSession();
		
		String checkCodeSession03=(String) session1.getAttribute("checkCodeSession02");//ǿת���ַ��� Ϊ�����������֤����ϵͳ��֤��Ƚ�
		
		//һ������֤�루ɾ��Session�д洢����֤�룩�˻���һ��ҳ�����������¼��Ч
		session1.removeAttribute("checkCodeSession02");
		
		
		
		System.out.println("�򵥵Ĵ�ӡһ������������֤ "+checkCodeSession03);
		if(checkCodeSession03 != null && checkCodeSession03.equalsIgnoreCase(checkcode)){ //���Դ�Сд
	    	 //��֤��һ��
	    	 //�ж��û���������
			
			
			
         if(user != null) {
	    		 //��¼�ɹ�
	    		 //�洢��Ϣ���û���Ϣ
	    		 session1.setAttribute("user",username); //�ض�����һ��ҳ����ַ�����ı�,����ɹ�ҳ��
	    		 //�ض��� ����¼�ɹ�ҳ�� 
	    		 System.out.println("zenmomjibqiue3");
	    		 response.sendRedirect(request.getContextPath()+"/success.jsp");
	    		 
	         }else {
	    		 request.setAttribute("pweror","�û����������������������"); //ת���������������ı䣬��������
		    	 //ת����jsp��¼ҳ��
		    	 request.getRequestDispatcher("logincheckcode.jsp").forward(request, response);
		    	 
	    	 }
	    	 
		}else{
	    	 //��֤�벻һ��
	    	 //��������Ϣ��ʾ��resquest
	    	 request.setAttribute("cceror","��֤�������������ȷ����֤��");
	    	 //ת����jsp��¼ҳ��
	    	 request.getRequestDispatcher("logincheckcode.jsp").forward(request, response);
	     }
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
