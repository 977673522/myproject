package grade.MODEL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import grade.DB.TestJDBC;
import java.sql.*;
public class loginmodel {
	Connection db=new TestJDBC().getCon();
//��֤�û����Ƿ�Ϸ�
	public String checkUser(String uid,boolean a)
	{
		String code="";
		try {
			ResultSet rs,rs1;
			String s="SELECT PASSWORD FROM LOGIN WHERE ID=?";
			String s1="SELECT PASSWORD FROM M WHERE ID=?";
			PreparedStatement statl=db.prepareStatement(s);
			statl.setString(1, uid);
			rs=statl.executeQuery();
			PreparedStatement statl1=db.prepareStatement(s1);
			statl1.setString(1, uid);
			rs1=statl1.executeQuery();
			
			if(a){//a�����ж���ʵ��ѧ����¼���ǹ���Ա��¼����a=true,ѧ����¼����a=false,,����Ա��¼
				if(rs.next()){
					code=rs.getString(1);
				}else{
					//rs.getString(i)Ϊ��
					JOptionPane.showMessageDialog(null, "���û������ڣ�������û��������µ�¼��");
				}
			}	
			else{	
				if(rs1.next()){
					code=rs1.getString(1);
				}else{
					//rs.getString(i)Ϊ��
					JOptionPane.showMessageDialog(null, "�ù���Ա�����ڣ�������û��������µ�¼��");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
	
