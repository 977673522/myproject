package grade.MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
import grade.VIEW.manager;
public class tianjiamodel {
	Connection con=new TestJDBC().getCon();
	public void TIAN(String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11){
		try{
			if(!a1.equals("")){//���ѧ�Ų�Ϊ�գ��������
				String sql2="insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statl=null;
				//���֮ǰ�Ȳ�ѯ�Ƿ���һ����sno�����������ʾ�Ѵ��ڣ����ʧ�ܣ�������ӣ�
				System.out.println(a1);
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select sno FROM student";//�����Ƿ��������û���
				s = con.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
					if( rs.getString(i).equals(a1)){
						JOptionPane.showMessageDialog(null,"��ѧ���û�������Ϣ�Ѿ����ڣ����ʧ��,��������ӣ�");
					}
				}
				//������׽�쳣����ѧ��������Ϣ�����
				try{
					statl=con.prepareStatement(sql2);
					statl.setString(1,a1);//����ѧ�ŵ����ݿ�
					statl.setString(2,a2);//�������������ݿ�
					statl.setString(3,a3);//�������䵽���ݿ�
					statl.setString(4,a4);//�����Ա����ݿ�
					statl.setString(5,a5);//����סַ�����ݿ�
					statl.setString(6,a6);//���Ӽ��ᵽ���ݿ�
					statl.setString(7,a7);//���Ӱ��õ����ݿ�
					statl.setString(8,a8);//����QQ�����ݿ�
					statl.setString(9,a9);//���ӵ绰�����ݿ�
					statl.setString(10,a10);//����רҵ�����ݿ�
					statl.setString(11,a11);//������ò�����ݿ�
					statl.executeUpdate();					//����һ���˵����ݵ����ݿ�
					JOptionPane.showMessageDialog(null,"���ѧ����Ϣ�ɹ�");
					statl.close();							//�ر���������
				}catch(Exception e1){}
			}
		}catch(Exception e2){}
	}
	public void TIAN1(String a1,String a2,String a8,String a9,String a10,String a11){
			try{
				if(!a1.equals("")){//���ѧ�Ų�Ϊ�գ��������
				String sql="insert into grade values(?,?,?,?,?,?)";
				PreparedStatement pst=null;
				
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select sno FROM grade";//�����Ƿ��������û���
				s = con.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
					if( rs.getString(i).equals(a1)){
						JOptionPane.showMessageDialog(null,"��ѧ���û��ɼ���Ϣ�Ѿ����ڣ����ʧ��,��������ӣ�");
						new manager();
					}
				}
				
				try{
					pst=con.prepareStatement(sql);
					pst.setString(1, a1);//����ѧ�ŵ����ݿ�
					pst.setString(2, a2);//�������������ݿ�
					pst.setString(3,a8);//������ѧ�����ݿ�
					pst.setString(4,a9);//����Ӣ�ﵽ���ݿ�
					pst.setString(5,a10);//�������ε����ݿ�
					pst.setString(6,a11);//���Ӽ���������ݿ�
					pst.executeUpdate();					//����һ���˵����ݵ����ݿ�
					JOptionPane.showMessageDialog(null,"���ѧ���ɼ��ɹ�");
					pst.close();	
				}catch(Exception e1){}	
			}	
			}catch(Exception e){}
	}
}


