package grade.VIEW;
import java.awt.*;
import grade.Tool.*;
import javax.swing.*;
import java.awt.event.*;
public class suoping extends JFrame implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jiesuo){
			//输入密码验证后才能回到主界面(此功能未实现)--------------------
			this.dispose();
			new zjm();
		}
	}
	
	public static void main(String[] args){
		new suoping();
	}
	
	JButton jiesuo;
	public suoping(){
		this.setSize(1500,800);
		this.setLocation(0,0);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);//去掉边框（棱角）----------------------
		this.InitVIEW();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void InitVIEW(){
		jiesuo=new JButton("解锁");
		jiesuo.setFont(tool.f8);
		jiesuo.setForeground(Color.blue);
		jiesuo.addActionListener(this);
		this.add(jiesuo,BorderLayout.NORTH);
		// 创建图片对象并且加载背景图片f.jpg-------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// 用标签加载图片对象----------------------------------------------
		JLabel label=new JLabel(background);
		// 设置标签大小
		label.setBounds(0, 0, 1500,1000);
		//background.getIconWidth(), background.getIconHeight());这句是按照照片的大小加载进来的，可以代替1500,800
		// 主界面获得容器JPanel面板并且添加标签。。。。。。。
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jpanel1=(JPanel)this.getContentPane();
		//JPanel对象才可以调用setOpaque(false);设置是否透明----------------------------
		jpanel1.setOpaque(false);
		//创建面板并且是指面板是否透明-------------------------------------------------
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// 去除JPanel默认布局方式,以实现各个控件自己的定位------------------------------
		jpanel.setLayout(null);
		this.add(label,BorderLayout.CENTER);
	}
}
