package grade.MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
public class cxmodel {
	Connection conn=new TestJDBC().getCon();//�������ݿ�
	public String[] CX(String sno){
	//ʵ�ֲ�ѯѧ����Ϣ�Ĺ���
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
				JOptionPane.showMessageDialog(null, "��ѧ����Ϣ�����ڣ���ȷ�Ϻ��ڲ�ѯ��");
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
			//��?��ֵ(��ֹSQLע��©������)
			ps2.setString(1, sno);  
			//ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����  
			rs1=ps2.executeQuery();  
			//ѭ��ȡ�� 
			while(rs1.next()){  
				//��ѧ�����û���������ȡ��
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
		//ѧ��ѡ��
		try{
		
			int p=Integer.valueOf(CNO);
			if(p>0&&p<=8){
					String sql2="insert into SC values(?,?)";
					PreparedStatement statl=null;
							//������׽�쳣����ѧ��������Ϣ�����
								try{
									statl=conn.prepareStatement(sql2);
									statl.setString(1,SNO);//����ѧ�ŵ����ݿ�
									statl.setString(2,CNO);//����ѧ�ŵ����ݿ�
									statl.executeUpdate();					//����һ���˵����ݵ����ݿ�
									JOptionPane.showMessageDialog(null,"ѡ�γɹ�");
									statl.close();							//�ر���������
								}catch(Exception e1){}
			}	
		}catch(Exception e){}		
	}
}
	
	/*public void CK(String SNO){
		int i=0;
		//ѧ��ѡ��
				String sql2="SElECT CNO FROM SC WHERE SC.SNO=?";
				//������׽�쳣����ѧ��ѡ�������ѯ���κ�
				try{
					PreparedStatement st=con.prepareStatement(sql2);
					st.setString(1, SNO);
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						System.out.println("��ǰ�γ̺�Ϊ��"+rs.getString(i+1));
							String sql="SELECT * FROM COURSE WHERE CNO=?";
							//������׽�쳣����ѧ���γ̲�ѯ������������
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
	//	String sql_ck = "SELECT CNO FROM COURSE";//�����Ƿ��������κ�
	//	s = conn.createStatement();
	//	rs = s.executeQuery(sql_ck);
	//	int i=1;
	//	int cout=0;int k=1;
	//	while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
	//		if(rs.getString(k).equals(CNO)){
		//		System.out.println("�иÿκŴ���");



















/*public String[] JIANLI(String sno){
String[] D=new String[15];
try{
    PreparedStatement ps2=null;
    ResultSet rs1=null;
	ps2=con.prepareStatement("select * from JIANLI where sno=?");  
	//��?��ֵ(��ֹSQLע��©������)
	ps2.setString(1, sno);  
	//ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����  
	rs1=ps2.executeQuery();  
	//ѭ��ȡ�� 
	if(rs1.next()){  
		//��ѧ�����û���������ȡ��
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
	//��?��ֵ(��ֹSQLע��©������)
	ps2.setString(1, sno);  
	//ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����  
	rs1=ps2.executeQuery();  
	//ѭ��ȡ�� 
	while(rs1.next()){  
		//��ѧ�����û���������ȡ��
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
	//��?��ֵ(��ֹSQLע��©������)
	ps2.setString(1, sno);  
	//ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����  
	rs1=ps2.executeQuery();  
	//ѭ��ȡ�� 
	while(rs1.next()){  
		//��ѧ�����û���������ȡ��
		for(int i=0;i<19;i++){
			C[i]=rs1.getString(i+1); 
		}
	}  
}catch(Exception e2){
	e2.printStackTrace(); 
}
return C;
}*/