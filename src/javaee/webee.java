package javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 
 * Servlet接口----GenericServlet抽象类--------HttpServlet抽象子类
 * 
 * 
 * 优点
 *  * HttpServlet 不用总是请求 那种弹出页面（post/get）
 * 
 * 方法：service
 *      0.判断请求方式（post、get）
 *        String method = ruq.getmethod();
 *        
 *        if（method）{
 *           doGet（）
 *        }else{
 *           dopost()
 *        }
 *      
 *   
 *      默认  请求是doget 方式
 * HttpServlet：对http协议的一种封装，简化操作
 *   1.定义类 简化HttpServlet
 *   2.复写 doGet（）或者 doPost（）     
 *      
 *      
 *      
 *      
 *      1.
 * 
 * 
 * 
 * 
 * 
 * 
 */
@WebServlet("/webee")
public class webee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("lalalalall/webee执行啦lalalallalll");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		 //演示Cookie 跨web项目 
		 
//		   3.服务器从客户端获取 Cookie 拿到数据     再次响应时    (客户端给服务器Cookie)
          Cookie[] cs =request.getCookies();  //Cookie[]数组  拿到所有的Cookie， 进行遍历   
          //进行遍历   
          
          if(cs!=null) {
         	 for(Cookie c:cs) {       //Map 结构存储
             //返回每个、Cookie对象  
         	// 要拿到所有的名称和值 
         	String name = c.getName();     //name  是 存储名  msg     
         	String value = c.getValue();   //value 是 存储内容  This is
         	System.out.println(name+":"+value);
         		 
         	 }
          }
		
		System.out.println("doPost");
	}

}
