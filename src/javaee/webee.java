package javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 
 * Servlet�ӿ�----GenericServlet������--------HttpServlet��������
 * 
 * 
 * �ŵ�
 *  * HttpServlet ������������ ���ֵ���ҳ�棨post/get��
 * 
 * ������service
 *      0.�ж�����ʽ��post��get��
 *        String method = ruq.getmethod();
 *        
 *        if��method��{
 *           doGet����
 *        }else{
 *           dopost()
 *        }
 *      
 *   
 *      Ĭ��  ������doget ��ʽ
 * HttpServlet����httpЭ���һ�ַ�װ���򻯲���
 *   1.������ ��HttpServlet
 *   2.��д doGet�������� doPost����     
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
		
		System.out.println("lalalalall/webeeִ����lalalallalll");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		 //��ʾCookie ��web��Ŀ 
		 
//		   3.�������ӿͻ��˻�ȡ Cookie �õ�����     �ٴ���Ӧʱ    (�ͻ��˸�������Cookie)
          Cookie[] cs =request.getCookies();  //Cookie[]����  �õ����е�Cookie�� ���б���   
          //���б���   
          
          if(cs!=null) {
         	 for(Cookie c:cs) {       //Map �ṹ�洢
             //����ÿ����Cookie����  
         	// Ҫ�õ����е����ƺ�ֵ 
         	String name = c.getName();     //name  �� �洢��  msg     
         	String value = c.getValue();   //value �� �洢����  This is
         	System.out.println(name+":"+value);
         		 
         	 }
          }
		
		System.out.println("doPost");
	}

}
