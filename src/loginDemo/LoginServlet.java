package loginDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.support.DaoSupport;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type","text/html;charset=GBK");
		
		
		//2.获取请求参数---用户名 和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//3.封装user对象
		User loginuser = new User();
		
		//把 输入的参数 用户名 密码  传递给 user  
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		
		//4.调用Userdao的login方法               与后台数据库的信息  进行校验
		Userdao dao = new Userdao();
		
		//创建一新的 User 对象，初始没有值
		User user = dao.login(loginuser);   //用 Userdao    login方法   传递loginuser  返回 User对象   （真正的User对象）//查询到的user
		
		
		
//		5.判断 user 对象 数据
		if(user == null) {//==null   user为空 登录失败
			//没查到 登录失败      //转发   跳转 页面
			request.getRequestDispatcher("/fail").forward(request, response);
			
		}else{
			//查到登录成功
			//存储数据     存用户名
			request.setAttribute("user",user);
			
			//转发
			request.getRequestDispatcher("/Success").forward(request, response);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
