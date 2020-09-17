package javaee;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet({"/demo4","/d4","/d44"})
public class httpServletdemo extends HttpServlet{

	
	/**
	 * request:
	 *   1.request和reponse 对象原理
	 *     1.request 和 response对象是由服务器创建，我们来使用它
	 *     2，request 对象是获取请求消息，  response对象来设置响应消息
	 *   
	 *   
	 *    request:对象结构体系
	 *         ServletRequest  接口
	 *               |
	 *         HttpServletRequest  接口
	 *               | 实现 
	 *         org.apache.catalina.connection.RequestFacade  实现类（tomcat）
	 *   
	 *         request 请求
	 *   2.获取请求消息 四部分   头 体  
	 *   
	 *   2.功能
	 * 
	 *         1.获取请求消息数据      四部分 
	 *             1.请求行数据： 
	 *                  Get/ day14/demo1/  name="zhangsan"
	 *                  2 个请求

                                          请求网址:http://localhost:9999/javae/webee
                                           请求方法:GET
                                           远程地址:[::1]:9999
                                           状态码:200      
                                           版本:HTTP/1.1
                                           
                                           
	 *                  1.请求方式：Get     String getMethod（）；
	 *                  
	 *                  2.***获取虚拟目录javae         String getContextPath()
	 *                  
	 *                  3.获取Servelt路径 /demo1     getServeltPath()    
	 *                  
	 *                  4.获取get方式请求参数  name = zhangsan     String getQureyString
	 *                  
	 *                  5.***获取 URI  day14/demo1
	 *                       String   getRequestURl（）           day14/demo1
	 *                       Stringbuffer   getRequestURl    http:// day14/demo1
	 *                  6.获取版本协议:   HTTP/1.1     
	 *                       String getprotocol（）
	 *                       
	 *                  7.获取客户机的IP地址   getRemoteAddr()
	 *                            
	 *                  
	 *             2.请求头数据：
	 *                   方法
	 *                     String getHeader（String name）：通过头名称获取头值
	 *             
	 *             
	 *             
	 *             3.请求体数据
	 *                   只有post请求方式，才有请求体 request请求体封装了post请求参数
	 *                      步骤：
	 *                       获取流对象
	 *                          BufferedReader getReader  获取缓冲字符输入流
	 *                          
	 *                          ServletInputStream getInputStream   获取字节输入流  （文件上传）
	 *                       再从流对象中拿数据
	 *   
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// 重写 doGet  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决post乱码问题               
		  request.setCharacterEncoding("utf-8");
		  
		response.getWriter().append("Served at:HttpServle  改虚拟路径 demo4........ ").append(request.getContextPath());
		
		System.out.println("HttpServle  改虚拟路径 demo4.........");
		
		
		
		 //1.请求方式：Get     String getMethod（）；
		             String method =  request.getMethod();
                      System.out.println(method);                   
		
		// *                  2.***获取虚拟目录javae         String getContextPath()
		                                   String contextpath =  request.getContextPath();
		                                   System.out.println(contextpath);
		                                  
		
		                   
		// *                  3.获取Servelt路径 /demo1     getServeltPath()    
		                                  String servelt = request.getServletPath();
		                                  System.out.println(servelt);
		                                  
		                                   
		                   
		// *                  4.获取get方式请求参数  name = zhangsan     String getQureyString
		                  
		 //*                  5.***获取 URI  day14/demo1
		                        String requesruri = request.getRequestURI();    
		                        System.out.println(requesruri);
		                       // Stringbuffer   getRequestURl    http:// day14/demo1
		 //*                  6.获取版本协议:   HTTP/1.1     
		                        String protocol = request.getProtocol();
		                        System.out.println(protocol);
		// *                  7.获取客户机的IP地址   getRemoteAddr()
		                      String rempteAdd = request.getRemoteAddr();
		                        System.out.println(rempteAdd);
		
		
		
//		                     2.***请求头数据：：通过头名称获取头值
		                   	     Enumeration<String> Headnames = request.getHeaderNames();
		                   	                    
//		                   	                    遍历    
		                    while(Headnames.hasMoreElements()){
		                   	    String name = Headnames.nextElement();
//		                   	      通过头名称获取头值
		                   	    String value = request.getHeader(name);
		                   	    System.out.println(name+"-------"+value);
		                   	                    	
		                   	                    }
		                   	                    
//  版本信息    user-agent-------Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0
//		  	               accept-------text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//		                   	                		accept-language-------zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//		                   	                		accept-encoding-------gzip, deflate
//		                   	                		connection-------keep-alive
//		                   	                		upgrade-insecure-requests-------1
//		                   	                		cache-control-------max-age=0 */ 
	                  	            
		                    
		                    
		
//		            8.演示请求数据    user-agent 用于解决兼容问题
                   String agent = request.getHeader("user-agent");
                     if(agent.contains("Chrome")) {
                    	 System.out.println("谷歌来啦----------------");
                     }else if(agent.contains("Firefox")){
                    	 System.out.println("火狐来啦============");
                     }
                   
                   
//                  9. 获取请求头数据 referer （在哪个网站来的）
                     
