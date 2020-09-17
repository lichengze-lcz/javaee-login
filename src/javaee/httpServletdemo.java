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
	 *   1.request��reponse ����ԭ��
	 *     1.request �� response�������ɷ�����������������ʹ����
	 *     2��request �����ǻ�ȡ������Ϣ��  response������������Ӧ��Ϣ
	 *   
	 *   
	 *    request:����ṹ��ϵ
	 *         ServletRequest  �ӿ�
	 *               |
	 *         HttpServletRequest  �ӿ�
	 *               | ʵ�� 
	 *         org.apache.catalina.connection.RequestFacade  ʵ���ࣨtomcat��
	 *   
	 *         request ����
	 *   2.��ȡ������Ϣ �Ĳ���   ͷ ��  
	 *   
	 *   2.����
	 * 
	 *         1.��ȡ������Ϣ����      �Ĳ��� 
	 *             1.���������ݣ� 
	 *                  Get/ day14/demo1/  name="zhangsan"
	 *                  2 ������

                                          ������ַ:http://localhost:9999/javae/webee
                                           ���󷽷�:GET
                                           Զ�̵�ַ:[::1]:9999
                                           ״̬��:200      
                                           �汾:HTTP/1.1
                                           
                                           
	 *                  1.����ʽ��Get     String getMethod������
	 *                  
	 *                  2.***��ȡ����Ŀ¼javae         String getContextPath()
	 *                  
	 *                  3.��ȡServelt·�� /demo1     getServeltPath()    
	 *                  
	 *                  4.��ȡget��ʽ�������  name = zhangsan     String getQureyString
	 *                  
	 *                  5.***��ȡ URI  day14/demo1
	 *                       String   getRequestURl����           day14/demo1
	 *                       Stringbuffer   getRequestURl    http:// day14/demo1
	 *                  6.��ȡ�汾Э��:   HTTP/1.1     
	 *                       String getprotocol����
	 *                       
	 *                  7.��ȡ�ͻ�����IP��ַ   getRemoteAddr()
	 *                            
	 *                  
	 *             2.����ͷ���ݣ�
	 *                   ����
	 *                     String getHeader��String name����ͨ��ͷ���ƻ�ȡͷֵ
	 *             
	 *             
	 *             
	 *             3.����������
	 *                   ֻ��post����ʽ������������ request�������װ��post�������
	 *                      ���裺
	 *                       ��ȡ������
	 *                          BufferedReader getReader  ��ȡ�����ַ�������
	 *                          
	 *                          ServletInputStream getInputStream   ��ȡ�ֽ�������  ���ļ��ϴ���
	 *                       �ٴ���������������
	 *   
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// ��д doGet  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���post��������               
		  request.setCharacterEncoding("utf-8");
		  
		response.getWriter().append("Served at:HttpServle  ������·�� demo4........ ").append(request.getContextPath());
		
		System.out.println("HttpServle  ������·�� demo4.........");
		
		
		
		 //1.����ʽ��Get     String getMethod������
		             String method =  request.getMethod();
                      System.out.println(method);                   
		
		// *                  2.***��ȡ����Ŀ¼javae         String getContextPath()
		                                   String contextpath =  request.getContextPath();
		                                   System.out.println(contextpath);
		                                  
		
		                   
		// *                  3.��ȡServelt·�� /demo1     getServeltPath()    
		                                  String servelt = request.getServletPath();
		                                  System.out.println(servelt);
		                                  
		                                   
		                   
		// *                  4.��ȡget��ʽ�������  name = zhangsan     String getQureyString
		                  
		 //*                  5.***��ȡ URI  day14/demo1
		                        String requesruri = request.getRequestURI();    
		                        System.out.println(requesruri);
		                       // Stringbuffer   getRequestURl    http:// day14/demo1
		 //*                  6.��ȡ�汾Э��:   HTTP/1.1     
		                        String protocol = request.getProtocol();
		                        System.out.println(protocol);
		// *                  7.��ȡ�ͻ�����IP��ַ   getRemoteAddr()
		                      String rempteAdd = request.getRemoteAddr();
		                        System.out.println(rempteAdd);
		
		
		
//		                     2.***����ͷ���ݣ���ͨ��ͷ���ƻ�ȡͷֵ
		                   	     Enumeration<String> Headnames = request.getHeaderNames();
		                   	                    
