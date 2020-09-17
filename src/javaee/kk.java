package javaee;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class kk
 */
@WebServlet("/kk")
public class kk extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.�������ӿͻ��˻�ȡ Cookie �õ�����     �ٴ���Ӧʱ    (�ͻ��˸�������Cookie)//Cookie
		
		
		//�������ı���
		response.setCharacterEncoding("GBK");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type", "text/html;charset=GBK");

		
		
		Cookie[] cookies =request.getCookies();  
		boolean flag = false;  //����û��cookie Ϊlasetime

		//���б���   

		if(cookies!=null && cookies.length>0) {
			for(Cookie c:cookies) {       
		  
		   //��ȡ cookie����	
			String name = c.getName();    
			
		   //�ж������Ƿ��У�lasttime
			if("lasttime".equals(name)) {
				//�и�Cookie  ���ǵ�һ�η���
				flag = true;  //�����ҵ�Cookie 
				
				//����Cookie��value ��ǰʱ���    ��������Cookie��ֵ�����·���Cookie
				Date date = new Date();
				//�ĳ��й�ʱ���ʽ
				SimpleDateFormat sdf = new SimpleDateFormat("yyy��MM��dd�� HH:mm:ss");
				//������ʽ
				String str_date = sdf.format(date);
				
				System.out.println("����ǰ�ģ�"+str_date);
				
				
				//URL�����������������
				str_date = URLEncoder.encode(str_date,"utf-8");
				
				System.out.println("������"+str_date);
				
				
				
				//����Valueֵ  �� ʱ��
			    c.setValue(str_date);
				//����cookie  ���·��ͻ�ȥ   �����ƻ���lasttime ֵ����
			    
			    //����cookie���ʱ��
			    c.setMaxAge(60*10);
			    
			    response.addCookie(c);
			    
			    
				//��Ӧ����
				//��ȡcookie����value ��ʱ�䣩
				String value =c.getValue();
				
				
				
				
				System.out.println("����ǰvalue"+value);
				//URL����
				value = URLDecoder.decode(value,"utf-8");
				System.out.println("�����value"+value);
				
				response.getWriter().write("��ӭ���������ϴη��ʵ�ʱ��Ϊ��"+value);
				
				break;
			   }
			 }
		}



		//û�ҵ�Cookie
		if(cookies == null || cookies.length == 0|| flag == false) {

			 //û�ҵ���Ҫ��¼��һ��ʱ��
			 
			//����Cookie��value ��ǰʱ���    ��������Cookie��ֵ�����·���Cookie
			Date date = new Date();
			//�ĳ��й�ʱ���ʽ
			SimpleDateFormat sdf = new SimpleDateFormat("yyy��MM��dd�� HH:mm:ss");
			
			//������ʽ
			String str_date = sdf.format(date);
			
			

			Cookie c= new Cookie("lasttime","str_date"); //�����""
		    		
		    
		    
		 //URL�����������������
			str_date = URLEncoder.encode(str_date,"utf-8");  	    
		    
		    //����cookie���ʱ��
		    c.setMaxAge(60*10);
		    
		    //����
		    response.addCookie(c);
			 
			 
			response.getWriter().write("��ӭ�״η���"); 
			 
			 
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
