package javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 *      ��Ӧ���ݸ�ʽ 
 *          1.��Ӧ��
 *          2.��Ӧͷ
 *          3.��Ӧ����
 *          4.��Ӧ��
 *          
 *          
 *          
 *          1.��Ӧ��
 *               ��ɣ�
 *               1.Э��Ͱ汾HTTP/1.1  
 *               2.��Ӧ״̬�� ״̬��:200       ���������߿ͻ����������������ĺ���Ӧ��һ��״̬
 *                   ��1��״̬������λ����
 *                   ��2������
 *                       1xx�� ��Ϣ 100��  ���������տͻ�����Ϣ�� ����Ϣû�з��꣬�ȴ�һ��ʱ�䣬����100��״̬�룬 ѯ�ʣ��ͻ����㻹������Ϣ��
 *                       2xx: *�������Ӧ��  �ɹ���
 *                       3xx�� �ض���  ��Դ��ת�ķ�ʽ  �ض�����requestת�����ƣ�
 *                            Demo302 ������ҿͻ���A  A˵�첻�ˡ��������˵302 cӦ�ÿ����ض���C�����������ȥ��c �س�һ�·���������Դ
 *                            Demo304 ��������ʿͻ���ͬһ��Դ�ǣ��Ỻ�汾�أ��ڴη��� �ͻ���˵304 �㱾����    
 *                       4xx���ͻ��˴���  404������·������û����Դ·�� 
 *                                   405������ʽû������ķ��� �� doGet/post
 *                       5xx���������ڲ������쳣   doGet/post�������˴���
 *                    
 *                    ��3��.״̬������ ok
 *                 
 *                 
 *                 
 *          2.��Ӧͷ�� 
 *              ��ɣ� ͷ���ƣ� ��Ӧֵ                    content-encoding	gzip        
 *                 
 *              1.��������Ӧͷ  
 *                  content-type������������������ͻ��� ��Ӧ�����ݸ�ʽ�Լ������ʽ   text/css; charset="utf-8"      ���������ʽ�Զ���������      lenth ����
 *                  content-disposttion ���������߿ͻ��� ʲô��ʽ����Ӧ����
 *                     ֵ ��
 *                        *in-line Ĭ��ֵ �ڵ�ǰ�����չʾ
 *                        *attachment �Ը�����ʽ����Ӧ�壻 filename = xxx ����� �ļ�����
 *                 
 *                 
 *          4.��Ӧ�壺��ʵ���������
 *          
 *          
 *          response����
 *            ���� ������Ӧ��Ϣ
 *               ������Ӧ��
 *                   ����״̬�룺    setStatus��int sc��
 *               
 *               ������Ӧͷ
                     setHeader��String name�� String value��
         
                                               ������Ӧ��
 *                   ��ȡ�������������������
 *                     �ַ�������� PrintWriter getWriter()
 *                     �ֽ�������� ServletOutputStream getOutputStream()  
 * 
 * 
 * 
 */
@WebServlet("/RDemo")
public class ResponseDemo extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		System.out.println("Demo��������");
		//�ض��� ����  /RDemo��Դ   ����ת�� /RDemo2��Դ
		
		//��̬��ȡ����Ŀ¼
		String contextPath = request.getContextPath();
		System.out.println(contextPath);  
		//1.����״̬��Ϊ 302
		 response.setStatus(302);
		
		//2.������Ӧͷlocation
		 //response.setHeader("location",contextPath+"/RDemo2"); //��Դ��ַ      Ӧ�ü�����·��   ��̬����·��
		
		
		//�򵥷���
		//response.sendRedirect(��ַ);
		 
		 
	//��ת���ص��෴   foeward   dic    
/*		 �ص�
		  1.��ַ�������ı�
		  2.ת��ֻ�ܷ��ʵ�ǰ�������µ���Դ                     �ض�����Է�������վ�㣨��������Դ��
		  3.�ض�������������       ��˲���ʹ��resquest������ ��������   1
		 
*/		 
		 
		 
		 
   /*·��д��
    *    ../��һ��
    *    ./��ǰ
    * 
		�ж� ·�� ��˭�õ�       �ж�������ķ���
		 1.���ͻ����õģ���Ҫ�� ����Ŀ¼  ����Ŀ�ķ���·����  �ض���  form   a            ���� ·����̬��ȡ
		 2.���������ã� ����Ҫ������Ŀ¼  ����׼��
		 
		 
		 
	*/	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�������ı���
				response.setCharacterEncoding("gbk");
				
				//���������������Ϣ�ı���   �����������
				response.setHeader("content-type", "text/html;charset=gbk");
      //��ȡ�ַ������
		PrintWriter pw = response.getWriter();

      //�������
		pw.write("hello resquest lichengze������ġ�����������");   //���Զ�ˢ��   �������дhtml
		
		
		
		
		
	}

}
