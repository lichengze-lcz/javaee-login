package javaee;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//�ְ���
//�������ֻ��service    �� Httpservlet �ĸ��࣬    ��ʵ����ô����


public class generiservlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GenericServlet");
	}

}
