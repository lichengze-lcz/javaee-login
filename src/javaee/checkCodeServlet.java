package javaee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Image;

/**
 * Servlet implementation class checkCodeServlet
 */
@WebServlet("/checkCode")
public class checkCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	
	
	
	
	}

	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println("�Ҿ���һ��dPost��û��ִ��");
		
		
		//��ȡ��֤��
		
		//1.����һ���������ڴ��е�ͼƬ����֤��ͼƬ����    �����ͼƬ����  
		
		int width = 100;                      
		int height = 50;
		
		//���������� �� ��  ͼƬ���ͣ�ͼƬ���� �г�����                  ��ʼͼƬ black
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);    //RGB ��Ԫ��ͼƬ
		
		
		
		//2.����ͼƬ
		//2.1 ��䱳��
		//��ȡ���ʶ���  ��������
		Graphics g = image.getGraphics();
		
		//���û�����ɫ
		g.setColor(Color.pink);
		
		//����   ��ͼƬ  0 �� �� 0��     �����
		g.fillRect(0, 0, width, height);
		
		
		//2.2 ��һ���߿�
		g.setColor(Color.blue);     //����ɫ�Ļ��ʻ��߿���ɫ
		g.drawRect(0, 0, width-1, height-1);      //�߿�Ĭ��һ������    ��-1 ��������
		
		
		//2.3д��֤��code
		
		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
		//��������Ǳ��� 
		Random ran = new Random();
	   
	     
	    for(int i =1; i<= 4; i++) {
	    	
	    int index = ran.nextInt(str.length());   //����Ǳ�   index
	    //��ȡ����ַ�	
		char ch = str.charAt(index);
		
		//����  Ҫд��ֵ��   ֵλ��x����  Y����
		g.drawString(ch+"", width/5*i, height/2);
		
	    }
	    
	    //2.4�� ���������
	    g.setColor(Color.green);
	    
		
	    for(int i = 1; i <= 6; i++) {
	    int x1 = ran.nextInt(width); //width ��100 ��100�����   �� 
	    int x2 = ran.nextInt(width);
	    int y1 = ran.nextInt(height);
	    int y2 = ran.nextInt(height);
	   
	    g.drawLine(x1, x2, y1,y2);
	    }
	   
		
		//3.��ͼƬ�����ҳ��չʾ    ͼƬ���ɵ��ڴ����� Ҫ������ͻ��ˣ�Ҫ�������� ImageIO. write����
		 // ����  ���ͼƬ����     ͼƬ����    �����      ������������������    
		 ImageIO.write(image, "jpg", response.getOutputStream());
		
		 
		
	}

}
