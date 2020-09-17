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
		
		
		
		System.out.println("我就试一下dPost有没有执行");
		
		
		//获取验证码
		
		//1.创建一个对象，在内存中的图片（验证码图片对象）    输出流图片对象  
		
		int width = 100;                      
		int height = 50;
		
		//有三个参数 宽 高  图片类型（图片类型 有常量）                  初始图片 black
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);    //RGB 三元素图片
		
		
		
		//2.美化图片
		//2.1 填充背景
		//获取画笔对象  进行美化
		Graphics g = image.getGraphics();
		
		//设置画笔颜色
		g.setColor(Color.pink);
		
		//参数   从图片  0 点 到 0点     填充宽高
		g.fillRect(0, 0, width, height);
		
		
		//2.2 画一个边框
		g.setColor(Color.blue);     //用蓝色的画笔画边框颜色
		g.drawRect(0, 0, width-1, height-1);      //边框默认一个像素    不-1 会少两条
		
		
		//2.3写验证码code
		
		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
		//生成随机角本标 
		Random ran = new Random();
	   
	     
	    for(int i =1; i<= 4; i++) {
	    	
	    int index = ran.nextInt(str.length());   //随机角标   index
	    //获取随机字符	
		char ch = str.charAt(index);
		
		//参数  要写的值，   值位置x坐标  Y坐标
		g.drawString(ch+"", width/5*i, height/2);
		
	    }
	    
	    //2.4画 随机干扰线
	    g.setColor(Color.green);
	    
		
	    for(int i = 1; i <= 6; i++) {
	    int x1 = ran.nextInt(width); //width 是100 在100内随机   在 
	    int x2 = ran.nextInt(width);
	    int y1 = ran.nextInt(height);
	    int y2 = ran.nextInt(height);
	   
	    g.drawLine(x1, x2, y1,y2);
	    }
	   
		
		//3.将图片输出到页面展示    图片生成到内存里了 要输出到客户端，要借助对象 ImageIO. write方法
		 // 参数  输出图片，名     图片类型    输出流      该流（输出到浏览器）    
		 ImageIO.write(image, "jpg", response.getOutputStream());
		
		 
		
	}

}
