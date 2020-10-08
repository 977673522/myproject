package grade.MODEL;
import java.sql.*;
import grade.DB.TestJDBC;
import javax.swing.*;
public class shanchumodel {
	Connection con=new TestJDBC().getCon();
	public void SC(String ID,String NAME){//删除学生信息的两种方式（按学号删除，按姓名删除）
		if(ID.equals("")&&NAME.equals("")){
			JOptionPane.showMessageDialog(null, "请输入删除的关键字");
		}
		else if(!(ID.equals(""))&&NAME.equals("")){//学号不为空，姓名为空
			try{
				//搜索该学号的学生是否存在
				String sql="select sno from student where sno=?";
				ResultSet rs;
				PreparedStatement statl=con.prepareStatement(sql);
				statl.setString(1, ID);
				rs=statl.executeQuery();
				if(rs.next()){
					String a=rs.getString(1);
					System.out.println(a);
					if(ID.equals(a)){//如果学号存在且等于这个学号，则进行删除操作
						String sql3="delete from student where sno=?";
						PreparedStatement pst = null;
						try{
							pst=con.prepareStatement(sql3);
							pst.setString(1, ID);			//删除要求的学号的学生信息
							pst.executeUpdate();					//更新信息
							JOptionPane.showMessageDialog(null, "按学号删除成功");
							pst.close();							//关闭容器对象					
						}catch(Exception ev){}	
					}else{
						JOptionPane.showMessageDialog(null, "不存在该用户！");
					}
				}
			}catch(Exception e){}	
		}else if(ID.equals("")&&!(NAME.equals(""))){
			try{
						//搜索该学号的学生是否存在
						String sql="select sname from student where sname=?";
						ResultSet rs;
						PreparedStatement statl=con.prepareStatement(sql);
						statl.setString(1, NAME);
						rs=statl.executeQuery();
						if(rs.next()){
							String a=rs.getString(1);
							System.out.println(a);
							if(NAME.equals(a)){//如果姓名存在且等于这个姓名，则进行删除操作
								//an3按姓名删除学生基本信息
								String sql5="delete from student where sname=?";
								PreparedStatement pst1 = null;
								try{
									pst1=con.prepareStatement(sql5);
									pst1.setString(1, NAME);			//删除要求的姓名的学生信息
									pst1.executeUpdate();					//更新信息
									JOptionPane.showMessageDialog(null, "按姓名删除成功");
									pst1.close();							//关闭容器对象					
								}catch(Exception ev){}	
							}
						}
			}catch(Exception e){}
		}
	}


	
	
	
	
	
	
	
	
	public void SC1(String ID,String NAME){//删除学生成绩的两种方式（按学号删除，按姓名删除）
		if(ID.equals("")&&NAME.equals("")){
			JOptionPane.showMessageDialog(null, "请输入删除的关键字");
		}
		else if(!(ID.equals(""))&&(NAME.equals(""))){
			try{
				//搜索该学号的学生是否存在
				String sql="select sno from grade where sno=?";
				ResultSet rs;
				PreparedStatement statl=con.prepareStatement(sql);
				statl.setString(1, ID);
				rs=statl.executeQuery();
				if(rs.next()){
					String a=rs.getString(1);
					System.out.println(a);
					if(ID.equals(a)){//如果学号存在且等于这个学号，则进行删除操作
						//an3按学号删除学生基本信息
						String sql3="delete from grade where sno=?";
						PreparedStatement pst = null;
						try{
							pst=con.prepareStatement(sql3);
							pst.setString(1, ID);			//删除要求的学号的学生成绩
							pst.executeUpdate();					//更新信息
							JOptionPane.showMessageDialog(null, "按学号删除成功");
							pst.close();							//关闭容器对象					
						}catch(Exception ev){}	
					}
				}
				}catch(Exception ev){}
			}
		
			else if(ID.equals("")&&!(NAME.equals(""))){
				try{
					//搜索该姓名的学生是否存在
					String sql="select sname from grade where sname=?";
					ResultSet rs;
					PreparedStatement statl=con.prepareStatement(sql);
					statl.setString(1, NAME);
					rs=statl.executeQuery();
					if(rs.next()){
						String a=rs.getString(1);
						System.out.println(a);
						if(NAME.equals(a)){//如果姓名存在且等于这个姓名，则进行删除操作
							//an3按姓名删除学生基本信息
							String sql5="delete from grade where sname=?";
							PreparedStatement pst1 = null;
							try{
								pst1=con.prepareStatement(sql5);
								pst1.setString(1, NAME);			//删除要求的姓名的学生成绩
								pst1.executeUpdate();					//更新信息
								JOptionPane.showMessageDialog(null, "按姓名删除成功");
								pst1.close();							//关闭容器对象					
							}catch(Exception ev){}	
						}
					}
				}catch(Exception ev){}	
			}
	}
}