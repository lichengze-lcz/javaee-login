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
		// ԭ���� iso-8859-1
		
		//�������ı���
		response.setCharacterEncoding("gbk");
		
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type", "text/html;charset=gbk");

		
		
		
		
		System.out.println("post ��ʽִ����");
	      //��ȡ�ַ������
			PrintWriter pw = response.getWriter();

	      //�������
			pw.write("��һ������ִ����û lichengze�����");   //���Զ�ˢ��   �������дhtml
			
			
			
			
			//  ��ȡ�ֽ������
			//ServletOutputStream sos = response.getOutputStream();
			//sos.write("hellow lichengze".getBytes());
			
			
			
			
			
			
			
			
			
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		this.doPost(request, response);
		

		
	   System.out.println("Demo2��������");
		
		
		
		
	}

	
	

}
