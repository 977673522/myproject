/*
 * ѧ����Ϣ����ϵͳ
 * �����ˣ�������
 * ����ʱ�䣺2017��5�µ�8��
 * ������ʵ��ѧ����Ϣ�ͳɼ��Ĳ�ѯ�Լ�ѧ������������
 * ʹ����ģʽ�ķ�����ʵ�ֹ��ܣ�������ģʽ��ʵ��
 * 3��ѡ���jp1,jp2,jp3��
 * jp1�����ʵ��ѧ���Լ���ѯ�Լ��Ļ�����Ϣ
 * jp2�����ʵ��ѧ���Լ���ѯ�Լ��ĳɼ���Ϣ
 * jp3�����ʵ��ѧ������������
 * */
package grade.VIEW;//���ڸ��ļ����µ�һ��.java���루�� grade.VIEW��
//��java swing��java awt��ƽ���
import java.awt.*;
import javax.swing.*;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.event.ListSelectionEvent;
//���ڶ��������Ŀ��
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//���ڱ�����Ĭ�ϱ�ģʽ
import javax.swing.table.DefaultTableModel;
import grade.DB.TestJDBC;
import grade.Tool.tool;
import grade.MODEL.cxmodel;
//���ࣨ��ѯ���̳� javax.swing.JFrame ʵ�ֽӿ� java.awt.ActionListener
public class cx extends JFrame implements ActionListener,MouseListener{			//,ListSelectionListener,֮ǰ��JList������ʹ����
	//ȫ�ֱ�������������������---------------------------------------------------------------
	int i,Q;
	Connection conn=new TestJDBC().getCon();//�������ݿ�--------------------------------------
	//�������--------------------------------------------------------------------------------
	JTabbedPane xxk;//ѡ�------------------------------------------------------------------
	JPanel jp1,jp2,jp3;//�������-------------------------------------------------------------
	
	JTabbedPane jtb;//jp2������ѡ�---------------------------------------------------------
	JPanel jpa,jpa1;//�������----------------------------------------------------------------
	
	//jp1(��Ϣ��ѯ�ͳɼ���ѯ����)//�޸ĳɲ��Ǳ����ʽ����Ϣ���ģʽ--------------------------------------------------------------
	JPanel panel1;
	JLabel label2,label3,bq,bq1;
	JButton JB;
	JTable table3;
	JScrollPane jsp;
	JTextField text;
	JTable table;
	JScrollPane JS;
	
	//jp2��ѡ��ϵͳ���棩-----------------------------------------------------------------------
	JLabel jl,jl1;
	JLabel jl11=new JLabel("ѡ��");
	ImageIcon img,img1;
	JSplitPane cf;
	JList list;
	JPanel mb;
	
	//jpa�������������Ͷ���-------------------------------------------------------------------
	JLabel label1=new JLabel("��ѡ��Ŀγ���Ϣ");
	JTable table4;
	JScrollPane jsp1;
	JButton an4=new JButton("ѡ���¿�");			
	JLabel label11=new JLabel("�κ�");
	JTextField text1=new JTextField();
	
	//jpa1�������������Ͷ���-------------------------------------------------------------------
	JLabel label22=new JLabel("��ѡ��Ŀγ���Ϣ");
	JTable table44;
	JScrollPane jsp11;
	JButton SELE=new JButton("��ѯ");
	//-----------------------------------------------------------------------------------
		
