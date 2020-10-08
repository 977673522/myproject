/*
 * 学生信息管理系统
 * 制作人：倪文祥
 * 制作时间：2017年5月到8月
 * 本代码实现学生信息和成绩的查询以及学生简历的制作
 * 使用了模式的方法来实现功能，调用了模式类实现
 * 3个选项卡（jp1,jp2,jp3）
 * jp1面板中实现学生自己查询自己的基本信息
 * jp2面板中实现学生自己查询自己的成绩信息
 * jp3面板中实现学生简历的制作
 * */
package grade.VIEW;//属于该文件夹下的一个.java代码（包 grade.VIEW）
//用java swing和java awt设计界面
import java.awt.*;
import javax.swing.*;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.event.ListSelectionEvent;
//用于动作监听的库包
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//用于表格设计默认表模式
import javax.swing.table.DefaultTableModel;
import grade.DB.TestJDBC;
import grade.Tool.tool;
import grade.MODEL.cxmodel;
//主类（查询）继承 javax.swing.JFrame 实现接口 java.awt.ActionListener
public class cx extends JFrame implements ActionListener,MouseListener{			//,ListSelectionListener,之前的JList监听不使用了
	//全局变量，组件，对象的声明---------------------------------------------------------------
	int i,Q;
	Connection conn=new TestJDBC().getCon();//连接数据库--------------------------------------
	//组件声明--------------------------------------------------------------------------------
	JTabbedPane xxk;//选项卡------------------------------------------------------------------
	JPanel jp1,jp2,jp3;//三个面板-------------------------------------------------------------
	
	JTabbedPane jtb;//jp2中套用选项卡---------------------------------------------------------
	JPanel jpa,jpa1;//两个面板----------------------------------------------------------------
	
	//jp1(信息查询和成绩查询界面)//修改成不是表格形式的信息输出模式--------------------------------------------------------------
	JPanel panel1;
	JLabel label2,label3,bq,bq1;
	JButton JB;
	JTable table3;
	JScrollPane jsp;
	JTextField text;
	JTable table;
	JScrollPane JS;
	
	//jp2（选课系统界面）-----------------------------------------------------------------------
	JLabel jl,jl1;
	JLabel jl11=new JLabel("选课");
	ImageIcon img,img1;
	JSplitPane cf;
	JList list;
	JPanel mb;
	
	//jpa面板中组件声明和定义-------------------------------------------------------------------
	JLabel label1=new JLabel("可选择的课程信息");
	JTable table4;
	JScrollPane jsp1;
	JButton an4=new JButton("选择新课");			
	JLabel label11=new JLabel("课号");
	JTextField text1=new JTextField();
	
	//jpa1面板组件的声明和定义-------------------------------------------------------------------
	JLabel label22=new JLabel("已选择的课程信息");
	JTable table44;
	JScrollPane jsp11;
	JButton SELE=new JButton("查询");
	//-----------------------------------------------------------------------------------
		
