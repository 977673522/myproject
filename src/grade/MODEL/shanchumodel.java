package grade.MODEL;
import java.sql.*;
import grade.DB.TestJDBC;
import javax.swing.*;
public class shanchumodel {
	Connection con=new TestJDBC().getCon();
	public void SC(String ID,String NAME){//ɾ��ѧ����Ϣ�����ַ�ʽ����ѧ��ɾ����������ɾ����
		if(ID.equals("")&&NAME.equals("")){
			JOptionPane.showMessageDialog(null, "������ɾ���Ĺؼ���");
		}
		else if(!(ID.equals(""))&&NAME.equals("")){//ѧ�Ų�Ϊ�գ�����Ϊ��
			try{
				//������ѧ�ŵ�ѧ���Ƿ����
				String sql="select sno from student where sno=?";
				ResultSet rs;
				PreparedStatement statl=con.prepareStatement(sql);
				statl.setString(1, ID);
				rs=statl.executeQuery();
				if(rs.next()){
					String a=rs.getString(1);
					System.out.println(a);
					if(ID.equals(a)){//���ѧ�Ŵ����ҵ������ѧ�ţ������ɾ������
						String sql3="delete from student where sno=?";
						PreparedStatement pst = null;
						try{
							pst=con.prepareStatement(sql3);
							pst.setString(1, ID);			//ɾ��Ҫ���ѧ�ŵ�ѧ����Ϣ
							pst.executeUpdate();					//������Ϣ
							JOptionPane.showMessageDialog(null, "��ѧ��ɾ���ɹ�");
							pst.close();							//�ر���������					
						}catch(Exception ev){}	
					}else{
						JOptionPane.showMessageDialog(null, "�����ڸ��û���");
					}
				}
			}catch(Exception e){}	
		}else if(ID.equals("")&&!(NAME.equals(""))){
			try{
						//������ѧ�ŵ�ѧ���Ƿ����
						String sql="select sname from student where sname=?";
						ResultSet rs;
						PreparedStatement statl=con.prepareStatement(sql);
						statl.setString(1, NAME);
						rs=statl.executeQuery();
						if(rs.next()){
							String a=rs.getString(1);
							System.out.println(a);
							if(NAME.equals(a)){//������������ҵ�����������������ɾ������
								//an3������ɾ��ѧ��������Ϣ
								String sql5="delete from student where sname=?";
								PreparedStatement pst1 = null;
								try{
									pst1=con.prepareStatement(sql5);
									pst1.setString(1, NAME);			//ɾ��Ҫ���������ѧ����Ϣ
									pst1.executeUpdate();					//������Ϣ
									JOptionPane.showMessageDialog(null, "������ɾ���ɹ�");
									pst1.close();							//�ر���������					
								}catch(Exception ev){}	
							}
						}
			}catch(Exception e){}
		}
	}


	
	
	
	
	
	
	
	
	public void SC1(String ID,String NAME){//ɾ��ѧ���ɼ������ַ�ʽ����ѧ��ɾ����������ɾ����
		if(ID.equals("")&&NAME.equals("")){
			JOptionPane.showMessageDialog(null, "������ɾ���Ĺؼ���");
		}
		else if(!(ID.equals(""))&&(NAME.equals(""))){
			try{
				//������ѧ�ŵ�ѧ���Ƿ����
				String sql="select sno from grade where sno=?";
				ResultSet rs;
				PreparedStatement statl=con.prepareStatement(sql);
				statl.setString(1, ID);
				rs=statl.executeQuery();
				if(rs.next()){
					String a=rs.getString(1);
					System.out.println(a);
					if(ID.equals(a)){//���ѧ�Ŵ����ҵ������ѧ�ţ������ɾ������
						//an3��ѧ��ɾ��ѧ��������Ϣ
						String sql3="delete from grade where sno=?";
						PreparedStatement pst = null;
						try{
							pst=con.prepareStatement(sql3);
							pst.setString(1, ID);			//ɾ��Ҫ���ѧ�ŵ�ѧ���ɼ�
							pst.executeUpdate();					//������Ϣ
							JOptionPane.showMessageDialog(null, "��ѧ��ɾ���ɹ�");
							pst.close();							//�ر���������					
						}catch(Exception ev){}	
					}
				}
				}catch(Exception ev){}
			}
		
			else if(ID.equals("")&&!(NAME.equals(""))){
				try{
					//������������ѧ���Ƿ����
					String sql="select sname from grade where sname=?";
					ResultSet rs;
					PreparedStatement statl=con.prepareStatement(sql);
					statl.setString(1, NAME);
					rs=statl.executeQuery();
					if(rs.next()){
						String a=rs.getString(1);
						System.out.println(a);
						if(NAME.equals(a)){//������������ҵ�����������������ɾ������
							//an3������ɾ��ѧ��������Ϣ
							String sql5="delete from grade where sname=?";
							PreparedStatement pst1 = null;
							try{
								pst1=con.prepareStatement(sql5);
								pst1.setString(1, NAME);			//ɾ��Ҫ���������ѧ���ɼ�
								pst1.executeUpdate();					//������Ϣ
								JOptionPane.showMessageDialog(null, "������ɾ���ɹ�");
								pst1.close();							//�ر���������					
							}catch(Exception ev){}	
						}
					}
				}catch(Exception ev){}	
			}
	}
}