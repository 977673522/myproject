package grade.DB;//ͬһ���ļ����£�������������ĵ���
//�������������ݿ�
//import java.sql.*;
import java.sql.Connection;	//����sql���ݿ����Ӱ��������������ݿ������Ҫ�İ�
//import grade.VIEW.LOGIN;
import java.sql.DriverManager;		//����sql���ݿ������������ݿ��������Ҫ������֧��
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;		

//����java database connection
/**
 * this is jdbc connect database
 * now, using oracle db ,user and password needed change
 * @author nwx
 *
 */
public class TestJDBC {
  Connection con ;				//�����������ݿ����
  String user = "ni" ;			//���ӵ��û�
  String password = "ni" ;		//���ӵ��û�����
  String className = "oracle.jdbc.driver.OracleDriver" ;		//oracle��������
  //String url = "jdbc:oracle:thin:@192.168.1.101:1521:nwx" ;		//����IPv4,IPv4���������������У���λ���ݿ�Ͷ˿�
  String url = "jdbc:oracle:thin:@localhost:1521:orcl" ;		//������λ���ݿ�Ͷ˿�
  
  public TestJDBC(){
	  this.ConnectOracle();					//�����������oracle��������һ(��������)
	  this.getCon();							//�����������oracle���������(�������ݿ�)
	  this.closed();							
	  //����ر�(��Ҫ�ɲ�Ҫ���ر��൱���ͷ���Դ���൱����֮ǰ������һ�����õ�VIP,��ô�ҿ��Ժ����Ժ�����м���VIP�Ļ
  }
  
  //������������
  public void ConnectOracle() {
  	//�쳣����
         try {
               Class. forName(className);
               //JOptionPane.showMessageDialog(null,"��ϲ�������ݿ������ɹ�");
               //System. out.println("�������ݿ������ɹ���" );
        } catch (ClassNotFoundException e ) {
        		//JOptionPane.showMessageDialog(null,"�������ݿ�����ʧ�ܣ�����Ŭ����");
               // System. out.println("�������ݿ�����ʧ�ܣ�" );
                e.printStackTrace();
        }
 }

  //�������ݿ����� 
  public Connection getCon() {
  	//�쳣����
         try {
                con = DriverManager. getConnection(url, user, password);
                //  JOptionPane.showMessageDialog(null,"��ϲ�������ݿ����ӳɹ�");
                // JOptionPane.showMessageDialog(null,"����е�¼����");
                //  System. out.println("�������ݿ����ӳɹ���" );
                // con.close();
                // new LOGIN();
        } catch (SQLException e ) {
               System. out.print(con );
               JOptionPane.showMessageDialog(null,"�������ݿ�����ʧ�ܣ������Ŭ��");
                con = null;
                e.printStackTrace();
        
        }
         return con ;//�������������ݿ�Ķ���
 }

  //�ر�
  public void closed() {
  	//�쳣����
         try {
                if (con != null) {		//if����Ϊ�������
                      con.close();		//�ر��������ݿ����
               }
        } catch (SQLException e ) {
              // System. out.println("�ر�con����ʧ�ܣ�" );
                e.printStackTrace();		
        }
 }
}

//�������������ݿ�Ĵ������ֲ���һЩ��ɾ�Ĳ�ķ������룬�Ա���ͼ�����п��Ե���
 /* 
  	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;//�����������ݿ����
//1.��ѯ
		public ResultSet queryExectue(String sql,String []paras)
		{
			try {
							
				//1.��������
				Class.forName(className); 
				//2.�õ�����	
				ct=DriverManager.getConnection(url,user,password);
				//3.����ps
				ps=ct.prepareStatement(sql);
			    //��ps���ʺŸ�ֵ
				for(int i=0;i<paras.length;i++)
				{
					ps.setString(i+1, paras[i]);
				}
							
				rs=ps.executeQuery();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					//�ر���Դ???
										
				}
				return rs;								
				}
						
	//�Ѷ����ݿ����  ɾ	�ģ���дһ������
	public boolean exeUpdate(String sql,String[]paras)
	{
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			//��sql�Ĳ�����ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			b=false;
			e.printStackTrace();		
		}
		return b;
	}
	//�õ��������rs
	public ResultSet query(String sql,String paras)
	{
		try {
			ps=ct.prepareStatement(sql);
			int i=0;
			ps.setString(i+1,paras);
			rs=ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}*/