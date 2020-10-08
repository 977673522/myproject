//文件夹
package grade.VIEW;
//导包
import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
//自己建的类作为包
import grade.Tool.tool;
import grade.MODEL.zhucemodel;
//注册类
public class zhuce {
	//主方法
	
	 public static void main(String[] args){
		new zhuce();//创建对象
	}
	
	//组件声明--------------------------------------------------------------
	JLabel jl1;
	JTextField jt1;
	JLabel jl2,jl3,label;
	JTextField jt2;
	JCheckBox gl;
	JCheckBox pt;
	JButton jb1;
	JPanel jp,jpanel;
	ImageIcon background;
	JFrame jf;
	//构造函数--------------------------------------------------------------
	public zhuce(){
		//定义框架----------------------------------------------------------
		jf = new JFrame("欢迎进入成绩信息管理系统");
		jf.setResizable(false);
		//定义组件,设置组件中的字体------------------------------------------
		jl1=new JLabel("注册用户名");
		jl1.setFont(tool.f6);
		jt1=new JTextField(15);
		jl2=new JLabel("注册密码");
		jl2.setFont(tool.f6);
		jl3=new JLabel("欢迎来到学生信息管理系统，您必须先注册再登录");
		jl3.setForeground(Color.RED);
		jl3.setFont(tool.f10);
		jt2=new JTextField(15);
		gl=new JCheckBox("管理员");
		gl.setFont(tool.f3);
		pt=new JCheckBox("学生");
		pt.setFont(tool.f3);
		jb1=new JButton("注册");
		jb1.setFont(tool.f5);
		// 加载背景图片------------------------------------------------------
		background=new ImageIcon("image\\f.jpg");
		// 用标签加载图片----------------------------------------------------
		label=new JLabel(background);
		// 设置标签大小------------------------------------------------------
		label.setBounds(0, 0, 1500,800);
		// 主界面获得容器JPanel----------------------------------------------
		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		jp=(JPanel)jf.getContentPane();
		//JPanel对象才可以调用setOpaque(false);设置是否透明-------------------
		jp.setOpaque(false);
		jpanel = new JPanel();
		jpanel.setOpaque(false);
		// 去除JPanel默认布局方式,以实现各个控件自己的定位----------------------
		jpanel.setLayout(null);
		jpanel.setBorder(BorderFactory.createTitledBorder("欢迎进入注册界面"));
		//setBounds()方法设置组件的位置和大小----------------------------------
		jl3.setBounds(10,10,1500,30);
	    jl1.setBounds(550,100,100,30);
	    jt1.setBounds(700,100,150,30);
	    jl2.setBounds(550,150,100,30);
	    jt2.setBounds(700,150,150,30);
	    gl.setBounds(550,220,100,30);
	    pt.setBounds(750,220,100,30);
	    jb1.setBounds(650,300,100,30);
	    //添加组件到面板中和添加面板到框架中-------------------------------------
	    jpanel.add(jl3); 
	    jpanel.add(jl1); 
	    jpanel.add(jt1); 
	    jpanel.add(jl2);
	    jpanel.add(jt2);
	    jpanel.add(gl);
	    jpanel.add(pt);
	    jpanel.add(jb1);
	    jf.add(jpanel);
		//设置框架的标题,大小,可见性,关闭进程操作--------------------------------
	    jf.setTitle("注册界面");
		jf.setSize(1500,800);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\title.jpg"));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//按钮注册动作监听，实现功能--------------------------------------------
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(gl.isSelected()==false&&pt.isSelected()==false){
					JOptionPane.showMessageDialog(null,"请选择注册用户的角色！");
				}
				//有zhucemodel模式的实现注册功能---------------------------------
				else if(gl.isSelected()==true&&pt.isSelected()==false){
					if(jt1.getText().equals("")&&jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册的用户名和密码！");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册的用户名！");
						jt2.setText("");
					}else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册用户的密码！");
					}else{
						zhucemodel zc=new zhucemodel();
						zc.zc(jt1.getText(),jt2.getText(),true);
						jf.dispose();
					}	
			    }else if(pt.isSelected()==true&&gl.isSelected()==false){
					if(jt1.getText().equals("")&&jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册的用户名和密码！");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册的用户名！");
						jt2.setText("");
					}else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"请输入需要注册用户的密码！");
					}else{
						zhucemodel zc=new zhucemodel();
						zc.zc(jt1.getText(),jt2.getText(),false);
						jf.dispose();
					}	
				}
			}
		});	
	}
}
/*无模式的注册学生用户和管理员用户功能的实现
 * 	Connection conn=new TestJDBC().getCon();
	String sql="insert into M values(?,?)";//假设管理员账号、密码保存在表M中
	PreparedStatement pst = null;
	//如果管理员选择框被选中则注册管理员用户
	if(gl.isSelected()==true){
		try
		{
			//判断登陆名是否已经存在
			Statement s = null;
			ResultSet rs = null;
			String sql_ck = "Select ID FROM M";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, jt1.getText());
				pst.setString(2, jt2.getText());
				//判断登陆名是否已经存在
				s = conn.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//为什么用 rs.getString(2)会提示 无效的索引呢
					if( rs.getString(i).equals(jt1.getText())){
						JOptionPane.showMessageDialog(null,"该管理员用户已经存在，注册失败");		
						jt1.setText("");
						jt2.setText("");
						System.exit(0);
						new LOGIN();
					}
				}
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"注册管理员成功,你可以在数据库中查看相关注册的信息");
						jf.dispose();
						new LOGIN();
				} 
			catch (Exception ev) {}	
		}
		catch (Exception ev) {}
		
}
	//如果管理员选择框被选中则注册学生用户
		if(pt.isSelected()==true){
			try
			{
				
				Statement s = null;
				ResultSet rs = null;
				//为了判断登陆名是否已经存在，查找是否有一样的用户名
				String sql_ck = "Select ID FROM LOGIN";
				//添加也就是注册用的用户到数据库中
				String sql1="insert into LOGIN values(?,?)";//假设管理员账号、密码保存在表M中
				try {
					pst = conn.prepareStatement(sql1);
					pst.setString(1, jt1.getText());
					pst.setString(2, jt2.getText());
					//判断登陆名是否已经存在
					s = conn.createStatement();
					rs = s.executeQuery(sql_ck);
					int i=1;
					while(rs.next()){
							if( rs.getString(i).equals(jt1.getText())){
								JOptionPane.showMessageDialog(null,"该普通用户已经存在，注册失败");
								jt1.setText("");
								jt2.setText("");
								System.exit(0);
								new LOGIN();
						}
					}
						pst.executeUpdate();//更新到数据库
						JOptionPane.showMessageDialog(null,"注册普通用户成功,你可以在数据库中查看相关注册的信息");
						jf.dispose();
						new LOGIN();
					}
				catch (Exception ev) {}		
		}
		catch (Exception ev) {}
	}*/