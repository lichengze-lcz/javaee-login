package servletcontext;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileDowload
 */
@WebServlet("/fileDowload")
public class fileDowload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		

		
		//*�����ļ���������
		                   //������ͼƬ�ܹ�չʾ  �����������               ��Ƶ����ֱ�ӱ����������  ������ܻ�����
//		  1.ҳ����ʾ������
//	      2.��������Ӻ󵯳����غʹ���ʾ��
//		  3.ʹ����Ӧͷ������Դ�򿪷�ʽ
		
		
		//����     �û�����web (html)ҳ��   html ҳ���  ͼƬ����Ϊ����  ���ݸ�������       �������ҵ�����Դ��
//		����
//		 1����ҳ��,�༭������ href ����,ָ��Servlet   ������Դ���� filename            ������  (����������� ��Դʱ ָ�����������)
		
//		 2.���� Servlet
//		    ����
		     
		     //1��ȡ�������  ���ļ�����
		     String filename =request.getParameter("filename");
		    
		     System.out.println(filename);
		     //2�ҵ���������ʵ·��   ʹ�� �ֽ����������ڴ�
		     ServletContext context1 = this.getServletContext();
		     
		     String realPath =  context1.getRealPath("/img/"+filename); //��ȡ�ļ�·��    ͼƬ·��
		     System.out.println(realPath);
		      //2.2���ֽ�������  ���ؽ��ڴ�
		     FileInputStream fis = new FileInputStream(realPath);
		     
		     
//		     3.����ָ��response����Ӧͷ�� content-disposition:attachment; filename=xxx      //����������ʾ��  	     
//		       1.������Ӧͷ���� content-type      ������������
		     
		        //ͼƬ image/jpeg     ��̬��ȡͼƬ����
		        String mimeType = context1.getMimeType(filename);     //��ǰ����������ļ�����    ������    �����ͼƬ�򲻿�����������     ������ʾ�򿪷�ʽ
		         response.setHeader("content-type  ",mimeType); 
		     
		     
		     
//		        2.������Ӧͷ��ʽ content-disposition              ���������߿ͻ��� ʲô��ʽ����Ӧ����
//		                      �����û�ֱ�Ӵ��ļ�����ʾ��
//		        *attachment �Ը�����ʽ����Ӧ�壻 filename = xxx ����� �ļ�����     psc22.jpg    �������Ƭ
		        response.setHeader("content-disposition","attachment;filename"+filename);    //filename  ���Ĳ�����   ��Ҫ������
		     
		     //�򿪺����Ƭ
		     //4.�������������� д���������                                            ���ļ�д���������
		      ServletOutputStream sos = response.getOutputStream();
		     //������
		      byte[] buff = new byte[1024*8];
		      int len = 0;
		      while( (len = fis.read(buff)) != -1 ) {
		    	  sos.write(buff,0,len);
		      }
		      
		      fis.close();
		     
		     
//		     3.ָ��response����Ӧͷ�� content-disposition:attachment; filename=xxx      //����������ʾ��  
		       
//		     4.������д��  ��respomse �����   ���
		
		
		
		
		
		
		
		
		
		
		
	}

}
