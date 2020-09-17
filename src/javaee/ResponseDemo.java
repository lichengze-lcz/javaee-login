package javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 *      响应数据格式 
 *          1.响应行
 *          2.响应头
 *          3.响应空行
 *          4.响应体
 *          
 *          
 *          
 *          1.响应行
 *               组成：
 *               1.协议和版本HTTP/1.1  
 *               2.响应状态码 状态码:200       服务器告诉客户端浏览器本次请求的和响应的一个状态
 *                   （1）状态码是三位数字
 *                   （2）分类
 *                       1xx： 消息 100多  服务器接收客户端消息， 但消息没有发完，等待一段时间，发送100多状态码， 询问：客户端你还发现消息吗
 *                       2xx: *请求和响应是  成功的
 *                       3xx： 重定向。  资源跳转的方式  重定向（与request转发相似）
 *                            Demo302 浏览器找客户端A  A说办不了。根浏览器说302 c应该可以重定向到C，于是浏览器去找c 回车一下访问两个资源
 *                            Demo304 浏览器访问客户端同一资源是，会缓存本地，在次访问 客户端说304 你本地有    
 *                       4xx：客户端错误  404：请求路径代表没有资源路径 
 *                                   405：请求方式没有请求的方法 无 doGet/post
 *                       5xx：服务器内部出现异常   doGet/post服务器端错误
 *                    
 *                    （3）.状态码描述 ok
 *                 
 *                 
 *                 
 *          2.响应头： 
 *              组成： 头名称： 对应值                    content-encoding	gzip        
 *                 
 *              1.常见的响应头  
 *                  content-type：服务器告诉浏览器客户端 响应体数据格式以及编码格式   text/css; charset="utf-8"      浏览器按格式自动解析代码      lenth 长度
 *                  content-disposttion 服务器告诉客户端 什么格式打开响应数据
 *                     值 ：
 *                        *in-line 默认值 在当前浏览器展示
 *                        *attachment 以附件形式打开响应体； filename = xxx 弹框框 文件下载
 *                 
 *                 
 *          4.响应体：真实传输的数据
 *          
 *          
 *          response对象：
 *            功能 设置响应消息
 *               设置响应行
 *                   设置状态码：    setStatus（int sc）
 *               
 *               设置响应头
                     setHeader（String name， String value）
         
                                               设置响应体
 *                   获取输出流（输出到浏览器）
 *                     字符输出流： PrintWriter getWriter()
 *                     字节输出流： ServletOutputStream getOutputStream()  
 * 
 * 
 * 
 */
@WebServlet("/RDemo")
public class ResponseDemo extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		System.out.println("Demo被访问了");
		//重定向： 访问  /RDemo资源   会跳转到 /RDemo2资源
		
		//动态获取虚拟目录
		String contextPath = request.getContextPath();
		System.out.println(contextPath);  
		//1.设置状态码为 302
		 response.setStatus(302);
		
		//2.设置响应头location
		 //response.setHeader("location",contextPath+"/RDemo2"); //资源地址      应该加虚拟路径   动态虚拟路径
		
		
		//简单方法
		//response.sendRedirect(地址);
		 
		 
	//跟转发特点相反   foeward   dic    
/*		 特点
		  1.地址栏发生改变
		  2.转发只能访问当前服务器下的资源                     重定向可以访问其他站点（服务器资源）
		  3.重定向是两次请求       因此不能使用resquest对象域 共享数据   1
		 
*/		 
		 
		 
		 
   /*路径写法
    *    ../上一级
    *    ./当前
    * 
		判断 路径 给谁用的       判断请求从哪发出
		 1.给客户端用的：需要加 虚拟目录  （项目的访问路径）  重定向  form   a            建议 路径动态获取
		 2.给服务器用： 不需要加虚拟目录  例如准发
		 
		 
		 
	*/	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置流的编码
				response.setCharacterEncoding("gbk");
				
				//告诉浏览器发送消息的编码   让浏览器解码
				response.setHeader("content-type", "text/html;charset=gbk");
      //获取字符输出流
		PrintWriter pw = response.getWriter();

      //输出数据
		pw.write("hello resquest lichengze您请求的·数据是中文");   //流自动刷新   里面可以写html
		
		
		
		
		
	}

}
