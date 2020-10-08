package grade.MODEL;
import java.sql.Connection;
import grade.VIEW.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
public class genxinmodel {
	Connection con=new TestJDBC().getCon();//连接数据库，创建连接对象con
	public void GGXX(String xuehao,String xingming,String sex,String age,String address,String home,
			String habit,String qq,String snumber,String zy,String zzmm){
		try{
				//搜索该学号的学生是否存在
				String sql_ck="Select sno FROM student where sno=?";
				ResultSet rs=null;
				PreparedStatement statl=con.prepareStatement(sql_ck);
				statl.setString(1, xuehao);
				rs=statl.executeQuery();
				int i=1;
				if(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
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
						JOptionPane.showMessageDialog(null,"更新学生信息成功");
						con.close(); 
					}
				}else {
					JOptionPane.showMessageDialog(null,"该学生用户基本信息不存在，更新失败,请添加后更新！");
				}
			
				
			
		}catch(Exception ee){}
	}
	public void GGXX1(String xuehao,String name,String math,String english,String politics,String computer){
		try{
			//搜索该学号的学生是否存在
			String sql_ck="Select sno FROM grade where sno=?";
			ResultSet rs=null;
			PreparedStatement statl=con.prepareStatement(sql_ck);
			statl.setString(1, xuehao);
			rs=statl.executeQuery();
			int i=1;
			if(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
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
					JOptionPane.showMessageDialog(null,"更新学生成绩成功");
					con.close(); 
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"该学生用户成绩信息不存在，更新失败,请添加后更新！");
			}
		}catch(Exception ee){}
	}
}
