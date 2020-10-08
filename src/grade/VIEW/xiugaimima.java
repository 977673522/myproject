package grade.VIEW;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import grade.DB.TestJDBC;
import grade.Tool.tool;
//import grade.DB.TestJDBC;
public class xiugaimima extends JFrame implements ActionListener{
	//修改密码功能的实现-----------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e1){
		if(jb1==e1.getSource()){
			try{
				if(jt1.getText().equals("")){//当学生用户名输入为空时，进行提示-----------------------
					JOptionPane.showMessageDialog(this,	"请输入需要更改学生的用户名！",
								               "消息",JOptionPane.INFORMATION_MESSAGE);
				}else if(new String(jpw1.getPassword()).equals("")){//当原密码输入为空时，进行提示----
					JOptionPane.showMessageDialog(this,	"请输入需要更改学生的原密码！",
								               "消息",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(new String(jpw2.getPassword()).equals("")){//当新密码输入为空时，进行提示-----
					JOptionPane.showMessageDialog(this,	"请输入需要更改学生的新密码！",
								               "消息",JOptionPane.INFORMATION_MESSAGE);
				}else{
							Connection conn=new TestJDBC().getCon();
				        	//原密码相同才可以修改密码，因此要查找出原密码-----------------------------
				        	ResultSet rs;
							String sql="select password from LOGIN where ID=?";
							PreparedStatement statl=conn.prepareStatement(sql);
							statl.setString(1, jt1.getText());
							rs=statl.executeQuery();
							if(rs.next()){
								String yuanmima=rs.getString(1);
								System.out.println("原密码为："+yuanmima);
								System.out.println("新密码为："+new String(jpw1.getPassword()));
								String newpassword=new String(jpw1.getPassword());
				        		if(newpassword.equals(yuanmima)){					        		
				        			String id=jt1.getText();
				        			String sql1="update LOGIN set PASSWORD=? where ID=? ";
				        			PreparedStatement ps=conn.prepareStatement(sql1);
				        			String newpassword1=new String(jpw2.getPassword());
				        			ps.setString(1, newpassword1);
				        			ps.setString(2, id);
				        			ps.executeUpdate();
				        			JOptionPane.showMessageDialog(null,"修改密码成功");
				        			conn.close(); 
				        			this.dispose();
				        			JOptionPane.showMessageDialog(null,"请重新登录！");
				        			new LOGIN();
				        }else{
				        		JOptionPane.showMessageDialog(null,"原密码错误");
				        }
					}
				}
			}catch(Exception e2){e2.printStackTrace();}
		}
	}
	//主函数-----------------------------------------------------------------------------------------
	public static void main(String[] args){
		new xiugaimima();
	}
	//------------------------------------------------------------------------------------------------
	//组件声明---------------------------------------------------------------------------------------
	JPanel panel1;
	JLabel label1,label2,label3,label4;
	JTextField jt1;
	JPasswordField jpw1,jpw2;
	JButton jb1;
	//构造函数--------------------------------------------------------------------------------------
	public xiugaimima(){
		this.setTitle("修改密码");
		this.setSize(500,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.InitVIEW();
		this.setVisible(true);
	}
	//初始化界面的函数-------------------------------------------------------------------------------
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
		label1=new JLabel("这里是密码修改区，请您修改您的密码以确保您的信息安全");
		label1.setFont(tool.f2);label1.setForeground(Color.RED);
		label2=new JLabel("原   用   户   名");label2.setFont(tool.f1);
		label3=new JLabel("原      密     码");label3.setFont(tool.f1);
		label4=new JLabel("新      密     码");label4.setFont(tool.f1);
		jt1=new JTextField(15);
		jpw1=new JPasswordField(15);
		jpw2=new JPasswordField(15);
		jb1=new JButton("修改");jb1.setFont(tool.f1);jb1.setOpaque(true);
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