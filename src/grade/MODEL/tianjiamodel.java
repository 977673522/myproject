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
			if(!a1.equals("")){//如果学号不为空，继续添加
				String sql2="insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement statl=null;
				//添加之前先查询是否有一样的sno，如果有则提示已存在，添加失败，重新添加！
				System.out.println(a1);
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select sno FROM student";//查找是否存在这个用户名
				s = con.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
					if( rs.getString(i).equals(a1)){
						JOptionPane.showMessageDialog(null,"该学生用户基本信息已经存在，添加失败,请重新添加！");
					}
				}
				//继续捕捉异常进行学生基本信息的添加
				try{
					statl=con.prepareStatement(sql2);
					statl.setString(1,a1);//增加学号到数据库
					statl.setString(2,a2);//增加姓名到数据库
					statl.setString(3,a3);//增加年龄到数据库
					statl.setString(4,a4);//增加性别到数据库
					statl.setString(5,a5);//增加住址到数据库
					statl.setString(6,a6);//增加籍贯到数据库
					statl.setString(7,a7);//增加爱好到数据库
					statl.setString(8,a8);//增加QQ到数据库
					statl.setString(9,a9);//增加电话到数据库
					statl.setString(10,a10);//增加专业到数据库
					statl.setString(11,a11);//增加面貌到数据库
					statl.executeUpdate();					//增加一个人的数据到数据库
					JOptionPane.showMessageDialog(null,"添加学生信息成功");
					statl.close();							//关闭容器对象
				}catch(Exception e1){}
			}
		}catch(Exception e2){}
	}
	public void TIAN1(String a1,String a2,String a8,String a9,String a10,String a11){
			try{
				if(!a1.equals("")){//如果学号不为空，继续添加
				String sql="insert into grade values(?,?,?,?,?,?)";
				PreparedStatement pst=null;
				
				Statement s = null;
				ResultSet rs = null;
				String sql_ck = "Select sno FROM grade";//查找是否存在这个用户名
				s = con.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
					if( rs.getString(i).equals(a1)){
						JOptionPane.showMessageDialog(null,"该学生用户成绩信息已经存在，添加失败,请重新添加！");
						new manager();
					}
				}
				
				try{
					pst=con.prepareStatement(sql);
					pst.setString(1, a1);//增加学号到数据库
					pst.setString(2, a2);//增加姓名到数据库
					pst.setString(3,a8);//增加数学到数据库
					pst.setString(4,a9);//增加英语到数据库
					pst.setString(5,a10);//增加政治到数据库
					pst.setString(6,a11);//增加计算机到数据库
					pst.executeUpdate();					//增加一个人的数据到数据库
					JOptionPane.showMessageDialog(null,"添加学生成绩成功");
					pst.close();	
				}catch(Exception e1){}	
			}	
			}catch(Exception e){}
	}
}


