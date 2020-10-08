package grade.MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
public class cxmodel {
	Connection conn=new TestJDBC().getCon();//连接数据库
	public String[] CX(String sno){
	//实现查询学生信息的功能
		String[] A=new String[10];
		try{
			ResultSet rs;
			String s="SELECT sname,ssex,sage,saddress,shome,shabit,sqq,snumber,szy,szz FROM student WHERE sno=?";
			PreparedStatement statl=conn.prepareStatement(s);
			statl.setString(1, sno);
			rs=statl.executeQuery();
			if(rs.next()){
				for(int i=0;i<10;i++){
					A[i]=rs.getString(i+1);
				}
			}else {
				JOptionPane.showMessageDialog(null, "该学生信息不存在！请确认后在查询！");
			}
		}catch(Exception exception){
			System.out.println("NOT"+exception);
		}
		return A;
	}

	public String[] GRADE(String sno){
		String[] F=new String[4];
		try{
		    PreparedStatement ps2=null;
		    ResultSet rs1=null;
			ps2=conn.prepareStatement("select math,english,politics,computer from grade where sno=?");  
			//给?赋值(防止SQL注入漏洞问题)
			ps2.setString(1, sno);  
			//ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集  
			rs1=ps2.executeQuery();  
			//循环取出 
			while(rs1.next()){  
				//将学生的用户名和密码取出
				for(int i=0;i<4;i++){
					F[i]=rs1.getString(i+1); 
				}
			}  
		}catch(Exception e2){
			e2.printStackTrace(); 
		}
		return F;
	}
	
	public void XK(String SNO,String CNO){
		//学生选课
		try{
		
			int p=Integer.valueOf(CNO);
			if(p>0&&p<=8){
					String sql2="insert into SC values(?,?)";
					PreparedStatement statl=null;
							//继续捕捉异常进行学生基本信息的添加
								try{
									statl=conn.prepareStatement(sql2);
									statl.setString(1,SNO);//增加学号到数据库
									statl.setString(2,CNO);//增加学号到数据库
									statl.executeUpdate();					//增加一个人的数据到数据库
									JOptionPane.showMessageDialog(null,"选课成功");
									statl.close();							//关闭容器对象
								}catch(Exception e1){}
			}	
		}catch(Exception e){}		
	}
}
	
	/*public void CK(String SNO){
		int i=0;
		//学生选课
				String sql2="SElECT CNO FROM SC WHERE SC.SNO=?";
				//继续捕捉异常进行学生选课情况查询出课号
				try{
					PreparedStatement st=con.prepareStatement(sql2);
					st.setString(1, SNO);
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						System.out.println("当前课程号为："+rs.getString(i+1));
							String sql="SELECT * FROM COURSE WHERE CNO=?";
							//继续捕捉异常进行学生课程查询并输出到表格中
							//try{
								PreparedStatement st1=con.prepareStatement(sql);
								st1.setString(1,rs.getString(i+1) );
								ResultSet rs1=st1.executeQuery();
								while(rs1.next()){
									for(int j=0;j<4;j++){
										//System.out.println(rs1.getString(j+1)+"         ");
										
									}
								}
							//}catch(Exception e1){}
					}
				}catch(Exception e1){}
	}*/

//Statement s = null;
	//	ResultSet rs = null;
	//	String sql_ck = "SELECT CNO FROM COURSE";//查找是否存在这个课号
	//	s = conn.createStatement();
	//	rs = s.executeQuery(sql_ck);
	//	int i=1;
	//	int cout=0;int k=1;
	//	while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
	//		if(rs.getString(k).equals(CNO)){
		//		System.out.println("有该课号存在");



















/*public String[] JIANLI(String sno){
String[] D=new String[15];
try{
    PreparedStatement ps2=null;
    ResultSet rs1=null;
	ps2=con.prepareStatement("select * from JIANLI where sno=?");  
	//给?赋值(防止SQL注入漏洞问题)
	ps2.setString(1, sno);  
	//ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集  
	rs1=ps2.executeQuery();  
	//循环取出 
	if(rs1.next()){  
		//将学生的用户名和密码取出
		for(int i=0;i<=14;i++){
			D[i]=rs1.getString(i+1); 
		}
	}  
	
}catch(Exception e2){
	e2.printStackTrace(); 
}
return D;
}*/

/*public String[] CX1(String sno){
String[] B=new String[23];
try{
    PreparedStatement ps2=null;
    ResultSet rs1=null;
	ps2=con.prepareStatement("select * from xueye where sno=?");  
	//给?赋值(防止SQL注入漏洞问题)
	ps2.setString(1, sno);  
	//ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集  
	rs1=ps2.executeQuery();  
	//循环取出 
	while(rs1.next()){  
		//将学生的用户名和密码取出
		for(int i=0;i<23;i++){
			B[i]=rs1.getString(i+1); 
		}
	}  
}catch(Exception e2){
	e2.printStackTrace(); 
}
return B;
}*/

/*public String[] CX2(String sno){
String[] C=new String[23];
try{
    PreparedStatement ps2=null;
    ResultSet rs1=null;
	ps2=con.prepareStatement("select * from xueye2 where sno=?");  
	//给?赋值(防止SQL注入漏洞问题)
	ps2.setString(1, sno);  
	//ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集  
	rs1=ps2.executeQuery();  
	//循环取出 
	while(rs1.next()){  
		//将学生的用户名和密码取出
		for(int i=0;i<19;i++){
			C[i]=rs1.getString(i+1); 
		}
	}  
}catch(Exception e2){
	e2.printStackTrace(); 
}
return C;
}*/