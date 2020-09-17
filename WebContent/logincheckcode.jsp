<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
window.onload = function(){
	 //1 获取图片对象
	var img = document.getElementById("img");
	 //2.绑定单机事件
	    img.onclick = function(){
		 
		 
		 var date = new Date().getTime();   //不让他加载浏览器缓存的那张图片， 欺骗浏览器
		 //设置img src 属性
		 img.src ="/javae/checkCodecopyucp?"+date
	 }
	 
}
</script>


<style> div{color:red}

</style>
</head>


<body>
        <%--三元表达式：输入提示信息--%>
       <div><%=request.getAttribute("cceror")== null ? "" :request.getAttribute("cceror") %></div>
       <div><%=request.getAttribute("pweror")== null ? "" :request.getAttribute("pweror") %></div>

       <form action="LoginSupc" method="post">
           <table> 
             <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
             </tr>
             
             <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
             </tr>
             
             <tr>
                <td>验证码</td>
                <td><input type="text" name="checkcode"></td>
             </tr>
             
             <tr>
                <td colspan="2"><img id="img" src="/javae/checkCodecopyucp"></td>
             </tr>
       
              <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
             </tr>      
       
       
       
       
           </table>
       
       </form>
       
       
      
       
       
       
</body>
</html>