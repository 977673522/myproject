package grade.VIEW;//文件夹----------------------------------------------

//导包-------------------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.swing.*;

import grade.DB.TestJDBC;
import grade.MODEL.loginmodel;
import grade.Tool.tool;
//登录类继承JFrame类实现了监听接口--------------------
public class LOGIN extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//组件的声明
	JButton btn1 ;
	JButton btn2 ;
	JButton btn3 ;
	JRadioButton jrb1;
	JRadioButton jrb2;
	JTextField jt1 ;
	JPasswordField jpassword;
	JFrame jf ;
	
	
	//主函数-----------------------------------------------------------
	public static void main(String[] args)
	{		
		//创建类对象----------------------------------------------------
		new LOGIN();
	}
	//构造函数---------------------------------------------------------
	public LOGIN(){
		
		//创建框架（JFrame类的）对象-------------------------------------------------
		jf = new JFrame("欢迎进入成绩信息管理系统");
		//设置边框布局
		jf.setLayout(new BorderLayout());
		//创建图片对象并加载图片----------------------------------------
		Image img = new ImageIcon("image\\title.jpg").getImage();
		//给框架添加图标图像-------------------------------------------
		jf.setIconImage(img);
		//设置框架的主题-----------------------------------------------
		jf.setTitle("登录界面");
		//设置框架的大小-----------------------------------------------
		jf.setSize(1500, 800);
		jf.setLocation(0,0);
		//	jf.setResizable(false);
		//框架的可见性设置放在每个组件定义加入到面板后，设置为可见true----
		//jf.setVisible(true);
		//设置框架的退出后释放资源释放内存空间，并且跳转的下一界面点击X关闭会一同关闭之前的界面
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建标签lb0，lb1,lb2且带有文字信息 ,设置字体颜色，类型，状态和大小
		JLabel lb0 = new JLabel("学生信息管理");
		lb0.setForeground(Color.RED);
		lb0.setFont(new Font("楷体",Font.BOLD,60));//楷体，加粗，60号字体
		
		JLabel lb1 = new JLabel("用       户      名:");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("宋体",Font.PLAIN,18));//宋体，细，18号字体
		
		JLabel lb2 = new JLabel("密               码:");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("宋体",Font.PLAIN,18));//宋体，细，18号字体
		
		//创建文本框对象jt1，jt2,长度15---------------------------------------
		jt1 = new JTextField(15);jt1.addActionListener(this);
		jt1.setBorder(BorderFactory.createLoweredBevelBorder());
		jt1.setFont(tool.f10);
		jpassword = new JPasswordField(15);jpassword.addActionListener(this);
		jpassword.setBorder(BorderFactory.createLoweredBevelBorder());
		jpassword.setFont(tool.f10);
		//设置密码框的回显字符-------------------------------------------------
		jpassword.setEchoChar('*');
		//创建单选按钮jrb1,jrb2,并且带有文字信息-------------------------------
		jrb1=new JRadioButton("管理员");
		jrb2=new JRadioButton("学     生");
		//创建按钮bn1,bn2,bn3,并且带有文字提示------------------------------------
		btn1 = new JButton("登  录");btn1.addActionListener(this);
		btn2 = new JButton("重 置");btn2.addActionListener(this);
		btn3 = new JButton("注册");btn3.addActionListener(this);
		// 创建图片对象并且加载背景图片f.jpg------------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// 用标签加载图片对象--------------------------------------------------
		JLabel label=new JLabel(background);
		// 设置标签大小---------------------------------------------------------
		label.setBounds(0, 0, 1500,800);
		//background.getIconWidth(), background.getIconHeight());这句是按照照片的大小加载进来的，可以代替1500,800
		
		// 主界面获得容器JPanel面板并且添加标签。。。。。。。---------------------
		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		//jf.add(label,BorderLayout.CENTER);
		JPanel jpanel1=(JPanel)jf.getContentPane();
		//JPanel对象才可以调用setOpaque(false);设置是否透明----------------------
		jpanel1.setOpaque(false);
		//创建面板并且是指面板是否透明------------------------------------------
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// 去除JPanel默认布局方式,以实现各个控件自己的定位-----------------------
		jpanel.setLayout(null);
		//设置面板的边框文字“欢迎进入登录界面”-----------------------------------
	    jpanel.setBorder(BorderFactory.createTitledBorder("欢迎进入登录界面"));
	    //“少壮不努力，老大徒伤悲”警句的标签组件的创建，以及标签字体设置和标签颜色设置
	   JLabel label1=new JLabel("少");label1.setFont(tool.f9);label1.setForeground(Color.red);
	    JLabel label2=new JLabel("壮");label2.setFont(tool.f9);label2.setForeground(Color.red);
	    JLabel label3=new JLabel("不");label3.setFont(tool.f9);label3.setForeground(Color.red);
	    JLabel label4=new JLabel("努");label4.setFont(tool.f9);label4.setForeground(Color.red);
	    JLabel label5=new JLabel("力");label5.setFont(tool.f9);label5.setForeground(Color.red);
	    JLabel label6=new JLabel("老");label6.setFont(tool.f9);label6.setForeground(Color.red);
	    JLabel label7=new JLabel("大");label7.setFont(tool.f9);label7.setForeground(Color.red);
	    JLabel label8=new JLabel("徒");label8.setFont(tool.f9);label8.setForeground(Color.red);
	    JLabel label9=new JLabel("伤");label9.setFont(tool.f9);label9.setForeground(Color.red);
	    JLabel label10=new JLabel("悲");label10.setFont(tool.f9);label10.setForeground(Color.red);
	    //“少壮不努力，老大徒伤悲”警句的标签组件的定位------------------------------
	    label1.setBounds(200, 100, 300,60);
	    label2.setBounds(200, 180, 300,60);
	    label3.setBounds(200, 260, 300,60);
	    label4.setBounds(200, 340, 300,60);
	    label5.setBounds(200, 420, 300,60);
	    label6.setBounds(1170, 100, 300,60);
	    label7.setBounds(1170, 180, 300,60);
	    label8.setBounds(1170, 260, 300,60);
	    label9.setBounds(1170, 340, 300,60);
	    label10.setBounds(1170, 420, 300,60);
	  
	  
		//用户名标签和文本框，密码标签和文本框的组件定位--------------------------------
		lb0.setBounds(500,50, 600, 60);
		lb1.setBounds(500,150, 200, 40);
		lb2.setBounds(500,200, 200, 40);
		jt1.setBounds(700, 150, 180, 30);
		jpassword.setBounds(700, 200, 180,30);
		//管理员和学生的单选按钮组件的定位----------------------------------------------
		jrb1.setBounds(550,280, 100, 30);
		jrb2.setBounds(720,280, 100, 30);
		//登录，重置，注册按钮组件的定位------------------------------------------------
		btn1.setBounds(500,360, 120, 35);
		btn2.setBounds(620,360, 120, 35);
		btn3.setBounds(740,360, 120, 35);
		
		//将所有组件添加到面板jpanel中-------------------------------------------------
		jpanel.add(label1);jpanel.add(label2);
		jpanel.add(label3);jpanel.add(label4);jpanel.add(label5);
		jpanel.add(label6);jpanel.add(label7);
		jpanel.add(label8);jpanel.add(label9);jpanel.add(label10);
		jpanel.add(lb0);
		jpanel.add(lb1);
		jpanel.add(lb2);
		jpanel.add(btn1);
		jpanel.add(btn2);
		jpanel.add(btn3);
		
		jpanel.add(jt1);
		jpanel.add(jpassword);
		jpanel.add(jrb1);
		jpanel.add(jrb2);
		//面板jpanel添加到框架中，并且设置框架可见-------------------------------------
		jf.add(jpanel);
		jf.setVisible(true);	
	}
	loginmodel l=new loginmodel();
	Connection conn=new TestJDBC().getCon();
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn1){
			if(jrb1.isSelected()==false&&jrb2.isSelected()==false){
				JOptionPane.showMessageDialog(null,"请选择角色！");
			}else if(jrb1.isSelected()==true){
				if(jt1.getText().equals("")){
        			JOptionPane.showMessageDialog(null,"用户不能为空");
			    }else if(new String(jpassword.getPassword()).equals(""))
			    {
        			JOptionPane.showMessageDialog(null,"密码不能为空");
        		}else{
        			
        			
        			//填写好了用户名要验证用户名的合法性
			    	//将该用户名和数据库里的用户名匹配，看是否有相同的用户名存在
			    	/*try{
						ResultSet rs;
						String SQ="SELECT ID FROM LOGIN ";
						PreparedStatement statl=conn.prepareStatement(SQ);
						rs=statl.executeQuery();
						int i=0;
						while(rs.next()){
							if(rs.getString(i+1).equals(jt1.getText())){
								JOptionPane.showMessageDialog(null,"该用户存在");
							}
							i++;
					    }
					}catch(Exception exception){
						System.out.println("NOT"+exception);
					}*/
			 
			    	
			    	 	//有模式下的管理员登录功能的实现-----------------------------------
						//验证-----------------------------------------------------------
						loginmodel model=new loginmodel();
						boolean i=false;
						String res=model.checkUser(jt1.getText().trim(),i);
						if(res.equals(new String(jpassword.getPassword())))
						{
							jf.dispose();
							JOptionPane.showMessageDialog(null,"欢迎"+jt1.getText()+"管理员进入学生管理系统");
							new manager();
						}else {
							//弹出错误的登录信息------------------------------------------
							JOptionPane.showMessageDialog(null, "管理员密码错误,请重新输入密码");
							jt1.setText("");
							jpassword.setText("");
						}
        		}
			}else if(jrb2.isSelected()==true){
				if(jt1.getText().equals("")){
        			JOptionPane.showMessageDialog(null,"用户不能为空");
			    }else if(new String(jpassword.getPassword()).equals(""))
			    {
        			JOptionPane.showMessageDialog(null,"密码不能为空");
        		}else	if(jrb2.isSelected()==false){
        			JOptionPane.showMessageDialog(null,"请选择角色");
        		}else{
			    	 	//有模式下的学生登录功能的实现-----------------------------------
						//验证----------------------------------------------------------
						//loginmodel model=new loginmodel();
						boolean i1=true;
						String res=l.checkUser(jt1.getText().trim(),i1);
						if(res.equals(new String(jpassword.getPassword())))
						{
							jf.dispose();
							JOptionPane.showMessageDialog(null,"欢迎"+jt1.getText()+"学生进入学生管理系统");
							new zjm();
						}else {
							//弹出错误的登录信息---------------------------------------------
							JOptionPane.showMessageDialog(null, "用户密码错误,请重新输入密码");
							jt1.setText("");
							jpassword.setText("");
						}
        		}        			
			}
		}
		else if(e.getSource()==btn2){//重置按钮注册监听器-------------------------------
			jt1.setText("");
			jpassword.setText("");
		}
		else if(e.getSource()==btn3){//注册按钮注册监听器-------------------------------
			jf.dispose();
			new zhuce();
		}
	}
}