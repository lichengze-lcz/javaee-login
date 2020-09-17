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
 
		//ServletContext 对象
		// 概念：代表整个 web应用 可以和程序的容器（服务器）来通信
		// 功能：
//		      1.获取MIME类型
//		      2.域对象
//		      3.提取文件的真实（服务器）路径  
		
		
		//1.通过request对象获取  两种方式获取都一样
		ServletContext context1 = request.getServletContext();
		
		
		
		
		//2.通过HttpServlet对象获取
		
		ServletContext context2 = this.getServletContext();
		
		
		
		
		
//功能             1.获取MIME类型
//		        *MIME类型：这是在互联网通信过程中定义的一种数据类型
//		                         格式    大类型/小类型           例 text/html（纯文本的，html形式）  标准的MIME类型        例 image/jpeg    告诉浏览器文件类型
		
//		     获取方法：String getMimeType(String file);
		
		 //定义一个文件名称
		   String filename = "a.jpg";
		
		 //获取MIME类型
		   String mimeType = context2.getMimeType(filename);
		   System.out.println(mimeType);    //image/jpeg
		
		   
		   
//		  2.域对象 
//		      三个方********是所有域对象都有的    
//		    1.setAttribute(String name,Object value)  
//		    2.getAttribute(String name)
//		    3.removeAttribute(String name)

//		  ServletContext域  对象范围：     ServletContext域是所有域最大的域   他可以 获取、共享所有用户请求的数据
		   
//		     设置共享数据
		  context1.setAttribute("msg", "试一下ServletContext域可以使用不。。。。。。。。。。。。");      
		   
		   
		   
		   
		   //动态路径
//		  3.提取文件的真实（服务器）路径        项目资源 文件会到远程服务器      
//		   使用ervletContext的方法
		  
//		     getRealPath();
		   
		   //获取文件服务器路径
		   String realPath = context1.getRealPath("/a.html");//web目录下文件访问   
		   System.out.println(realPath);//D:\Myjava\javawebdemo\javawebb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\javae\a.html
		   File file = new File(realPath);      //可以加载文件加载到内存
		   
		   
		   String webInf = context1.getRealPath("WEB-INF/b.txt");   //WEB-INF下资源加载
		   System.out.println(webInf);
		   
		   
		   String webInf1 = context1.getRealPath("WEB-INF/classes/b.txt"); //src 下路径访问
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	
	
	}

}
