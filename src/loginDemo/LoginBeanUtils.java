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


/*BeanUtils �����࣬�����ݷ�װ
   1.���ڷ�װjavaBean     
        1javaBean��׼�Ĺ����� ��    1����뱻public ����  2�����ṩ�ղεĹ����� 3��Ա��������ʹ��private����4�ṩ������set��get  ���ܣ���װ����         
        
        2. ��� ��Ա����
                              ���ԣ� setter �� getter��ȡ��Ĳ���         
                                ���� getUsername���� ---�� Username ---�� ���ԣ�usename

        3.����
           1.setProperty   ������������  �����Ը�ֵ
           2.getPropery
           3.*populate     ��Object obj,Map map�� ��Map���ϼ�ֵ����Ϣ����װ����Ӧ��javaBean������  �Զ�����Map  �������������ơ�ֵ����javaBean��Ӧ������ֵ
                  BeanUtils.populate(loginuser,map);  �÷���һ����  �ͻ�� ������װ��map������     


*/




@WebServlet("/LoginBeanUtils")
public class LoginBeanUtils extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("gbk");
		//���������������Ϣ�ı���   �����������
		response.setHeader("content-type","text/html;charset=gbk");
		

		//2.ʹ�� bean utils ��ȡ�����������
		  Map<String, String[]> map = request.getParameterMap();
		
		//3.����һ��User ����  �յ�
		  User loginuser = new User();
		  
		//3.2ʹ��beanUtils ��װ          �� apache��BeanUtils      
		try {
			BeanUtils.populate(loginuser,map);     //������ javaBean  �� map����    *** �÷���һ����  �ͻ�� ������װ��map������
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//4.����Userdao��login����               ���̨���ݿ����Ϣ  ����У��
		Userdao dao = new Userdao();
		
		//����һ�µ� User ���󣬳�ʼû��ֵ
		User user = dao.login(loginuser);   //�� Userdao    login����   ����loginuser  ���� User����   ��������User����//��ѯ����user
		
		
		
//		5.�ж� user ���� ����
		if(user == null) {//==null   userΪ�� ��¼ʧ��
			//û�鵽 ��¼ʧ��      //ת��   ��ת ҳ��
			request.getRequestDispatcher("/fail").forward(request, response);
			
		}else {
			//�鵽��¼�ɹ�
			//�洢����     ���û���
			request.setAttribute("user",user);
			
			//ת��
			request.getRequestDispatcher("/Success").forward(request, response);
			
		
		
		
		
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
