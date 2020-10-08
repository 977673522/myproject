//文件夹
package grade.MODEL;
//导包
import java.sql.*;
import javax.swing.JOptionPane;
//导入自己建立的类的包
import grade.DB.TestJDBC;
import grade.VIEW.LOGIN;
import grade.VIEW.zhuce;
//注册模式类
public class zhucemodel {
	//zc方法
	public void zc(String id,String psw,boolean a){
		try{
			Connection conn=new TestJDBC().getCon();//创建连接数据库的对象
			//1.a=true,注册管理员
			if(a==true){
				String sql="insert into M values(?,?)";//定义带有sql语句（实现插入管理员用户）的字符串//假设管理员账号、密码保存在表M中
				PreparedStatement pst = null;
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, psw);
			
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select ID FROM M ";//查找是否存在这个用户名
				s = conn.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
			
				while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
					if( rs.getString(i).equals(id)){
						JOptionPane.showMessageDialog(null,"该管理员用户已经存在，注册失败,请重新注册！");
						conn.close();
						new zhuce();
					}
				}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"注册管理员成功,你可以在数据库中查看相关注册的信息");
					new LOGIN();		
		  }
			//2.学生注册
		  else{
			//定义带有sql语句（实现插入学生用户）的字符串
			  String sql1="insert into LOGIN values(?,?)";//假设管理员账号、密码保存在表M中
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
			  while(rs1.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
				  if( rs1.getString(i).equals(id)){
					JOptionPane.showMessageDialog(null,"该学生用户已经存在，注册失败");	
					conn.close();
					new zhuce();
				  }
			  }
				  pst1.executeUpdate();
				  JOptionPane.showMessageDialog(null,"注册学生用户成功,你可以在数据库中查看相关注册的信息");
				  new LOGIN();
			}
		}catch (Exception ev) {}	
	}
}