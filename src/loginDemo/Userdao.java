package loginDemo;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

//�������ݿ���useruser���е���
public class Userdao {
//	public static void main(String []args) {
	   JdbcUtils jdbcUtils=new JdbcUtils();
		JdbcTemplate template = new JdbcTemplate((DataSource) jdbcUtils.getDataSource());
	

	
//	��¼����
//	loginUser ֻ���û���������
//	���ص� user  �����û���ȫ������ 
	//����Ϣ�� User��
	public User login(User loginUser){      //������װ��һ������
		// 
		try {
			String sql = "select * from web51 where username =? and password =?";
			System.out.println("----------------");
	//���÷���ִ��sql	
     User user = template.queryForObject(sql,
    		 
    		        //�Ѳ�ѯ��������װ��һ��user ���� ������ʽ               У��ָ�� ����       //***У���û���������  ����ȱһ���ݿ�Ͳ鲻��       ���user����Ϊ�գ���½ʧ��
					new BeanPropertyRowMapper<User>(User.class),loginUser.getUsername(),loginUser.getPassword());
//	                User�Ķ������ѯ���������Զ�����ӳ��		
     
 	System.out.println(user);
 	System.out.println(loginUser.getUsername());
			
			return user;    //user �����û�ȫ�����ݣ�û�в�ѯ������null ��½ʧ��    //���ز鵽��  �û��� �������Ϣ   ��ֵ ��¼�ɹ�
			
		
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
