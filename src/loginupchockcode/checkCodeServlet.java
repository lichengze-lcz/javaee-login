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


//生成一个简单的验证码，存到Session中，会话到校验页面

@WebServlet("/checkCodecopyucp")
public class checkCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取一个验证码
		int width = 100;                      
		int height = 50;

		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);    //RGB 三元素图片
		
		Graphics g = image.getGraphics();
		
		//简单画个验证码
		g.setColor(Color.pink);
		
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.blue);     //用蓝色的画笔画边框颜色
		
		g.drawRect(0, 0, width-1, height-1);      //边框默认一个像素    不-1 会少两条
		
		String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
		
		Random ran = new Random();
	     
//		将生成的码值，存到Session里           在校验类中请求验证码的参数  与 保存在Session里的码值 进行比较 
		
	
		StringBuilder sb = new StringBuilder();
	    for(int i =1; i<= 4; i++) {
	    	
	    int index = ran.nextInt(str.length());   //随机角标   index
		char ch = str.charAt(index);
		
		//每生成一个码值，就把他存到字符串容器里
		sb.append(ch);
		
		g.drawString(ch+"", width/5*i, height/2);
		
	    }
	    //程序生成的验证码值
	    
        String checkCodeSession01 = sb.toString();	    
	    //将验证码存入Session 实现数据共享
        
   
        
        request.getSession().setAttribute("checkCodeSession02",checkCodeSession01);
        System.out.println("简单记录一下随机的验证码："+checkCodeSession01);
	    
        
        
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
