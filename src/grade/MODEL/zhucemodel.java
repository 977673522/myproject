//�ļ���
package grade.MODEL;
//����
import java.sql.*;
import javax.swing.JOptionPane;
//�����Լ���������İ�
import grade.DB.TestJDBC;
import grade.VIEW.LOGIN;
import grade.VIEW.zhuce;
//ע��ģʽ��
public class zhucemodel {
	//zc����
	public void zc(String id,String psw,boolean a){
		try{
			Connection conn=new TestJDBC().getCon();//�����������ݿ�Ķ���
			//1.a=true,ע�����Ա
			if(a==true){
				String sql="insert into M values(?,?)";//�������sql��䣨ʵ�ֲ������Ա�û������ַ���//�������Ա�˺š����뱣���ڱ�M��
				PreparedStatement pst = null;
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, psw);
			
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select ID FROM M ";//�����Ƿ��������û���
				s = conn.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
			
				while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
					if( rs.getString(i).equals(id)){
						JOptionPane.showMessageDialog(null,"�ù���Ա�û��Ѿ����ڣ�ע��ʧ��,������ע�ᣡ");
						conn.close();
						new zhuce();
					}
				}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"ע�����Ա�ɹ�,����������ݿ��в鿴���ע�����Ϣ");
					new LOGIN();		
		  }
			//2.ѧ��ע��
		  else{
			//�������sql��䣨ʵ�ֲ���ѧ���û������ַ���
			  String sql1="insert into LOGIN values(?,?)";//�������Ա�˺š����뱣���ڱ�M��
			  PreparedStatement pst1 = null;
			  pst1 = conn.prepareStatement(sql1);
			  pst1.setString(1, id);
			  pst1.setString(2, psw);
			  
			  Statement s1 = null;
			  ResultSet rs1 = null;
			  String sql_ck1 = "Select ID FROM LOGIN";
			  s1 = conn.createStatement();
			  rs1 = s1.executeQuery(sql_ck1);
			  int i=1;
			  while(rs1.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
				  if( rs1.getString(i).equals(id)){
					JOptionPane.showMessageDialog(null,"��ѧ���û��Ѿ����ڣ�ע��ʧ��");	
					conn.close();
					new zhuce();
				  }
			  }
				  pst1.executeUpdate();
				  JOptionPane.showMessageDialog(null,"ע��ѧ���û��ɹ�,����������ݿ��в鿴���ע�����Ϣ");
				  new LOGIN();
			}
		}catch (Exception ev) {}	
	}
}