	//ActionListener�������Ǹ����еļ����ķ���actionPerformed------------------------------
		public void actionPerformed(ActionEvent e){
			
			//ʵ��ѧ����Ϣ��ѯ------------------------------------------------------------
			if(JB==e.getSource()){
				cxmodel CX=new cxmodel();
				String[] B=CX.CX(text.getText());
				for(int i=0;i<6;i++){
					table3.setValueAt(B[i], 0, i);
				}
			//ʵ��ѧ���ɼ���ѯ------------------------------------------------------------
				String[] F=CX.GRADE(text.getText());
				for(int i=0;i<4;i++){
					table.setValueAt(F[i], 0, i);
				}	
			}
			//��ѯѧ��ѡ�����------------------------------------------------------------
			else if(e.getSource()==SELE){
				try{
					int i=0;
					int k=0;
					//ѧ��ѡ��------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SC.SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					while(rs.next()){
						String sql="SELECT * FROM COURSE WHERE CNO=?";
						//������׽�쳣����ѧ���γ̲�ѯ������������-------------------------
						PreparedStatement st1=conn.prepareStatement(sql);
						st1.setString(1,rs.getString(i+1));
						ResultSet rs1=st1.executeQuery();
						while(rs1.next()){
							for(int j=0;j<4;j++){
								A[k][j]=rs1.getString(j+1);
									//table44������--------------------------------------
									table44.setValueAt(A[k][j], k, j);
									//������ĸ����У�k++-----------------------------------
									if(j==3){
										k++;
									}
							}
						}
					}
				}catch(Exception e1){}
		}
	}
		
		//���������ǵ��������--------------------------------------------------------
		public void mouseClicked(MouseEvent e){
			
			//���γ�-----------------------------------------------------------------
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
							//����̨���------------------------------------------------
							//	System.out.print(A[i][j]+"             ");
							//������--------------------------------------------------
							table4.setValueAt(A[i][j], i, j);
							//������ĸ����У�i++----------------------------------------
							if(j==3){
								System.out.print("\n");	
								i++;//i�ڿ���̨����ͱ���������Ϊ�±�-------------------
							}
						}
				    }
				}catch(Exception exception){
					System.out.println("NOT"+exception);
				}
			}
			
			//ѧ��ѡ��--------------------------------------------------------------------
			else if(e.getSource()==an4){
				PreparedStatement ST=null;
				ResultSet RS=null;
				try{
					//����ǰ���жϸ������-------------------------------------------------
						
							//���ѧ��Ϊ�գ���ʾ-------------------------------------------
							if(text.getText().equals("")){
								JOptionPane.showMessageDialog(null, "ѧ��Ϊ�գ�ѡ��ʧ�ܣ�");
								
							}
							//����κ�Ϊ�գ���ʾ-------------------------------------------
							else if(text1.getText().equals("")){
								JOptionPane.showMessageDialog(null, "�κ�Ϊ�գ�ѡ��ʧ�ܣ�");
								
							}
							//����κŲ����ڣ���ʾ-----------------------------------------
							int p=Integer.valueOf(text1.getText());
							if(p>8||p<1){
								JOptionPane.showMessageDialog(null, "�κŲ����ڣ�ѡ��ʧ�ܣ�");
								
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
									JOptionPane.showMessageDialog(null,"�γ���ѡ��������ѡ��");
									text1.setText("");
							}else{
								//--------------------------------------------------------------------
								//����ѡ���¿γ̵Ĺ���-------------------------------------------------
								//--------------------------------------------------------------------
								String sql2="insert into SC values(?,?)";
								PreparedStatement statl=null;
									//������׽�쳣����ѧ��������Ϣ�����--------------------------------
									statl=conn.prepareStatement(sql2);
									statl.setString(1,text.getText());	//����ѧ�ŵ����ݿ�---------------
									statl.setString(2,text1.getText());	//���ӿκŵ����ݿ�---------------
									statl.executeUpdate();				//����һ����ѡ�ε�����-----------
									JOptionPane.showMessageDialog(null,"ѡ�γɹ�");
									text1.setText("");
									statl.close();						//�ر���������-------------------
							}
					}
		   }catch(Exception e1){}		
		}
	}
		public void mouseEntered(MouseEvent e){
			if(jp3==e.getSource()){
				JOptionPane.showMessageDialog(null, "ȷ���˳�");
				System.exit(0);
			}
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		
	//������------------------------------------------------------------------------
	
	 public static void main(String[] args){
		
		new cx();	//���������--------------
	}
	
	
	//���캯��-----------------------------------------------------------------------
	cx(){
		//��ܱ��⣬��С��ͼ������----------------------------------------------------
		//this.setTitle("ѧ����ѯ����");									//����-------
		this.setSize(740, 600);											//�ߴ�-------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Ĭ�Ϲرղ���
		//Image img=new ImageIcon("image\\title.jpg").getImage();		//����ͼ��Ķ���
		//this.setIconImage(img);		//ͼ��---------------------------------------
		this.setLocation(400,100);	//��λ-------------------------------------------
		this.setUndecorated(true);//ȥ���߿���ǣ�----------------------------------
		this.InitJP1();				//���ó�ʼ�����JP1-------------------------------
		this.InitJP2();				//���ó�ʼ�����JP2-------------------------------
		this.InitJP3();				//���ó�ʼ�����JP3-------------------------------
		this.setVisible(true);		//�ɼ�-------------------------------------------
		this.setResizable(false);	//���ɱ༭---------------------------------------
		
	}
	
	//��ʼ�����JP1(������Ϣ��--------------------------------------------------------
	public void InitJP1(){
		xxk=new JTabbedPane();
		this.add(xxk);
		jp1=new JPanel();
		jp1.setLayout(null);
		xxk.addTab("������Ϣ",jp1);	
		ImageIcon img=new ImageIcon("image/9.jpg");
		bq=new JLabel(img);
		bq.setBounds(0, 0, 740,600);
		jp1.add(bq);
		label2=new JLabel("ѧ����ϸ��Ϣ",label2.CENTER);
		label2.setForeground(Color.red);
		label2.setFont(new Font("����",Font.BOLD,50));
		label2.setBounds(160,25,400,50);
		bq.add(label2);
		
		
		table3=new JTable();
		String[] lie1={"����","�Ա�","����","סַ","����","����"};
		DefaultTableModel model4=new DefaultTableModel(lie1,1);
		table3.setModel(model4);
		table3.setBackground(Color.green);
		table3.setEnabled(false);
		JScrollPane jsp11=new JScrollPane(table3);
		jsp11.setBounds(0,100,740,50);
		bq.add(jsp11);
		
		label3=new JLabel("ѧ���ɼ���Ϣ",label2.CENTER);
		label3.setForeground(Color.red);
		label3.setFont(new Font("����",Font.BOLD,50));
		label3.setBounds(160,175,400,50);
		bq.add(label3);
		
		
		table=new JTable();
		String[] lie11={"��ѧ","Ӣ��","����","�����"};
		DefaultTableModel model44=new DefaultTableModel(lie11,1);
		table.setModel(model44);
		table.setBackground(Color.green);
		table.setEnabled(false);
		JScrollPane jsp111=new JScrollPane(table);
		jsp111.setBounds(0,250,740,50);
		bq.add(jsp111);
		
		JB=new JButton("��ѯ");
		JB.setFont(tool.f8);
		JB.addActionListener(this);
		JB.setBounds(100,400,100,50);
		bq.add(JB);
		bq1=new JLabel("ѧ��");
		bq1.setFont(tool.f8);
		bq1.setBounds(300,400,200,50);
		bq.add(bq1);
		text=new JTextField();
		text.setBounds(450, 400, 200, 50);
		bq.add(text);
		text.setFont(tool.f8);
	}
	//��ʼ�����JP2(����ѡ�Σ�-------------------------------------------------------
	public void InitJP2(){
		jp2=new JPanel();	
		jp2.setLayout(null);
		xxk.addTab("����ѡ��",jp2);	
		img=new ImageIcon("image\\50.jpg");
		jl=new JLabel(img);
		jl.setBounds(0, 0, 740, 150);
		jp2.add(jl);
		jl.setLayout(null);
		jl1=new JLabel("��Уѧ��ѡ��");
		jl1.setFont(tool.f7);
		jl1.setForeground(Color.MAGENTA);
		jl1.setBounds(100,50,600,100);
		jl.add(jl1);
		initjpa();
		initjpa1();
	}
	public void InitJP3(){
		jp3=new JPanel();	
		xxk.addTab("�˳�ϵͳ",jp3);	
		jp3.addMouseListener(this);
		jp3.setBackground(Color.PINK);
	}
	public void initjpa(){
		jpa=new JPanel();
		jpa.setLayout(null);
		jtb=new JTabbedPane();
		jtb.setBounds(0, 150, 740, 450);
		jp2.add(jtb);
		jtb.addTab("ѡ���¿γ�", jpa);
		jpa.setBackground(Color.DARK_GRAY);
		label1.setForeground(Color.MAGENTA);	
		label1.addMouseListener(this);
		jpa.add(label1);
		label1.setFont(tool.f8);
		label1.setBounds(230,0,300,50);
		table4=new JTable();
		String[] lie1={"�κ�","�γ���","�γ�ѧ��","��ѧ��ַ"};
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
		jtb.addTab("��ѯ��ѡ�γ�", jpa1);
		jpa1.setBackground(Color.darkGray);
		label22.setForeground(Color.MAGENTA);
		jpa1.add(label22);
		label22.setFont(tool.f8);
		label22.setBounds(240,0,300,50);
		table44=new JTable();
		String[] lie1={"�κ�","�γ���","�γ�ѧ��","��ѧ��ַ"};
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