package loginupchockcode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.support.DaoSupport;

/**
 * Servlet implementation class LoginServlet
 */
//简单的检验登录数据

@WebServlet("/LoginSupc")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setCharacterEncoding("GBK");
		//告诉浏览器发送消息的编码   让浏览器解码
		response.setHeader("content-type","text/html;charset=GBK");
		
		
		//2.获取请求参数---用户名 和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		
		//3.封装user对象
		User loginuser = new User();
		
		//把 输入的参数 用户名 密码  传递给 user  
		loginuser.setUsername(username);
		loginuser.setPassword(password);
		
		//4.调用Userdao的login方法               与后台数据库的信息  进行校验
		Userdao dao = new Userdao();
		
		//创建一新的 User 对象，初始没有值
		User user = dao.login(loginuser);   //用 Userdao    login方法   传递loginuser  返回 User对象   （真正的User对象）//查询到的user
		
		
//		先获取生成的验证码
		HttpSession session1 = request.getSession();
		
		String checkCodeSession03=(String) session1.getAttribute("checkCodeSession02");//强转成字符串 为了输入参数验证码与系统验证码比较
		
		//一次性验证码（删除Session中存储的验证码）退回上一层页面输入密码登录无效
		session1.removeAttribute("checkCodeSession02");
		
		
		
		System.out.println("简单的打印一下这个随机的验证 "+checkCodeSession03);
		if(checkCodeSession03 != null && checkCodeSession03.equalsIgnoreCase(checkcode)){ //忽略大小写
	    	 //验证码一致
	    	 //判断用户名和密码
			
			
			
         if(user != null) {
	    		 //登录成功
	    		 //存储信息，用户信息
	    		 session1.setAttribute("user",username); //重定向不是一次页面网址发生改变,进入成功页面
	    		 //重定向 到登录成功页面 
	    		 System.out.println("zenmomjibqiue3");
	    		 response.sendRedirect(request.getContextPath()+"/success.jsp");
	    		 
	         }else {
	    		 request.setAttribute("pweror","用户名或密码错误，请重新输入"); //转发：域名不发生改变，继续输入
		    	 //转发到jsp登录页面
		    	 request.getRequestDispatcher("logincheckcode.jsp").forward(request, response);
		    	 
	    	 }
	    	 
		}else{
	    	 //验证码不一致
	    	 //将储存信息提示到resquest
	    	 request.setAttribute("cceror","验证码错误，请输入正确的验证码");
	    	 //转发到jsp登录页面
	    	 request.getRequestDispatcher("logincheckcode.jsp").forward(request, response);
	     }
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