//		                   	                    ����    
		                    while(Headnames.hasMoreElements()){
		                   	    String name = Headnames.nextElement();
//		                   	      ͨ��ͷ���ƻ�ȡͷֵ
		                   	    String value = request.getHeader(name);
		                   	    System.out.println(name+"-------"+value);
		                   	                    	
		                   	                    }
		                   	                    
//  �汾��Ϣ    user-agent-------Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0
//		  	               accept-------text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//		                   	                		accept-language-------zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//		                   	                		accept-encoding-------gzip, deflate
//		                   	                		connection-------keep-alive
//		                   	                		upgrade-insecure-requests-------1
//		                   	                		cache-control-------max-age=0 */ 
	                  	            
		                    
		                    
		
//		            8.��ʾ��������    user-agent ���ڽ����������
                   String agent = request.getHeader("user-agent");
                     if(agent.contains("Chrome")) {
                    	 System.out.println("�ȸ�����----------------");
                     }else if(agent.contains("Firefox")){
                    	 System.out.println("�������============");
                     }
                   
                   
//                  9. ��ȡ����ͷ���� referer �����ĸ���վ���ģ�
                     
                     String referer = request.getHeader("referer");
                     System.out.println(referer);  //http://localhost:9999/javae/index.html
                    	 
                    
                    	 
//                  10.������
                    	 if(referer != null) {
                    		 if(referer.contains("/javae")) {
                    			 System.out.println("����");
                    		 }else {
                    			 System.out.println("����");
                    		 }
                    	 }
		
                    	 
                    	 
		
//		1.��������******************************
                    	 
  System.out.println(" 1.��ȡ�������ͨ�÷�ʽ----------------------------------------------------------------------");
//          1.��ȡ�������ͨ�÷�ʽ post �� get ������

  
//                   1�����ݲ�������ȡ����ֵ
                          String usename1 = request.getParameter("username");
                          System.out.println(usename1+"----------------  1�����ݲ�������ȡ����ֵ");
                    	 
                    	 
//                   2.���ݲ�����ȡ����ֵ������ ����ѡ��
  /*                        String[]  hobby = request.getParameterValues("hobby");   //����
                          for(String hobbies: hobby) {
                        	  System.out.println(hobbies+"-------------  2.���ݲ�����ȡ����ֵ������ ����ѡ��");
                          }
                          
//                   3.��ȡ���в������������    ��ȡ���м�������
                          Enumeration<String> parameterName = request.getParameterNames();
                          while(parameterName.hasMoreElements()) {
                        	  String name1 = parameterName.nextElement();
                        	  System.out.println(name1+"----------------3.��ȡ���в������������");
                        	  
                        	  String value = request.getParameter(name1);       //������ʽ�������и�ѡ��ֵ�� ���е�ֵַ
                        	  
                        	  
                        	  System.out.println(value+"-------��������");
                        	  
                          }
                          
                          
*/   //               4.��ȡ���в�������װ��Map����
                         java.util.Map<String, String[]> map= request.getParameterMap();
                       Map<String, String[]>  parameteMap1 = (Map<String, String[]>) request.getParameterMap();
                        
                       Set<String> keyset =((java.util.Map<String, String[]>) parameteMap1).keySet(); 
                       
                       
                       
                       
                       for(String name:keyset) {                   	   
                    	   
                    	   //ͨ������ȡֵ
                    	    String []values = ((java.util.Map<String, String[]>) parameteMap1).get(name);
                    	         System.out.println(name);
                    	         
                    	         for(String value:values) {
                    	        	 System.out.println(value);
                    	        	 
                    	         }
                    	   System.out.println("-----------------------");
                       }
                      
                    	 
                    	 


//            2.����ת��                      
                          
               //��ȡ���������
                    Object mes = request.getAttribute("meg");
                    System.out.println(mes);      
                          
                          
                          
                    	 
                    	
		
		
		
		
		
		
		
		
		
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
	        System.out.println("post����ʽִ����-------------------------------------------------------------");
			
	        
	        //��ȡ������Ϣ��-----�������
	        //��ȡ�ַ���
	       BufferedReader br = request.getReader();
	        
	       //��ȡ����
	       String line = null;
	       while((line = br.readLine()) != null) {
	    	   System.out.println(line);
	       }
			
			
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
