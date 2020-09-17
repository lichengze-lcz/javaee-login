package servletcontext;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/servletcontextDemo")
public class servletcontextDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
 
		//ServletContext ����
		// ����������� webӦ�� ���Ժͳ��������������������ͨ��
		// ���ܣ�
//		      1.��ȡMIME����
//		      2.�����
//		      3.��ȡ�ļ�����ʵ����������·��  
		
		
		//1.ͨ��request�����ȡ  ���ַ�ʽ��ȡ��һ��
		ServletContext context1 = request.getServletContext();
		
		
		
		
		//2.ͨ��HttpServlet�����ȡ
		
		ServletContext context2 = this.getServletContext();
		
		
		
		
		
//����             1.��ȡMIME����
//		        *MIME���ͣ������ڻ�����ͨ�Ź����ж����һ����������
//		                         ��ʽ    ������/С����           �� text/html�����ı��ģ�html��ʽ��  ��׼��MIME����        �� image/jpeg    ����������ļ�����
		
//		     ��ȡ������String getMimeType(String file);
		
		 //����һ���ļ�����
		   String filename = "a.jpg";
		
		 //��ȡMIME����
		   String mimeType = context2.getMimeType(filename);
		   System.out.println(mimeType);    //image/jpeg
		
		   
		   
//		  2.����� 
//		      ������********������������е�    
//		    1.setAttribute(String name,Object value)  
//		    2.getAttribute(String name)
//		    3.removeAttribute(String name)

//		  ServletContext��  ����Χ��     ServletContext����������������   ������ ��ȡ�����������û����������
		   
//		     ���ù�������
		  context1.setAttribute("msg", "��һ��ServletContext�����ʹ�ò�������������������������");      
		   
		   
		   
		   
		   //��̬·��
//		  3.��ȡ�ļ�����ʵ����������·��        ��Ŀ��Դ �ļ��ᵽԶ�̷�����      
//		   ʹ��ervletContext�ķ���
		  
//		     getRealPath();
		   
		   //��ȡ�ļ�������·��
		   String realPath = context1.getRealPath("/a.html");//webĿ¼���ļ�����   
		   System.out.println(realPath);//D:\Myjava\javawebdemo\javawebb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\javae\a.html
		   File file = new File(realPath);      //���Լ����ļ����ص��ڴ�
		   
		   
		   String webInf = context1.getRealPath("WEB-INF/b.txt");   //WEB-INF����Դ����
		   System.out.println(webInf);
		   
		   
		   String webInf1 = context1.getRealPath("WEB-INF/classes/b.txt"); //src ��·������
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	
	
	}

}
