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
import java.sql.Statement;

//用于表格设计默认表模式
import javax.swing.table.DefaultTableModel;
import grade.DB.TestJDBC;
import grade.Tool.tool;
import grade.MODEL.cxmodel;
//主类（查询）继承 javax.swing.JFrame 实现接口 java.awt.ActionListener
public class cx2 extends JFrame implements ActionListener,MouseListener{			//,ListSelectionListener,之前的JList监听不使用了
	//全局变量，组件，对象的声明---------------------------------------------------------------
	int i,Q;
	Connection conn=new TestJDBC().getCon();//连接数据库--------------------------------------
	//组件声明--------------------------------------------------------------------------------
	JTabbedPane xxk;//选项卡------------------------------------------------------------------
	JPanel jp1,jp2,jp3,jp4;//三个面板-------------------------------------------------------------
	
	JTabbedPane jtb;//jp2中套用选项卡---------------------------------------------------------
	JPanel jpa,jpa1;//两个面板----------------------------------------------------------------
	
	//jp1(信息查询和成绩查询界面)//修改成不是表格形式的信息输出模式--------------------------------------------------------------
	JPanel panel1;
	JLabel label2,label3,bq,bbqq,bq1;
	JLabel tupian;
	JLabel jll1,jll2,jll3,jll4,jll5,jll6,jll7,jll8,jll9,jll10,jll11,jll12,jll13,jll14;
	JTextField[] jt =new JTextField[14];
	JButton JB;
	JTextField text;

	
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
	//JButton SELE=new JButton("查询");
	//-----------------------------------------------------------------------------------
		
