package loginDemo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/*BeanUtils 工具类，简化数据封装
   1.用于封装javaBean     
        1javaBean标准的工具类 ：    1类必须被public 修饰  2必须提供空参的构造器 3成员变量必须使用private修饰4提供公共的set、get  功能：封装数据         
        
        2. 概念： 成员变量
                              属性： setter 和 getter截取后的产物         
                                例如 getUsername（） ---》 Username ---》 属性：usename

        3.方法
           1.setProperty   操作的是属性  给属性赋值
           2.getPropery
           3.*populate     （Object obj,Map map） 将Map集合键值对信息，封装到对应的javaBean对象中  自动解析Map  建当做属性名称。值当做javaBean对应的属性值
                  BeanUtils.populate(loginuser,map);  该方法一调用  就会把 参数封装到map集合中     


*/




@WebServlet("/LoginBeanUtils")
public class LoginBeanUtils extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("gbk");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type","text/html;charset=gbk");
		

		//2.使用 bean utils 获取所有请求参数
		  Map<String, String[]> map = request.getParameterMap();
		
		//3.创建一个User 对象  空的
		  User loginuser = new User();
		  
		//3.2使用beanUtils 封装          用 apache的BeanUtils      
		try {
			BeanUtils.populate(loginuser,map);     //参数是 javaBean  和 map集合    *** 该方法一调用  就会把 参数封装到map集合中
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//4.调用Userdao的login方法               与后台数据库的信息  进行校验
		Userdao dao = new Userdao();
		
		//创建一新的 User 对象，初始没有值
		User user = dao.login(loginuser);   //用 Userdao    login方法   传递loginuser  返回 User对象   （真正的User对象）//查询到的user
		
		
		
//		5.判断 user 对象 数据
		if(user == null) {//==null   user为空 登录失败
			//没查到 登录失败      //转发   跳转 页面
			request.getRequestDispatcher("/fail").forward(request, response);
			
		}else {
			//查到登录成功
			//存储数据     存用户名
			request.setAttribute("user",user);
			
			//转发
			request.getRequestDispatcher("/Success").forward(request, response);
			
		
		
		
		
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