	//ActionListener监听覆盖父类中的监听的方法actionPerformed------------------------------
		public void actionPerformed(ActionEvent e){
			
			//实现学生信息查询------------------------------------------------------------
			if(JB==e.getSource()){
				cxmodel CX=new cxmodel();
				String[] B=CX.CX(text.getText());
				for(int i=0;i<6;i++){
					table3.setValueAt(B[i], 0, i);
				}
			//实现学生成绩查询------------------------------------------------------------
				String[] F=CX.GRADE(text.getText());
				for(int i=0;i<4;i++){
					table.setValueAt(F[i], 0, i);
				}	
			}
			//查询学生选课情况------------------------------------------------------------
			else if(e.getSource()==SELE){
				try{
					int i=0;
					int k=0;
					//学生选课------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SC.SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						String sql="SELECT * FROM COURSE WHERE CNO=?";
						//继续捕捉异常进行学生课程查询并输出到表格中-------------------------
						PreparedStatement st1=conn.prepareStatement(sql);
						st1.setString(1,rs.getString(i+1));
						ResultSet rs1=st1.executeQuery();
						while(rs1.next()){
							for(int j=0;j<4;j++){
								A[k][j]=rs1.getString(j+1);
									//table44表格输出--------------------------------------
									table44.setValueAt(A[k][j], k, j);
									//给输出四个换行，k++-----------------------------------
									if(j==3){
										k++;
									}
							}
						}
					}
				}catch(Exception e1){}
		}
	}
		
		//鼠标监听覆盖的五个方法--------------------------------------------------------
		public void mouseClicked(MouseEvent e){
			
			//填充课程-----------------------------------------------------------------
			if(e.getSource()==label1){
				String[][] A=new String[8][4];
				try{
					ResultSet rs;
					String s="SELECT * FROM COURSE ";
					PreparedStatement statl=conn.prepareStatement(s);
					rs=statl.executeQuery();
					int i=0;
					while(rs.next()){
						for(int j=0;j<4;j++){
							A[i][j]=rs.getString(j+1);
							//控制台输出------------------------------------------------
							//	System.out.print(A[i][j]+"             ");
							//表格输出--------------------------------------------------
							table4.setValueAt(A[i][j], i, j);
							//给输出四个换行，i++----------------------------------------
							if(j==3){
								System.out.print("\n");	
								i++;//i在控制台输出和表格输出都作为下标-------------------
							}
						}
				    }
				}catch(Exception exception){
					System.out.println("NOT"+exception);
				}
			}
			
			//学生选课--------------------------------------------------------------------
			else if(e.getSource()==an4){
				PreparedStatement ST=null;
				ResultSet RS=null;
				try{
					//插入前的判断各种情况-------------------------------------------------
						
							//如果学号为空，提示-------------------------------------------
							if(text.getText().equals("")){
								JOptionPane.showMessageDialog(null, "学号为空，选课失败！");
								
							}
							//如果课号为空，提示-------------------------------------------
							else if(text1.getText().equals("")){
								JOptionPane.showMessageDialog(null, "课号为空，选课失败！");
								
							}
							//如果课号不存在，提示-----------------------------------------
							int p=Integer.valueOf(text1.getText());
							if(p>8||p<1){
								JOptionPane.showMessageDialog(null, "课号不存在，选课失败！");
								
							}
						
					
					//--------------------------------------------------------------------
					int Q1=Integer.valueOf(text1.getText());
					if(Q1>0&&Q1<=8){
							Q=1;
							String SQL="SELECT CNO FROM SC WHERE SC.CNO=?";
							ST=conn.prepareStatement(SQL);
							ST.setString(1, text1.getText());
							RS=ST.executeQuery();
							
							if(RS.next()){
									JOptionPane.showMessageDialog(null,"课程已选，请重新选择");
									text1.setText("");
							}else{
								//--------------------------------------------------------------------
								//进行选择新课程的功能-------------------------------------------------
								//--------------------------------------------------------------------
								String sql2="insert into SC values(?,?)";
								PreparedStatement statl=null;
									//继续捕捉异常进行学生基本信息的添加--------------------------------
									statl=conn.prepareStatement(sql2);
									statl.setString(1,text.getText());	//增加学号到数据库---------------
									statl.setString(2,text1.getText());	//增加课号到数据库---------------
									statl.executeUpdate();				//增加一个人选课的数据-----------
									JOptionPane.showMessageDialog(null,"选课成功");
									text1.setText("");
									statl.close();						//关闭容器对象-------------------
							}
					}
		   }catch(Exception e1){}		
		}
	}
		public void mouseEntered(MouseEvent e){
			if(jp3==e.getSource()){
				JOptionPane.showMessageDialog(null, "确认退出");
				System.exit(0);
			}
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		
	//主函数------------------------------------------------------------------------
	
	 public static void main(String[] args){
		
		new cx();	//创建类对象--------------
	}
	
	
	//构造函数-----------------------------------------------------------------------
	cx(){
		//框架标题，大小，图标设置----------------------------------------------------
		//this.setTitle("学生查询界面");									//标题-------
		this.setSize(740, 600);											//尺寸-------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//默认关闭操作
		//Image img=new ImageIcon("image\\title.jpg").getImage();		//加载图标的对象
		//this.setIconImage(img);		//图标---------------------------------------
		this.setLocation(400,100);	//定位-------------------------------------------
		this.setUndecorated(true);//去掉边框（棱角）----------------------------------
		this.InitJP1();				//调用初始化面板JP1-------------------------------
		this.InitJP2();				//调用初始化面板JP2-------------------------------
		this.InitJP3();				//调用初始化面板JP3-------------------------------
		this.setVisible(true);		//可见-------------------------------------------
		this.setResizable(false);	//不可编辑---------------------------------------
		
	}
	
	//初始化面板JP1(个人信息）--------------------------------------------------------
	public void InitJP1(){
		xxk=new JTabbedPane();
		this.add(xxk);
		jp1=new JPanel();
		jp1.setLayout(null);
		xxk.addTab("个人信息",jp1);	
		ImageIcon img=new ImageIcon("image/9.jpg");
		bq=new JLabel(img);
		bq.setBounds(0, 0, 740,600);
		jp1.add(bq);
		label2=new JLabel("学生详细信息",label2.CENTER);
		label2.setForeground(Color.red);
		label2.setFont(new Font("宋体",Font.BOLD,50));
		label2.setBounds(160,25,400,50);
		bq.add(label2);
		
		
		table3=new JTable();
		String[] lie1={"姓名","性别","年龄","住址","籍贯","爱好"};
		DefaultTableModel model4=new DefaultTableModel(lie1,1);
		table3.setModel(model4);
		table3.setBackground(Color.green);
		table3.setEnabled(false);
		JScrollPane jsp11=new JScrollPane(table3);
		jsp11.setBounds(0,100,740,50);
		bq.add(jsp11);
		
		label3=new JLabel("学生成绩信息",label2.CENTER);
		label3.setForeground(Color.red);
		label3.setFont(new Font("宋体",Font.BOLD,50));
		label3.setBounds(160,175,400,50);
		bq.add(label3);
		
		
		table=new JTable();
		String[] lie11={"数学","英语","政治","计算机"};
		DefaultTableModel model44=new DefaultTableModel(lie11,1);
		table.setModel(model44);
		table.setBackground(Color.green);
		table.setEnabled(false);
		JScrollPane jsp111=new JScrollPane(table);
		jsp111.setBounds(0,250,740,50);
		bq.add(jsp111);
		
		JB=new JButton("查询");
		JB.setFont(tool.f8);
		JB.addActionListener(this);
		JB.setBounds(100,400,100,50);
		bq.add(JB);
		bq1=new JLabel("学号");
		bq1.setFont(tool.f8);
		bq1.setBounds(300,400,200,50);
		bq.add(bq1);
		text=new JTextField();
		text.setBounds(450, 400, 200, 50);
		bq.add(text);
		text.setFont(tool.f8);
	}
	//初始化面板JP2(个人选课）-------------------------------------------------------
	public void InitJP2(){
		jp2=new JPanel();	
		jp2.setLayout(null);
		xxk.addTab("个人选课",jp2);	
		img=new ImageIcon("image\\50.jpg");
		jl=new JLabel(img);
		jl.setBounds(0, 0, 740, 150);
		jp2.add(jl);
		jl.setLayout(null);
		jl1=new JLabel("高校学生选课");
		jl1.setFont(tool.f7);
		jl1.setForeground(Color.MAGENTA);
		jl1.setBounds(100,50,600,100);
		jl.add(jl1);
		initjpa();
		initjpa1();
	}
	public void InitJP3(){
		jp3=new JPanel();	
		xxk.addTab("退出系统",jp3);	
		jp3.addMouseListener(this);
		jp3.setBackground(Color.PINK);
	}
	public void initjpa(){
		jpa=new JPanel();
		jpa.setLayout(null);
		jtb=new JTabbedPane();
		jtb.setBounds(0, 150, 740, 450);
		jp2.add(jtb);
		jtb.addTab("选择新课程", jpa);
		jpa.setBackground(Color.DARK_GRAY);
		label1.setForeground(Color.MAGENTA);	
		label1.addMouseListener(this);
		jpa.add(label1);
		label1.setFont(tool.f8);
		label1.setBounds(230,0,300,50);
		table4=new JTable();
		String[] lie1={"课号","课程名","课程学分","教学地址"};
		DefaultTableModel model4=new DefaultTableModel(lie1,11);
		table4.setModel(model4);
		table4.setBackground(Color.green);
		table4.setEnabled(false);
		JScrollPane jsp1=new JScrollPane(table4);
		jpa.add(jsp1);
		jsp1.setBounds(0,50,740,200);
		an4.setBounds(50,270,200,50);		
		an4.addMouseListener(this);    
		label11.setBounds(350,270,100,50);
		text1.setBounds(500,270,150,50);
		jpa.add(an4);		an4.setFont(tool.f3);	an4.setForeground(Color.MAGENTA); an4.setBackground(Color.BLUE);
		jpa.add(label11);	label11.setFont(tool.f3);	label11.setForeground(Color.MAGENTA);
		jpa.add(text1);		text1.setFont(tool.f3);		text1.setForeground(Color.MAGENTA);
	}
	public void initjpa1(){
		jpa1=new JPanel();
		jpa1.setLayout(null);
		jtb.setBounds(0, 150, 740, 450);
		jp2.add(jtb);
		jtb.addTab("查询已选课程", jpa1);
		jpa1.setBackground(Color.darkGray);
		label22.setForeground(Color.MAGENTA);
		jpa1.add(label22);
		label22.setFont(tool.f8);
		label22.setBounds(240,0,300,50);
		table44=new JTable();
		String[] lie1={"课号","课程名","课程学分","教学地址"};
		DefaultTableModel model4=new DefaultTableModel(lie1,11);
		table44.setModel(model4);
		table44.setBackground(Color.green);
		JScrollPane jsp11=new JScrollPane(table44);
		jpa1.add(jsp11);
		jsp11.setBounds(0,50,740,200);
		jpa1.add(SELE);
		SELE.setBounds(250,270,200,50);
		SELE.addActionListener(this);
		SELE.setForeground(Color.MAGENTA);
	}
}