	//ActionListener监听覆盖父类中的监听的方法actionPerformed------------------------------
		public void actionPerformed(ActionEvent e){
			
			//实现学生信息查询------------------------------------------------------------
			if(JB==e.getSource()){
				cxmodel CX=new cxmodel();
				String[] B=CX.CX(text.getText());
				for(int i=0;i<10;i++){
					//table3.setValueAt(B[i], 0, i);		//之前学生信息是输出在表格中，现在改为文本框中
					jt[i].setText(B[i]);
				}
			}
			//查询学生选课情况------------------------------------------------------------
		/*	else if(e.getSource()==SELE){
				
				//特地为了判断该名同学如果没有选择课程，就进行提示，并且把赏一个同学的信息清空
				try{
					String[][] B=new String[8][4];
					String SQL="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement ST=conn.prepareStatement(SQL);
					ST.setString(1, text.getText());
					ResultSet RS=ST.executeQuery();
					//如果根据学号查询的学生选课情况为空，则rs.next()为空，进行提示
						if(!(RS.next())){
						JOptionPane.showMessageDialog(null, "未选课！");
						//当该学生未选课时，显示的未空，即将上一位同学选课情况清空
						for(int j=0;j<8;j++){
							for(int b=0;b<4;b++){
								B[j][b]="";
								table44.setValueAt(B[j][b], j, b);
						}
					}
						}
				}catch(Exception e1){}
				//特地为了判断该名同学如果没有选择课程，就进行提示，并且把赏一个同学的信息清空
				
				//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
				int i=0;
				int k=0;
				try{
					//学生选课------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					//如果该同学选择了课程，则rs.next()不为空
					while(rs.next()){		
								String sql="SELECT * FROM COURSE WHERE CNO=?";
								//继续捕捉异常进行学生课程查询并输出到表格中-------------------------
								PreparedStatement st1=conn.prepareStatement(sql);
								st1.setString(1,rs.getString(i+1));
								ResultSet rs1=st1.executeQuery();	
								if(rs1.next()){
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
			//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
		}*/
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
							String SQL="SELECT CNO FROM SC WHERE SC.SNO=?";
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
		/*else if(e.getSource()==label22){
			//特地为了判断该名同学如果没有选择课程，就进行提示，并且把赏一个同学的信息清空
			try{
				String[][] B=new String[8][4];
				String SQL="SElECT CNO FROM SC WHERE SNO=?";
				PreparedStatement ST=conn.prepareStatement(SQL);
				ST.setString(1, text.getText());
				ResultSet RS=ST.executeQuery();
				//如果根据学号查询的学生选课情况为空，则rs.next()为空，进行提示
					if(!(RS.next())){
					JOptionPane.showMessageDialog(null, "未选课！");
					//当该学生未选课时，显示的未空，即将上一位同学选课情况清空
					for(int j=0;j<8;j++){
						for(int b=0;b<4;b++){
							B[j][b]="";
							table44.setValueAt(B[j][b], j, b);
					}
				}
					}
			}catch(Exception e1){}
			//特地为了判断该名同学如果没有选择课程，就进行提示，并且把赏一个同学的信息清空
			
			//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
			int i=0;
			int k=0;
			try{
				//学生选课------------------------------------------------------------
				String[][] A=new String[8][4];
				String sql2="SElECT CNO FROM SC WHERE SNO=?";
				PreparedStatement st=conn.prepareStatement(sql2);
				st.setString(1, text.getText());
				ResultSet rs=st.executeQuery();
				//如果该同学选择了课程，则rs.next()不为空
				while(rs.next()){		
							String sql="SELECT * FROM COURSE WHERE CNO=?";
							//继续捕捉异常进行学生课程查询并输出到表格中-------------------------
							PreparedStatement st1=conn.prepareStatement(sql);
							st1.setString(1,rs.getString(i+1));
							ResultSet rs1=st1.executeQuery();	
							if(rs1.next()){
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
		//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
		}*/
	}
		public void mouseEntered(MouseEvent e){
			if(jp3==e.getSource()){
				//JOptionPane.showConfirmDialog(null, "是否退出","温馨提示", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			int yes=JOptionPane.showConfirmDialog(this, "确认退出", "温馨提示", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	
			}
			else if(e.getSource()==label22){
				//特地为了判断该名同学如果没有选择课程，就进行提示，并且把上一个同学的信息清空
				try{
					String[][] B=new String[8][4];
					String SQL="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement ST=conn.prepareStatement(SQL);
					ST.setString(1, text.getText());
					ResultSet RS=ST.executeQuery();
					//如果根据学号查询的学生选课情况为空，则rs.next()为空，进行提示
						if(!(RS.next())){
						JOptionPane.showMessageDialog(null, "未选课！");
						//当该学生未选课时，显示的未空，即将上一位同学选课情况清空
						for(int j=0;j<8;j++){
							for(int b=0;b<4;b++){
								B[j][b]="";
								table44.setValueAt(B[j][b], j, b);
						}
					}
						}
				}catch(Exception e1){}
				//特地为了判断该名同学如果没有选择课程，就进行提示，并且把赏一个同学的信息清空
				
				//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
				int i=0;
				int k=0;
				try{
					//学生选课------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					//如果该同学选择了课程，则rs.next()不为空
					while(rs.next()){		
								String sql="SELECT * FROM COURSE WHERE CNO=?";
								//继续捕捉异常进行学生课程查询并输出到表格中-------------------------
								PreparedStatement st1=conn.prepareStatement(sql);
								st1.setString(1,rs.getString(i+1));
								ResultSet rs1=st1.executeQuery();	
								if(rs1.next()){
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
			//如果该名同学选择了课程，就查询出选择的所有课程信息并且输出在表格中
			}
			else if(e.getSource()==label3){
				//实现学生成绩查询------------------------------------------------------------
				cxmodel CX=new cxmodel();
				String[] F=CX.GRADE(text.getText());
				int m=10;
				for(int i=0;i<4;i++){
					//table.setValueAt(F[i], 0, i);			//之前学生成绩是输出在表格中，现在改为文本框中
					jt[m++].setText(F[i]);
				}	
			}
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseExited(MouseEvent e){
			//if(jp3==e.getSource()){
				
			//}
		}
		
	//主函数------------------------------------------------------------------------
	
	 public static void main(String[] args){
		
		new cx2();	//创建类对象--------------
	}
	
	
	//构造函数-----------------------------------------------------------------------
	cx2(){
		//框架标题，大小，图标设置----------------------------------------------------
		//this.setTitle("学生查询界面");									//标题-------
		this.setSize(740, 600);											//尺寸-------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//默认关闭操作
		//Image img=new ImageIcon("image\\title.jpg").getImage();		//加载图标的对象
		//this.setIconImage(img);		//图标---------------------------------------
		this.setLocation(400,100);	//定位-------------------------------------------
		this.setUndecorated(true);//去掉边框（棱角）----------------------------------
		this.InitJP1();				//调用初始化面板JP1 (个人信息)-------------------------------
		this.InitJP2();				//调用初始化面板JP2（个人成绩）-------------------------------
		this.InitJP3();				//调用初始化面板JP3（个人选课）-------------------------------
		this.InitJP4();				//调用初始化面板JP4（系统退出）------------------------------
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
		label2=new JLabel("学生基本信息");
		label2.setForeground(Color.RED);
		label2.setFont(new Font("宋体",Font.BOLD,50));
		label2.setBounds(180,30,400,50);
		bq.add(label2);
		
		jll1=new JLabel("姓名");		jll1.setBounds(20,105,50,50);	jll1.setFont(tool.f8);	bq.add(jll1);
		jt[0]=new JTextField();		jt[0].setBounds(100,105,180,45);		jt[0].setBorder(null);	bq.add(jt[0]);	jt[0].setBackground(Color.cyan);	jt[0].setFont(tool.f8);	jt[0].setForeground(Color.MAGENTA);
		
		jll2=new JLabel("性别");		jll2.setBounds(300,105,50,50);	jll2.setFont(tool.f8);	bq.add(jll2);
		jt[1]=new JTextField();		jt[1].setBounds(380,105,180,45);	jt[1].setBorder(null);	bq.add(jt[1]);	jt[1].setBackground(Color.cyan);	jt[1].setFont(tool.f8);	jt[1].setForeground(Color.MAGENTA);
		
		jll3=new JLabel("年龄");		jll3.setBounds(20,180,50,50);	jll3.setFont(tool.f8);	bq.add(jll3);
		jt[2]=new JTextField();		jt[2].setBounds(100,180,180,45);	jt[2].setBorder(null);	bq.add(jt[2]);	jt[2].setBackground(Color.cyan);	jt[2].setFont(tool.f8);	jt[2].setForeground(Color.MAGENTA);
		
		jll4=new JLabel("住址");		jll4.setBounds(300,180,50,50);	jll4.setFont(tool.f8);	bq.add(jll4);
		jt[3]=new JTextField();		jt[3].setBounds(380,180,180,45);	jt[3].setBorder(null);	bq.add(jt[3]);	jt[3].setBackground(Color.cyan);	jt[3].setFont(tool.f8);	jt[3].setForeground(Color.MAGENTA);
		
		jll5=new JLabel("籍贯");		jll5.setBounds(20,250,50,50);	jll5.setFont(tool.f8);	bq.add(jll5);
		jt[4]=new JTextField();		jt[4].setBounds(100,250,180,45);	jt[4].setBorder(null);	bq.add(jt[4]);	jt[4].setBackground(Color.cyan);	jt[4].setFont(tool.f8);	jt[4].setForeground(Color.MAGENTA);
		
		jll6=new JLabel("爱好");		jll6.setBounds(300,250,50,50);	jll6.setFont(tool.f8);	bq.add(jll6);
		jt[5]=new JTextField();		jt[5].setBounds(380,250,180,45);	jt[5].setBorder(null);	bq.add(jt[5]);	jt[5].setBackground(Color.cyan);	jt[5].setFont(tool.f8);	jt[5].setForeground(Color.MAGENTA);
		
		jll7=new JLabel("QQ");		jll7.setBounds(20,320,50,50);	jll7.setFont(tool.f8);	bq.add(jll7);
		jt[6]=new JTextField();		jt[6].setBounds(100,320,180,45);	jt[6].setBorder(null);	bq.add(jt[6]);	jt[6].setBackground(Color.cyan);	jt[6].setFont(tool.f8);	jt[6].setForeground(Color.MAGENTA);
		
		jll8=new JLabel("联系方式");jll8.setBounds(300,320,150,50);	jll8.setFont(tool.f8);	bq.add(jll8);
		jt[7]=new JTextField();		jt[7].setBounds(450,320,180,45);	jt[7].setBorder(null);	bq.add(jt[7]);	jt[7].setBackground(Color.cyan);	jt[7].setFont(tool.f8);	jt[7].setForeground(Color.MAGENTA);
		
		
		jll9=new JLabel("专业");		jll9.setBounds(20,395,325,50);	jll9.setFont(tool.f8);	bq.add(jll9);
		jt[8]=new JTextField();		jt[8].setBounds(100,395,180,45);	jt[8].setBorder(null);	bq.add(jt[8]);	jt[8].setBackground(Color.cyan);	jt[8].setFont(tool.f8);	jt[8].setForeground(Color.MAGENTA);
		
		jll10=new JLabel("政治面貌");jll10.setBounds(300,395,150,50);	jll10.setFont(tool.f8);	bq.add(jll10);
		jt[9]=new JTextField();		jt[9].setBounds(450,395,180,45);	jt[9].setBorder(null);	bq.add(jt[9]);	jt[9].setBackground(Color.cyan);	jt[9].setFont(tool.f8);	jt[9].setForeground(Color.MAGENTA);
	

		JB=new JButton("查询");
		JB.setFont(tool.f8);
		JB.addActionListener(this);
		JB.setBounds(100,520,100,50);
		bq.add(JB);
		bq1=new JLabel("学号");
		bq1.setFont(tool.f8);
		bq1.setBounds(300,520,200,50);
		bq.add(bq1);
		text=new JTextField();
		text.setBounds(450, 520, 200, 50);
		bq.add(text);
		text.setFont(tool.f8);
		//ImageIcon img1=new ImageIcon("image/1408069018.jpg");
		//tupian=new JLabel(img1); tupian.setBounds(600,105,100,140);	tupian.setFont(tool.f8);	bq.add(tupian);
	}
	public void InitJP2(){
		jp4=new JPanel();	
		jp4.setLayout(null);
		xxk.addTab("个人成绩",jp4);	
		ImageIcon img=new ImageIcon("image/9.jpg");
		bbqq=new JLabel(img);
		bbqq.setBounds(0, 0, 740,600);
		jp4.add(bbqq);

		label3=new JLabel("学生成绩信息");
		label3.addMouseListener(this);
		label3.setForeground(Color.RED);
		label3.setFont(new Font("宋体",Font.BOLD,50));
		label3.setBounds(180,30,400,50);
		bbqq.add(label3);
		
		jll11=new JLabel("数学");		jll11.setBounds(50,165,100,50);	jll11.setFont(tool.f8);	bbqq.add(jll11);
		jt[10]=new JTextField();		jt[10].setBounds(450,165,180,45);	jt[10].setBorder(null);	bbqq.add(jt[10]);	jt[10].setBackground(Color.cyan);	jt[10].setFont(tool.f8);	jt[10].setForeground(Color.MAGENTA);
		jll12=new JLabel("英语");		jll12.setBounds(50,220,100,50);	jll12.setFont(tool.f8);	bbqq.add(jll12);
		jt[11]=new JTextField();		jt[11].setBounds(450,220,180,45);	jt[11].setBorder(null);	bbqq.add(jt[11]);	jt[11].setBackground(Color.cyan);	jt[11].setFont(tool.f8);	jt[11].setForeground(Color.MAGENTA);
		jll13=new JLabel("政治 ");		jll13.setBounds(50,275,100,50);	jll13.setFont(tool.f8);	bbqq.add(jll13);
		jt[12]=new JTextField();		jt[12].setBounds(450,275,180,45);	jt[12].setBorder(null);	bbqq.add(jt[12]);	jt[12].setBackground(Color.cyan);	jt[12].setFont(tool.f8);	jt[12].setForeground(Color.MAGENTA);
		jll14=new JLabel("计算机");		jll14.setBounds(50,330,100,50);	jll14.setFont(tool.f8);	bbqq.add(jll14);
		jt[13]=new JTextField();		jt[13].setBounds(450,330,180,45);	jt[13].setBorder(null);	bbqq.add(jt[13]);	jt[13].setBackground(Color.cyan);	jt[13].setFont(tool.f8);	jt[13].setForeground(Color.MAGENTA);
	}
	//初始化面板JP2(个人选课）-------------------------------------------------------
	public void InitJP3(){
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
	public void InitJP4(){
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
		label1.setBounds(255,0,300,50);
		table4=new JTable();
		String[] lie1={"课号","课程名","课程学分","教学地址"};
		DefaultTableModel model4=new DefaultTableModel(lie1,100);
		table4.setModel(model4);
		table4.setBackground(Color.green);
		table4.setEnabled(false);
		JScrollPane jsp1=new JScrollPane(table4);
		jpa.add(jsp1);
		jsp1.setBounds(0,50,730,283);		
		an4.addMouseListener(this);    
		an4.setBounds(100,340,150,50);
		label11.setBounds(350,340,100,50);
		text1.setBounds(500,340,150,50);
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
		label22.addMouseListener(this);  
		
		jpa1.add(label22);
		label22.setFont(tool.f8);
		label22.setBounds(255,0,300,50);
		table44=new JTable();
		String[] lie1={"课号","课程名","课程学分","教学地址"};
		DefaultTableModel model4=new DefaultTableModel(lie1,100);
		table44.setModel(model4);
		table44.setBackground(Color.green);
		JScrollPane jsp11=new JScrollPane(table44);
		jpa1.add(jsp11);
		jsp11.setBounds(0,50,730,350);
		//jpa1.add(SELE);
		//SELE.setBounds(250,270,200,50);
		//SELE.addActionListener(this);
		//SELE.setForeground(Color.MAGENTA);
	}
}