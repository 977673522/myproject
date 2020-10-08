package grade.VIEW;
import java.awt.*;
import javax.swing.*;
import grade.Tool.*;
public class 系统简介 extends JFrame {
	
	 public static void main(String[] args){
	 
		new 系统简介();
	}
	
	public 系统简介(){
		//设置图标的方式四种
		//方式一：
		//Image img=new ImageIcon("image\\title.jpg").getImage();
		//jf.setIconImage(img);
		//方式二
		//Image img1=new ImageIcon("image/title.jpg").getImage();
		//jf.setIconImage(img1);
		//方式三
		//jf.setIconImage(Toolkit.getDefaultToolkit().getImage("image/title.jpg"));
		//方式四
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\title.jpg"));
		this.setTitle("系统简介");
		this.setSize(500,400);
		this.setLocation(500,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.Initneirong();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void Initneirong(){
		//文本区介绍系统的功能
		JTextArea jta=new JTextArea(10,10);
		jta.setText("        学生信息管理系统对于学校的管理者来说是非常重要，也是为了适应现代化学校管理的需要,加快推进学校数字化建设,更加有效的利用校园网和多媒体等"
				+ "计算机应用技术和手段。学生信息管理系统 "+"《 学生信息管理系统 》"+"摘 要：目前，学校规模扩大，工作繁杂、资料众多，开发一套适合大众的、兼容性好的"+
				"系统是很有必要的。学生信息管理系统对于学校的管理者来说至关重要，学生信息是学校非常重要的一项数据资源，但其包含的数据量大，涉及的人员面广，而且需要及时更新"+
				"传统的人工管理方式既不易于规范化，管理效率也不高，所以利用计算机实现对学生信息管理成为必然的趋势。开发SIMS不仅可以减少劳动力的使用，而且也加快了查询速度"+
				"加强了管理。其开发主要包括后台数据库的建立和维护以及前端应用程序的开发两个方面。对于前者使用SQL建立起数据一致性和完整性强、数据安全性好，使其拥有较大的数据容"+
				"量和快速的运行机制。而对于后者使用JSP作为开发工具要求应用程序设置用户权限管理，完成信息录入、信息查询、信息修改、信息删除等功能。整个系统在Tomcat5.5服务器上运行"+
				"针对不同的用户完成不同的功能。");
		jta.setFont(tool.f2);
		jta.setForeground(Color.BLACK);
		jta.setLineWrap(true);
		JScrollPane js=new JScrollPane(jta);
		this.add(js);
	}
}
