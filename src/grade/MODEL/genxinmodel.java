package grade.MODEL;
import java.sql.Connection;
import grade.VIEW.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
public class genxinmodel {
	Connection con=new TestJDBC().getCon();//�������ݿ⣬�������Ӷ���con
	public void GGXX(String xuehao,String xingming,String sex,String age,String address,String home,
			String habit,String qq,String snumber,String zy,String zzmm){
		try{
				//������ѧ�ŵ�ѧ���Ƿ����
				String sql_ck="Select sno FROM student where sno=?";
				ResultSet rs=null;
				PreparedStatement statl=con.prepareStatement(sql_ck);
				statl.setString(1, xuehao);
				rs=statl.executeQuery();
				int i=1;
				if(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
					if(rs.getString(i).equals(xuehao)){
						String sql1="update student set sname=?,ssex=?,sage=?,saddress=?,shome=?,shabit=? where sno=? ";
						PreparedStatement ps=con.prepareStatement(sql1);
						ps.setString(1,	xingming);
						ps.setString(2, sex);
						ps.setString(3, age);
						ps.setString(4, address);
						ps.setString(5, home);
						ps.setString(6, habit);
						ps.setString(7, xuehao);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"����ѧ����Ϣ�ɹ�");
						con.close(); 
					}
				}else {
					JOptionPane.showMessageDialog(null,"��ѧ���û�������Ϣ�����ڣ�����ʧ��,����Ӻ���£�");
				}
			
				
			
		}catch(Exception ee){}
	}
	public void GGXX1(String xuehao,String name,String math,String english,String politics,String computer){
		try{
			//������ѧ�ŵ�ѧ���Ƿ����
			String sql_ck="Select sno FROM grade where sno=?";
			ResultSet rs=null;
			PreparedStatement statl=con.prepareStatement(sql_ck);
			statl.setString(1, xuehao);
			rs=statl.executeQuery();
			int i=1;
			if(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
				if(rs.getString(i).equals(xuehao)){
					String sql1="update grade set sname=?,math=?,english=?,politics=?,computer=? where sno=?";
					PreparedStatement ps=con.prepareStatement(sql1);
					ps.setString(1, name);
					ps.setString(2, math);
					ps.setString(3, english);
					ps.setString(4, politics);
					ps.setString(5, computer);
					ps.setString(6, xuehao);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"����ѧ���ɼ��ɹ�");
					con.close(); 
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"��ѧ���û��ɼ���Ϣ�����ڣ�����ʧ��,����Ӻ���£�");
			}
		}catch(Exception ee){}
	}
}
