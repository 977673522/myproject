package grade.MODEL;
import java.sql.Connection;
import grade.VIEW.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
import grade.VIEW.LOGIN;
public class ownmimaUPDATE {
	Connection con=new TestJDBC().getCon();//连接数据库，创建连接对象con
	public void ownUP(String KUANG1,String KUANG2,String KUANG3){
	//own面板中按钮修改
		try{
			if(KUANG1.equals("")){//当学生用户名输入为空时，进行提示
				JOptionPane.showMessageDialog(null,	"请输入需要更改管理员的用户名！","消息",JOptionPane.INFORMATION_MESSAGE);
			}else if(KUANG2.equals("")){//当原密码输入为空时，进行提示
				JOptionPane.showMessageDialog(null,	"请输入管理员的原密码 ","消息",JOptionPane.INFORMATION_MESSAGE);
			}else if(KUANG3.equals("")){//当新密码输入为空时，进行提示
				JOptionPane.showMessageDialog(null,	"请输入需要更改管理员的新密码！","消息",JOptionPane.INFORMATION_MESSAGE);
			}else{
			        	//原密码相同才可以修改密码，因此要查找出原密码
			        	ResultSet rs;
						String sql="select password from M where ID=?";
						PreparedStatement statl=con.prepareStatement(sql);
						statl.setString(1, KUANG1);
						rs=statl.executeQuery();
						if(rs.next()){
							String yuanmima=rs.getString(1);
							System.out.println(yuanmima);
							String ypassword=KUANG2;
			        		if(ypassword.equals(yuanmima)){					        		
			        			String id=KUANG1;
			        			String sql1="update M set PASSWORD=? where ID=? ";
			        			PreparedStatement ps=con.prepareStatement(sql1);
			        			String newpassword1=KUANG3;
			        			ps.setString(1, newpassword1);
			        			ps.setString(2, id);
			        			ps.executeUpdate();
			        			JOptionPane.showMessageDialog(null,"修改密码成功");
			        			new LOGIN();
			        			con.close(); 
			        		}else{
			        			JOptionPane.showMessageDialog(null,"原密码错误，请重新输入");
			        		}
					}else{
						
							JOptionPane.showMessageDialog(null,"该管理员用户不存在！");
							new manager();
					}
			}
		}catch(Exception e){}
	}
	public void del(String name){
		try{
			String sql="delete  from M where ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"删除账户成功！");
		}catch(Exception e){
			
		}
	}
	public String chaxun(String name){
		String mm=null;
		try{
			ResultSet rs;
			String sql="select password from M where ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				mm=rs.getString(1);
			}else{
				JOptionPane.showMessageDialog(null,"不存在该管理员！");
			}
		}catch(Exception e){e.printStackTrace(); }
		return mm;
	}
}
