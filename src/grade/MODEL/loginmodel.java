package grade.MODEL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import grade.DB.TestJDBC;
import java.sql.*;
public class loginmodel {
	Connection db=new TestJDBC().getCon();
//验证用户名是否合法
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
			
			if(a){//a用于判断是实现学生登录还是管理员登录，当a=true,学生登录；当a=false,,管理员登录
				if(rs.next()){
					code=rs.getString(1);
				}else{
					//rs.getString(i)为空
					JOptionPane.showMessageDialog(null, "该用户不存在，请更换用户名后重新登录！");
				}
			}	
			else{	
				if(rs1.next()){
					code=rs1.getString(1);
				}else{
					//rs.getString(i)为空
					JOptionPane.showMessageDialog(null, "该管理员不存在，请更换用户名后重新登录！");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
	
