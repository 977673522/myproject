package grade.MODEL;
import java.sql.Connection;
import grade.VIEW.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import grade.DB.TestJDBC;
import grade.VIEW.LOGIN;
public class ownmimaUPDATE {
	Connection con=new TestJDBC().getCon();//�������ݿ⣬�������Ӷ���con
	public void ownUP(String KUANG1,String KUANG2,String KUANG3){
	//own����а�ť�޸�
		try{
			if(KUANG1.equals("")){//��ѧ���û�������Ϊ��ʱ��������ʾ
				JOptionPane.showMessageDialog(null,	"��������Ҫ���Ĺ���Ա���û�����","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else if(KUANG2.equals("")){//��ԭ��������Ϊ��ʱ��������ʾ
				JOptionPane.showMessageDialog(null,	"���������Ա��ԭ���� ","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else if(KUANG3.equals("")){//������������Ϊ��ʱ��������ʾ
				JOptionPane.showMessageDialog(null,	"��������Ҫ���Ĺ���Ա�������룡","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			}else{
			        	//ԭ������ͬ�ſ����޸����룬���Ҫ���ҳ�ԭ����
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
			        			JOptionPane.showMessageDialog(null,"�޸�����ɹ�");
			        			new LOGIN();
			        			con.close(); 
			        		}else{
			        			JOptionPane.showMessageDialog(null,"ԭ�����������������");
			        		}
					}else{
						
							JOptionPane.showMessageDialog(null,"�ù���Ա�û������ڣ�");
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
			JOptionPane.showMessageDialog(null,"ɾ���˻��ɹ���");
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
				JOptionPane.showMessageDialog(null,"�����ڸù���Ա��");
			}
		}catch(Exception e){e.printStackTrace(); }
		return mm;
	}
}
