package loginupchockcode;

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
import javax.servlet.http.HttpSession;

import com.sun.prism.Image;


//����һ���򵥵���֤�룬�浽Session�У��Ự��У��ҳ��

@WebServlet("/checkCodecopyucp")
public class checkCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡһ����֤��
		int width = 100;                      
		int height = 50;

		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);    //RGB ��Ԫ��ͼƬ
		
		Graphics g = image.getGraphics();
		
		//�򵥻�����֤��
		g.setColor(Color.pink);
		
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.blue);     //����ɫ�Ļ��ʻ��߿���ɫ
		
		g.drawRect(0, 0, width-1, height-1);      //�߿�Ĭ��һ������    ��-1 ��������
		
		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
		
		Random ran = new Random();
	     
//		�����ɵ���ֵ���浽Session��           ��У������������֤��Ĳ���  �� ������Session�����ֵ ���бȽ� 
		
	
		StringBuilder sb = new StringBuilder();
	    for(int i =1; i<= 4; i++) {
	    	
	    int index = ran.nextInt(str.length());   //����Ǳ�   index
		char ch = str.charAt(index);
		
		//ÿ����һ����ֵ���Ͱ����浽�ַ���������
		sb.append(ch);
		
		g.drawString(ch+"", width/5*i, height/2);
		
	    }
	    //�������ɵ���֤��ֵ
	    
        String checkCodeSession01 = sb.toString();	    
	    //����֤�����Session ʵ�����ݹ���
        
   
        
        request.getSession().setAttribute("checkCodeSession02",checkCodeSession01);
        System.out.println("�򵥼�¼һ���������֤�룺"+checkCodeSession01);
	    
        
        
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
