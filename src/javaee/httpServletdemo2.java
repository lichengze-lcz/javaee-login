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
		System.out.println("dddddddddddddd5 ��������");
		
		
		
		
		
		//�洢���ݵ� resquest ����
		request.setAttribute("meg", "I am get a message");
		
		
		
		//2.����ת��
		//ת����d4��Դ
		
		//����  1.ͨ��request ��ȡת������
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/d4");
		//2.ʹ��RequestDispatche�������ת��  д ��Ӧ  ������
		requestDispatcher.forward(request, response);
		
		
//		2.�ص㣻
//		       1.��ַ��û�б�  �����������Ϣ һ���ļ�
//		       2.ֻ��ת���������ڲ���Դ
//		       3.ת����һ������  �����������Ϣ һ���ļ�
		
		
		
		
		
		
//		3.��������
//		    *�����һ���з�Χ�Ķ���,�����ڷ�Χ�ڹ�������
//		    request�򣺴���һ������ķ�Χ��һ����������ת���Ķ����Դ�� ������Դ
//		               ������
//		          1.void  setAttribute(String name,Object obj):�洢����
//		          2.Object getAttitude(String name): ͨ������ȡֵ
//		          3.void  removeAttribute(String name): ͨ�����Ƴ���ֵ��
		
		
		
		
		
//		4.��ȡServletContext
		     ServletContext servletContext = request.getServletContext();
		     System.out.println(servletContext);
		
		
		
		
	}

	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
