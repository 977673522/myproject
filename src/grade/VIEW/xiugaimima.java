package grade.VIEW;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import grade.DB.TestJDBC;
import grade.Tool.tool;
//import grade.DB.TestJDBC;
public class xiugaimima extends JFrame implements ActionListener{
	//�޸����빦�ܵ�ʵ��-----------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e1){
		if(jb1==e1.getSource()){
			try{
				if(jt1.getText().equals("")){//��ѧ���û�������Ϊ��ʱ��������ʾ-----------------------
					JOptionPane.showMessageDialog(this,	"��������Ҫ����ѧ�����û�����",
								               "��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}else if(new String(jpw1.getPassword()).equals("")){//��ԭ��������Ϊ��ʱ��������ʾ----
					JOptionPane.showMessageDialog(this,	"��������Ҫ����ѧ����ԭ���룡",
								               "��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(new String(jpw2.getPassword()).equals("")){//������������Ϊ��ʱ��������ʾ-----
					JOptionPane.showMessageDialog(this,	"��������Ҫ����ѧ���������룡",
								               "��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}else{
							Connection conn=new TestJDBC().getCon();
				        	//ԭ������ͬ�ſ����޸����룬���Ҫ���ҳ�ԭ����-----------------------------
				        	ResultSet rs;
							String sql="select password from LOGIN where ID=?";
							PreparedStatement statl=conn.prepareStatement(sql);
							statl.setString(1, jt1.getText());
							rs=statl.executeQuery();
							if(rs.next()){
								String yuanmima=rs.getString(1);
								System.out.println("ԭ����Ϊ��"+yuanmima);
								System.out.println("������Ϊ��"+new String(jpw1.getPassword()));
								String newpassword=new String(jpw1.getPassword());
				        		if(newpassword.equals(yuanmima)){					        		
				        			String id=jt1.getText();
				        			String sql1="update LOGIN set PASSWORD=? where ID=? ";
				        			PreparedStatement ps=conn.prepareStatement(sql1);
				        			String newpassword1=new String(jpw2.getPassword());
				        			ps.setString(1, newpassword1);
				        			ps.setString(2, id);
				        			ps.executeUpdate();
				        			JOptionPane.showMessageDialog(null,"�޸�����ɹ�");
				        			conn.close(); 
				        			this.dispose();
				        			JOptionPane.showMessageDialog(null,"�����µ�¼��");
				        			new LOGIN();
				        }else{
				        		JOptionPane.showMessageDialog(null,"ԭ�������");
				        }
					}
				}
			}catch(Exception e2){e2.printStackTrace();}
		}
	}
	//������-----------------------------------------------------------------------------------------
	public static void main(String[] args){
		new xiugaimima();
	}
	//------------------------------------------------------------------------------------------------
	//�������---------------------------------------------------------------------------------------
	JPanel panel1;
	JLabel label1,label2,label3,label4;
	JTextField jt1;
	JPasswordField jpw1,jpw2;
	JButton jb1;
	//���캯��--------------------------------------------------------------------------------------
	public xiugaimima(){
		this.setTitle("�޸�����");
		this.setSize(500,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.InitVIEW();
		this.setVisible(true);
	}
	//��ʼ������ĺ���-------------------------------------------------------------------------------
	public void InitVIEW(){
		Image img = new ImageIcon("image\\title.jpg").getImage();
		this.setIconImage(img);
		ImageIcon background=new ImageIcon("image\\f.jpg");
		JLabel label=new JLabel(background);
		label.setBounds(0, 0, 500,400);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jpanel1=(JPanel)this.getContentPane();
		jpanel1.setOpaque(false);
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setLayout(null);
		label1=new JLabel("�����������޸����������޸�����������ȷ��������Ϣ��ȫ");
		label1.setFont(tool.f2);label1.setForeground(Color.RED);
		label2=new JLabel("ԭ   ��   ��   ��");label2.setFont(tool.f1);
		label3=new JLabel("ԭ      ��     ��");label3.setFont(tool.f1);
		label4=new JLabel("��      ��     ��");label4.setFont(tool.f1);
		jt1=new JTextField(15);
		jpw1=new JPasswordField(15);
		jpw2=new JPasswordField(15);
		jb1=new JButton("�޸�");jb1.setFont(tool.f1);jb1.setOpaque(true);
		jb1.addActionListener(this);
		panel1.add(label1);
		panel1.add(label2);panel1.add(jt1);
		panel1.add(label3);panel1.add(jpw1);
		panel1.add(label4);panel1.add(jpw2);
		panel1.add(jb1);
		label1.setBounds(10,10,500,20);
		label2.setBounds(100,50,150,30);jt1.setBounds(250,50,150,30);
		label3.setBounds(100,100,150,30);jpw1.setBounds(250,100,150,30);
		label4.setBounds(100,150,150,30);jpw2.setBounds(250,150,150,30);
		jb1.setBounds(200,250,100,30);
		this.add(panel1);
	}
}