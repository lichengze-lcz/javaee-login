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
	
	
		

		
		//*案例文件下载需求
		                   //超链接图片能够展示  点击不会下载               视频不能直接被浏览器解析  点击可能会下载
//		  1.页面显示超链接
//	      2.点击超链接后弹出下载和打开提示框
//		  3.使用响应头设置资源打开方式
		
		
		//分析     用户访问web (html)页面   html 页面把  图片名作为参数  传递给服务器       服务器找到该资源打开
//		步骤
//		 1定义页面,编辑超链接 href 属性,指向Servlet   传递资源名称 filename            服务器  (在浏览器下载 资源时 指向服务器下载)
		
//		 2.定义 Servlet
//		    步骤
		     
		     //1获取请求参数  ，文件名称
		     String filename =request.getParameter("filename");
		    
		     System.out.println(filename);
		     //2找到服务器真实路径   使用 字节输入流进内存
		     ServletContext context1 = this.getServletContext();
		     
		     String realPath =  context1.getRealPath("/img/"+filename); //获取文件路径    图片路径
		     System.out.println(realPath);
		      //2.2用字节流关联  加载进内存
		     FileInputStream fis = new FileInputStream(realPath);
		     
		     
//		     3.设置指定response的响应头： content-disposition:attachment; filename=xxx      //弹出下载提示框  	     
//		       1.设置响应头类型 content-type      声明编码类型
		     
		        //图片 image/jpeg     动态获取图片类型
		        String mimeType = context1.getMimeType(filename);     //提前告诉浏览器文件类型    不告诉    浏览器图片打不开，可以下载     本地提示打开方式
		         response.setHeader("content-type  ",mimeType); 
		     
		     
		     
//		        2.设置响应头方式 content-disposition              服务器告诉客户端 什么格式打开响应数据
//		                      不设置会直接打开文件（提示框）
//		        *attachment 以附件形式打开响应体； filename = xxx 弹框框 文件下载     psc22.jpg    打开这个照片
		        response.setHeader("content-disposition","attachment;filename"+filename);    //filename  中文不可用   需要工具类
		     
		     //打开后的照片
		     //4.用输入流的数据 写到输出流中                                            把文件写出到浏览器
		      ServletOutputStream sos = response.getOutputStream();
		     //缓冲区
		      byte[] buff = new byte[1024*8];
		      int len = 0;
		      while( (len = fis.read(buff)) != -1 ) {
		    	  sos.write(buff,0,len);
		      }
		      
		      fis.close();
		     
		     
//		     3.指定response的响应头： content-disposition:attachment; filename=xxx      //弹出下载提示框  
		       
//		     4.将数据写出  用respomse 输出流   输出
		
		
		
		
		
		
		
		
		
		
		
	}

}
