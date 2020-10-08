package grade.MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import grade.DB.TestJDBC;
public class selectmodel {
	Connection con=new TestJDBC().getCon();//连接数据库，创建连接对象con
	public String[] Se(String xuehao,int i){
		if(i==0){//查基本信息
			String[] A=new String[6];
			String[]AA=new String[6];
			try{
				if(!(xuehao.equals("110"))){
					ResultSet rs;
					String s="SELECT sname,ssex,sage,saddress,shome,shabit FROM student WHERE sno=?";
					PreparedStatement statl=con.prepareStatement(s);
					statl.setString(1, xuehao);
					rs=statl.executeQuery();
					if(rs.next()){
						A[0]=rs.getString(1);
						A[1]=rs.getString(2);
						A[2]=rs.getString(3);
						A[3]=rs.getString(4);	
						A[4]=rs.getString(5);
						A[5]=rs.getString(6);	
					}	else{
						JOptionPane.showMessageDialog(null,"该用户不存在！");
					}
				}else{
					JOptionPane.showMessageDialog(null, "输出所有人信息");
					//
					//查询所有人的基本信息
					//
			  }
			}catch(Exception exception){
				System.out.println("NOT"+exception);
			}
			return A;
		}
		else{//查询成绩------------------------------------------------------------
				String[] B=new String[4];
				try{
					if(!(xuehao.equals("110"))){
						ResultSet rs;
						String sqlsql="select math,english,politics,computer from grade where sno=?";
						PreparedStatement ps=null;
						ps=con.prepareStatement(sqlsql);
						ps.setString(1, xuehao);
						rs=ps.executeQuery();
						if(rs.next()){
							B[0]=rs.getString(1);
							B[1]=rs.getString(2);
							B[2]=rs.getString(3);
							B[3]=rs.getString(4);
						}else{	JOptionPane.showMessageDialog(null,"该用户不存在！");	}
					}
					else{	
						JOptionPane.showMessageDialog(null, "输出所有人成绩");	
						//
						//查询所有人的成绩
						//
					}
				}catch(Exception e11){}
			return B;
		}
	}
}