                     String referer = request.getHeader("referer");
                     System.out.println(referer);  //http://localhost:9999/javae/index.html
                    	 
                    
                    	 
//                  10.防盗链
                    	 if(referer != null) {
                    		 if(referer.contains("/javae")) {
                    			 System.out.println("播放");
                    		 }else {
                    			 System.out.println("盗链");
                    		 }
                    	 }
		
                    	 
                    	 
		
//		1.其他功能******************************
                    	 
  System.out.println(" 1.获取请求参数通用方式----------------------------------------------------------------------");
//          1.获取请求参数通用方式 post 和 get 都兼容

  
//                   1、根据参数名获取参数值
                          String usename1 = request.getParameter("username");
                          System.out.println(usename1+"----------------  1、根据参数名获取参数值");
                    	 
                    	 
//                   2.根据参数获取参数值得数组 （复选框）
  /*                        String[]  hobby = request.getParameterValues("hobby");   //爱好
                          for(String hobbies: hobby) {
                        	  System.out.println(hobbies+"-------------  2.根据参数获取参数值得数组 （复选框）");
                          }
                          
//                   3.获取所有参数请求的名称    获取所有键的名称
                          Enumeration<String> parameterName = request.getParameterNames();
                          while(parameterName.hasMoreElements()) {
                        	  String name1 = parameterName.nextElement();
                        	  System.out.println(name1+"----------------3.获取所有参数请求的名称");
                        	  
                        	  String value = request.getParameter(name1);       //数组形式会输所有复选框值， 但有地址值
                        	  
                        	  
                        	  System.out.println(value+"-------参数名称");
                        	  
                          }
                          
                          
*/   //               4.获取所有参数，封装成Map集合
                         java.util.Map<String, String[]> map= request.getParameterMap();
                       Map<String, String[]>  parameteMap1 = (Map<String, String[]>) request.getParameterMap();
                        
                       Set<String> keyset =((java.util.Map<String, String[]>) parameteMap1).keySet(); 
                       
                       
                       
                       
                       for(String name:keyset) {                   	   
                    	   
                    	   //通过键获取值
                    	    String []values = ((java.util.Map<String, String[]>) parameteMap1).get(name);
                    	         System.out.println(name);
                    	         
                    	         for(String value:values) {
                    	        	 System.out.println(value);
                    	        	 
                    	         }
                    	   System.out.println("-----------------------");
                       }
                      
                    	 
                    	 


//            2.请求转发                      
                          
               //获取共享的数据
                    Object mes = request.getAttribute("meg");
                    System.out.println(mes);      
                          
                          
                          
                    	 
                    	
		
		
		
		
		
		
		
		
		
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
	        System.out.println("post请求方式执行啦-------------------------------------------------------------");
			
	        
	        //获取请求消息体-----请求参数
	        //获取字符流
	       BufferedReader br = request.getReader();
	        
	       //读取数据
	       String line = null;
	       while((line = br.readLine()) != null) {
	    	   System.out.println(line);
	       }
			
			
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
