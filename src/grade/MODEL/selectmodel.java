package grade.MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import grade.DB.TestJDBC;
public class selectmodel {
	Connection con=new TestJDBC().getCon();//�������ݿ⣬�������Ӷ���con
	public String[] Se(String xuehao,int i){
		if(i==0){//�������Ϣ
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
						JOptionPane.showMessageDialog(null,"���û������ڣ�");
					}
				}else{
					JOptionPane.showMessageDialog(null, "�����������Ϣ");
					//
					//��ѯ�����˵Ļ�����Ϣ
					//
			  }
			}catch(Exception exception){
				System.out.println("NOT"+exception);
			}
			return A;
		}
		else{//��ѯ�ɼ�------------------------------------------------------------
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
						}else{	JOptionPane.showMessageDialog(null,"���û������ڣ�");	}
					}
					else{	
						JOptionPane.showMessageDialog(null, "��������˳ɼ�");	
						//
						//��ѯ�����˵ĳɼ�
						//
					}
				}catch(Exception e11){}
			return B;
		}
	}
}

