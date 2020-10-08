package grade.VIEW;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import grade.Tool.tool;
class zjm  extends JFrame {	
	
	 public static void main(String[] args){
		new zjm();		
	}
	
	//声明组件-------------------------------------------------
	JMenuBar JMB;
	JMenu JM1,JM2,JM3;
	JMenuItem jm1,jm2,jm3,jm4,jm5,jm6,jm7;
	JToolBar gjl;
	JButton an1,an2,an3,an4,an5,an6,an7,an8,an9,an10;
	JLabel label;
	//构造函数------------------------------------------------
	public zjm(){
		this.setTitle("学生主界面");
		this.setSize(1500,800);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//处理工具栏的组件------------------------------------------
		gjl=new JToolBar(SwingConstants.VERTICAL);
		gjl.setBackground(Color.CYAN);
		//设置工具栏可以浮动----------------------------------------
		gjl.setFloatable(false);
		an1=new JButton(new ImageIcon("image/jb1.png"));
		an2=new JButton(new ImageIcon("image/jb2.png"));
		an3=new JButton(new ImageIcon("image/jb9.png"));
		an4=new JButton(new ImageIcon("image/jb10.jpg"));
		an5=new JButton(new ImageIcon("image/jb12.png"));an5.setBackground(Color.lightGray);
		an6=new JButton(new ImageIcon("image/jb3.png"));
		an7=new JButton(new ImageIcon("image/记事本LOGO.png"));
		an8=new JButton(new ImageIcon("image/ji.png"));
		an9=new JButton(new ImageIcon("image/jb7.png"));
		an10=new JButton(new ImageIcon("image/jb8.png"));
		//加入工具栏-------------------------------------------------
		gjl.add(an1);
		gjl.add(an2);
		gjl.add(an3);
		gjl.add(an4);
		gjl.add(an5);
		gjl.add(an6);
		gjl.add(an7);
		gjl.add(an8);
		gjl.add(an9);
		gjl.add(an10);
		gjl.setForeground(Color.gray);
		this.add(gjl,BorderLayout.WEST);
		// 加载背景图片-------------------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// 用标签加载图片-----------------------------------------
		JLabel label=new JLabel(background);
		// 设置标签大小-------------------------------------------
		label.setBounds(0, 0, 1500,800);//background.getIconWidth(), background.getIconHeight());
		// 主界面获得容器JPanel-----------------------------------
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane();
		//JPanel对象才可以调用setOpaque(false);设置是否透明-------
		jp.setOpaque(false);
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// 去除JPanel默认布局方式,以实现各个控件自己的定位---------
		jpanel.setLayout(null);
		label=new JLabel("欢迎进入学生信息管理系统");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体",Font.BOLD,50));
		label.setBounds(350,200,800,50);
		jpanel.add(label,BorderLayout.CENTER);
		this.add(jpanel);	
		//定义和创建菜单条,菜单和菜单项---------------------------
		JMB=new JMenuBar();	JMB.setBackground(Color.CYAN);
		JM1=new JMenu("系统管理");	JM1.setFont(tool.f5);	JM1.setForeground(Color.MAGENTA);	
		JM2=new JMenu("查询管理");	JM2.setFont(tool.f5);	JM2.setForeground(Color.MAGENTA);	
		JM3=new JMenu("帮助");		JM3.setFont(tool.f5);	JM3.setForeground(Color.MAGENTA);	
		ImageIcon image1=new ImageIcon("image/image1.png");
		ImageIcon image2=new ImageIcon("image/image2.jpg");
		ImageIcon image3=new ImageIcon("image/image3.png");
		jm1=new JMenuItem("重新登录",image1);	jm1.setFont(tool.f5);	jm1.setForeground(Color.MAGENTA);	
		jm2=new JMenuItem("修改密码",image2);	jm2.setFont(tool.f5);	jm2.setForeground(Color.MAGENTA);	
		jm3=new JMenuItem("退出",image3);		jm3.setFont(tool.f5);	jm3.setForeground(Color.MAGENTA);	
		jm4=new JMenuItem("学生信息查询");		jm4.setFont(tool.f5);	jm4.setForeground(Color.MAGENTA);	
		jm5=new JMenuItem("学生成绩查询");		jm5.setFont(tool.f5);	jm5.setForeground(Color.MAGENTA);	
		jm6=new JMenuItem("系统简介");			jm6.setFont(tool.f5);	jm6.setForeground(Color.MAGENTA);	
		jm7=new JMenuItem("OS版本");				jm7.setFont(tool.f5);	jm7.setForeground(Color.MAGENTA);	
		//将菜单项加载到菜单--------------------------------------
		JM1.add(jm1);
		JM1.add(jm2);
		JM1.add(jm3);
		JM2.add(jm4);
		JM2.add(jm5);
		JM3.add(jm6);
		JM3.add(jm7);
		//将菜单加载到菜单条--------------------------------------
		JMB.add(JM1);
		JMB.add(JM2);
		JMB.add(JM3);
		//将菜单条加载到框架--------------------------------------
		this.setJMenuBar(JMB);
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image/title.jpg"));
		//菜单项重新登录注册事件监听	----------------------------
		jm1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 dispose();//关闭这个界面-----------------------
				 new LOGIN();//跳转到登录界面重新登录------------
			}
		});
		//菜单项修改密码注册事件监听-----------------------------
		jm2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
						//修改密码功能	-----------------------
					dispose();
					new xiugaimima();
				}
		});
		//菜单项退出注册事件监听---------------------------------				
		jm3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//退出------------------------------------------
				int yes=JOptionPane.showConfirmDialog(null, "确认退出", "温馨提示", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	else{
					JOptionPane.showMessageDialog(null, "请继续你的使用！");
				}
			}
		});
		//菜单项查询学生信息注册事件监听-------------------------
		jm4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new cx2();
			}
		});
		//菜单项查询学生成绩注册事件监听-------------------------
		jm5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new cx2();	
			}
		});
		//菜单项系统简介注册事件监听----------------------------
		jm6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new 系统简介();
			}
		});
		//菜单项系统版本注册事件监听----------------------------
		jm7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JOptionPane.showMessageDialog(null,"计算机系统为Windows 10家庭中文版");	
			}
		});
		//按钮重新登陆注册事件监听-----------------------------
		an1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				dispose();
				new LOGIN();
			}
		});
		//按钮修改密码注册事件监听------------------------------
		an2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//修改密码功能--------------------------------
				dispose();
				new xiugaimima();
			}
		});
		an3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//信息查询-------------------------------------
				//dispose();
				new cx2();
			}
		});
		an4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//成绩查询------------------------------------
				//dispose();
				new cx2();
			}
		});
		an5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//学生选课-----------------------------------
				//dispose();
				new cx2();
				
			}
		});
		an6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//锁屏功能-----------------------------------
				dispose();
				new suoping();
			}
		});
		an7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//记事本------------------------------------
				new jishi();
			}
		});
		an8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//计算器------------------------------------
				new JS();
			}
		});
		an9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JOptionPane.showMessageDialog(null,"这就是我的毕业论文设计:学生信息管理系统！！！");	
			}
		});
		an10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int yes=JOptionPane.showConfirmDialog(null, "确认退出", "温馨提示", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	else{
					JOptionPane.showMessageDialog(null, "请继续你的使用！");
				}
			}
		});
	}	
}