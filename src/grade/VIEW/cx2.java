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
import java.sql.Statement;

//���ڱ�����Ĭ�ϱ�ģʽ
import javax.swing.table.DefaultTableModel;
import grade.DB.TestJDBC;
import grade.Tool.tool;
import grade.MODEL.cxmodel;
//���ࣨ��ѯ���̳� javax.swing.JFrame ʵ�ֽӿ� java.awt.ActionListener
public class cx2 extends JFrame implements ActionListener,MouseListener{			//,ListSelectionListener,֮ǰ��JList������ʹ����
	//ȫ�ֱ�������������������---------------------------------------------------------------
	int i,Q;
	Connection conn=new TestJDBC().getCon();//�������ݿ�--------------------------------------
	//�������--------------------------------------------------------------------------------
	JTabbedPane xxk;//ѡ�------------------------------------------------------------------
	JPanel jp1,jp2,jp3,jp4;//�������-------------------------------------------------------------
	
	JTabbedPane jtb;//jp2������ѡ�---------------------------------------------------------
	JPanel jpa,jpa1;//�������----------------------------------------------------------------
	
	//jp1(��Ϣ��ѯ�ͳɼ���ѯ����)//�޸ĳɲ��Ǳ����ʽ����Ϣ���ģʽ--------------------------------------------------------------
	JPanel panel1;
	JLabel label2,label3,bq,bbqq,bq1;
	JLabel tupian;
	JLabel jll1,jll2,jll3,jll4,jll5,jll6,jll7,jll8,jll9,jll10,jll11,jll12,jll13,jll14;
	JTextField[] jt =new JTextField[14];
	JButton JB;
	JTextField text;

	
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
	//JButton SELE=new JButton("��ѯ");
	//-----------------------------------------------------------------------------------
		
	//ActionListener�������Ǹ����еļ����ķ���actionPerformed------------------------------
		public void actionPerformed(ActionEvent e){
			
			//ʵ��ѧ����Ϣ��ѯ------------------------------------------------------------
			if(JB==e.getSource()){
				cxmodel CX=new cxmodel();
				String[] B=CX.CX(text.getText());
				for(int i=0;i<10;i++){
					//table3.setValueAt(B[i], 0, i);		//֮ǰѧ����Ϣ������ڱ���У����ڸ�Ϊ�ı�����
					jt[i].setText(B[i]);
				}
			}
			//��ѯѧ��ѡ�����------------------------------------------------------------
		/*	else if(e.getSource()==SELE){
				
				//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
				try{
					String[][] B=new String[8][4];
					String SQL="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement ST=conn.prepareStatement(SQL);
					ST.setString(1, text.getText());
					ResultSet RS=ST.executeQuery();
					//�������ѧ�Ų�ѯ��ѧ��ѡ�����Ϊ�գ���rs.next()Ϊ�գ�������ʾ
						if(!(RS.next())){
						JOptionPane.showMessageDialog(null, "δѡ�Σ�");
						//����ѧ��δѡ��ʱ����ʾ��δ�գ�������һλͬѧѡ��������
						for(int j=0;j<8;j++){
							for(int b=0;b<4;b++){
								B[j][b]="";
								table44.setValueAt(B[j][b], j, b);
						}
					}
						}
				}catch(Exception e1){}
				//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
				
				//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
				int i=0;
				int k=0;
				try{
					//ѧ��ѡ��------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					//�����ͬѧѡ���˿γ̣���rs.next()��Ϊ��
					while(rs.next()){		
								String sql="SELECT * FROM COURSE WHERE CNO=?";
								//������׽�쳣����ѧ���γ̲�ѯ������������-------------------------
								PreparedStatement st1=conn.prepareStatement(sql);
								st1.setString(1,rs.getString(i+1));
								ResultSet rs1=st1.executeQuery();	
								if(rs1.next()){
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
			//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
		}*/
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
							String SQL="SELECT CNO FROM SC WHERE SC.SNO=?";
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
		/*else if(e.getSource()==label22){
			//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
			try{
				String[][] B=new String[8][4];
				String SQL="SElECT CNO FROM SC WHERE SNO=?";
				PreparedStatement ST=conn.prepareStatement(SQL);
				ST.setString(1, text.getText());
				ResultSet RS=ST.executeQuery();
				//�������ѧ�Ų�ѯ��ѧ��ѡ�����Ϊ�գ���rs.next()Ϊ�գ�������ʾ
					if(!(RS.next())){
					JOptionPane.showMessageDialog(null, "δѡ�Σ�");
					//����ѧ��δѡ��ʱ����ʾ��δ�գ�������һλͬѧѡ��������
					for(int j=0;j<8;j++){
						for(int b=0;b<4;b++){
							B[j][b]="";
							table44.setValueAt(B[j][b], j, b);
					}
				}
					}
			}catch(Exception e1){}
			//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
			
			//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
			int i=0;
			int k=0;
			try{
				//ѧ��ѡ��------------------------------------------------------------
				String[][] A=new String[8][4];
				String sql2="SElECT CNO FROM SC WHERE SNO=?";
				PreparedStatement st=conn.prepareStatement(sql2);
				st.setString(1, text.getText());
				ResultSet rs=st.executeQuery();
				//�����ͬѧѡ���˿γ̣���rs.next()��Ϊ��
				while(rs.next()){		
							String sql="SELECT * FROM COURSE WHERE CNO=?";
							//������׽�쳣����ѧ���γ̲�ѯ������������-------------------------
							PreparedStatement st1=conn.prepareStatement(sql);
							st1.setString(1,rs.getString(i+1));
							ResultSet rs1=st1.executeQuery();	
							if(rs1.next()){
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
		//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
		}*/
	}
		public void mouseEntered(MouseEvent e){
			if(jp3==e.getSource()){
				//JOptionPane.showConfirmDialog(null, "�Ƿ��˳�","��ܰ��ʾ", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			int yes=JOptionPane.showConfirmDialog(this, "ȷ���˳�", "��ܰ��ʾ", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	
			}
			else if(e.getSource()==label22){
				//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
				try{
					String[][] B=new String[8][4];
					String SQL="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement ST=conn.prepareStatement(SQL);
					ST.setString(1, text.getText());
					ResultSet RS=ST.executeQuery();
					//�������ѧ�Ų�ѯ��ѧ��ѡ�����Ϊ�գ���rs.next()Ϊ�գ�������ʾ
						if(!(RS.next())){
						JOptionPane.showMessageDialog(null, "δѡ�Σ�");
						//����ѧ��δѡ��ʱ����ʾ��δ�գ�������һλͬѧѡ��������
						for(int j=0;j<8;j++){
							for(int b=0;b<4;b++){
								B[j][b]="";
								table44.setValueAt(B[j][b], j, b);
						}
					}
						}
				}catch(Exception e1){}
				//�ص�Ϊ���жϸ���ͬѧ���û��ѡ��γ̣��ͽ�����ʾ�����Ұ���һ��ͬѧ����Ϣ���
				
				//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
				int i=0;
				int k=0;
				try{
					//ѧ��ѡ��------------------------------------------------------------
					String[][] A=new String[8][4];
					String sql2="SElECT CNO FROM SC WHERE SNO=?";
					PreparedStatement st=conn.prepareStatement(sql2);
					st.setString(1, text.getText());
					ResultSet rs=st.executeQuery();
					//�����ͬѧѡ���˿γ̣���rs.next()��Ϊ��
					while(rs.next()){		
								String sql="SELECT * FROM COURSE WHERE CNO=?";
								//������׽�쳣����ѧ���γ̲�ѯ������������-------------------------
								PreparedStatement st1=conn.prepareStatement(sql);
								st1.setString(1,rs.getString(i+1));
								ResultSet rs1=st1.executeQuery();	
								if(rs1.next()){
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
			//�������ͬѧѡ���˿γ̣��Ͳ�ѯ��ѡ������пγ���Ϣ��������ڱ����
			}
			else if(e.getSource()==label3){
				//ʵ��ѧ���ɼ���ѯ------------------------------------------------------------
				cxmodel CX=new cxmodel();
				String[] F=CX.GRADE(text.getText());
				int m=10;
				for(int i=0;i<4;i++){
					//table.setValueAt(F[i], 0, i);			//֮ǰѧ���ɼ�������ڱ���У����ڸ�Ϊ�ı�����
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
		
	//������------------------------------------------------------------------------
	
	 public static void main(String[] args){
		
		new cx2();	//���������--------------
	}
	
	
	//���캯��-----------------------------------------------------------------------
	cx2(){
		//��ܱ��⣬��С��ͼ������----------------------------------------------------
		//this.setTitle("ѧ����ѯ����");									//����-------
		this.setSize(740, 600);											//�ߴ�-------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Ĭ�Ϲرղ���
		//Image img=new ImageIcon("image\\title.jpg").getImage();		//����ͼ��Ķ���
		//this.setIconImage(img);		//ͼ��---------------------------------------
		this.setLocation(400,100);	//��λ-------------------------------------------
		this.setUndecorated(true);//ȥ���߿���ǣ�----------------------------------
		this.InitJP1();				//���ó�ʼ�����JP1 (������Ϣ)-------------------------------
		this.InitJP2();				//���ó�ʼ�����JP2�����˳ɼ���-------------------------------
		this.InitJP3();				//���ó�ʼ�����JP3������ѡ�Σ�-------------------------------
		this.InitJP4();				//���ó�ʼ�����JP4��ϵͳ�˳���------------------------------
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
		label2=new JLabel("ѧ��������Ϣ");
		label2.setForeground(Color.RED);
		label2.setFont(new Font("����",Font.BOLD,50));
		label2.setBounds(180,30,400,50);
		bq.add(label2);
		
		jll1=new JLabel("����");		jll1.setBounds(20,105,50,50);	jll1.setFont(tool.f8);	bq.add(jll1);
		jt[0]=new JTextField();		jt[0].setBounds(100,105,180,45);		jt[0].setBorder(null);	bq.add(jt[0]);	jt[0].setBackground(Color.cyan);	jt[0].setFont(tool.f8);	jt[0].setForeground(Color.MAGENTA);
		
		jll2=new JLabel("�Ա�");		jll2.setBounds(300,105,50,50);	jll2.setFont(tool.f8);	bq.add(jll2);
		jt[1]=new JTextField();		jt[1].setBounds(380,105,180,45);	jt[1].setBorder(null);	bq.add(jt[1]);	jt[1].setBackground(Color.cyan);	jt[1].setFont(tool.f8);	jt[1].setForeground(Color.MAGENTA);
		
		jll3=new JLabel("����");		jll3.setBounds(20,180,50,50);	jll3.setFont(tool.f8);	bq.add(jll3);
		jt[2]=new JTextField();		jt[2].setBounds(100,180,180,45);	jt[2].setBorder(null);	bq.add(jt[2]);	jt[2].setBackground(Color.cyan);	jt[2].setFont(tool.f8);	jt[2].setForeground(Color.MAGENTA);
		
		jll4=new JLabel("סַ");		jll4.setBounds(300,180,50,50);	jll4.setFont(tool.f8);	bq.add(jll4);
		jt[3]=new JTextField();		jt[3].setBounds(380,180,180,45);	jt[3].setBorder(null);	bq.add(jt[3]);	jt[3].setBackground(Color.cyan);	jt[3].setFont(tool.f8);	jt[3].setForeground(Color.MAGENTA);
		
		jll5=new JLabel("����");		jll5.setBounds(20,250,50,50);	jll5.setFont(tool.f8);	bq.add(jll5);
		jt[4]=new JTextField();		jt[4].setBounds(100,250,180,45);	jt[4].setBorder(null);	bq.add(jt[4]);	jt[4].setBackground(Color.cyan);	jt[4].setFont(tool.f8);	jt[4].setForeground(Color.MAGENTA);
		
		jll6=new JLabel("����");		jll6.setBounds(300,250,50,50);	jll6.setFont(tool.f8);	bq.add(jll6);
		jt[5]=new JTextField();		jt[5].setBounds(380,250,180,45);	jt[5].setBorder(null);	bq.add(jt[5]);	jt[5].setBackground(Color.cyan);	jt[5].setFont(tool.f8);	jt[5].setForeground(Color.MAGENTA);
		
		jll7=new JLabel("QQ");		jll7.setBounds(20,320,50,50);	jll7.setFont(tool.f8);	bq.add(jll7);
		jt[6]=new JTextField();		jt[6].setBounds(100,320,180,45);	jt[6].setBorder(null);	bq.add(jt[6]);	jt[6].setBackground(Color.cyan);	jt[6].setFont(tool.f8);	jt[6].setForeground(Color.MAGENTA);
		
		jll8=new JLabel("��ϵ��ʽ");jll8.setBounds(300,320,150,50);	jll8.setFont(tool.f8);	bq.add(jll8);
		jt[7]=new JTextField();		jt[7].setBounds(450,320,180,45);	jt[7].setBorder(null);	bq.add(jt[7]);	jt[7].setBackground(Color.cyan);	jt[7].setFont(tool.f8);	jt[7].setForeground(Color.MAGENTA);
		
		
		jll9=new JLabel("רҵ");		jll9.setBounds(20,395,325,50);	jll9.setFont(tool.f8);	bq.add(jll9);
		jt[8]=new JTextField();		jt[8].setBounds(100,395,180,45);	jt[8].setBorder(null);	bq.add(jt[8]);	jt[8].setBackground(Color.cyan);	jt[8].setFont(tool.f8);	jt[8].setForeground(Color.MAGENTA);
		
		jll10=new JLabel("������ò");jll10.setBounds(300,395,150,50);	jll10.setFont(tool.f8);	bq.add(jll10);
		jt[9]=new JTextField();		jt[9].setBounds(450,395,180,45);	jt[9].setBorder(null);	bq.add(jt[9]);	jt[9].setBackground(Color.cyan);	jt[9].setFont(tool.f8);	jt[9].setForeground(Color.MAGENTA);
	

		JB=new JButton("��ѯ");
		JB.setFont(tool.f8);
		JB.addActionListener(this);
		JB.setBounds(100,520,100,50);
		bq.add(JB);
		bq1=new JLabel("ѧ��");
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
		xxk.addTab("���˳ɼ�",jp4);	
		ImageIcon img=new ImageIcon("image/9.jpg");
		bbqq=new JLabel(img);
		bbqq.setBounds(0, 0, 740,600);
		jp4.add(bbqq);

		label3=new JLabel("ѧ���ɼ���Ϣ");
		label3.addMouseListener(this);
		label3.setForeground(Color.RED);
		label3.setFont(new Font("����",Font.BOLD,50));
		label3.setBounds(180,30,400,50);
		bbqq.add(label3);
		
		jll11=new JLabel("��ѧ");		jll11.setBounds(50,165,100,50);	jll11.setFont(tool.f8);	bbqq.add(jll11);
		jt[10]=new JTextField();		jt[10].setBounds(450,165,180,45);	jt[10].setBorder(null);	bbqq.add(jt[10]);	jt[10].setBackground(Color.cyan);	jt[10].setFont(tool.f8);	jt[10].setForeground(Color.MAGENTA);
		jll12=new JLabel("Ӣ��");		jll12.setBounds(50,220,100,50);	jll12.setFont(tool.f8);	bbqq.add(jll12);
		jt[11]=new JTextField();		jt[11].setBounds(450,220,180,45);	jt[11].setBorder(null);	bbqq.add(jt[11]);	jt[11].setBackground(Color.cyan);	jt[11].setFont(tool.f8);	jt[11].setForeground(Color.MAGENTA);
		jll13=new JLabel("���� ");		jll13.setBounds(50,275,100,50);	jll13.setFont(tool.f8);	bbqq.add(jll13);
		jt[12]=new JTextField();		jt[12].setBounds(450,275,180,45);	jt[12].setBorder(null);	bbqq.add(jt[12]);	jt[12].setBackground(Color.cyan);	jt[12].setFont(tool.f8);	jt[12].setForeground(Color.MAGENTA);
		jll14=new JLabel("�����");		jll14.setBounds(50,330,100,50);	jll14.setFont(tool.f8);	bbqq.add(jll14);
		jt[13]=new JTextField();		jt[13].setBounds(450,330,180,45);	jt[13].setBorder(null);	bbqq.add(jt[13]);	jt[13].setBackground(Color.cyan);	jt[13].setFont(tool.f8);	jt[13].setForeground(Color.MAGENTA);
	}
	//��ʼ�����JP2(����ѡ�Σ�-------------------------------------------------------
	public void InitJP3(){
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
	public void InitJP4(){
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
		label1.setBounds(255,0,300,50);
		table4=new JTable();
		String[] lie1={"�κ�","�γ���","�γ�ѧ��","��ѧ��ַ"};
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
		jtb.addTab("��ѯ��ѡ�γ�", jpa1);
		jpa1.setBackground(Color.darkGray);
		label22.setForeground(Color.MAGENTA);
		label22.addMouseListener(this);  
		
		jpa1.add(label22);
		label22.setFont(tool.f8);
		label22.setBounds(255,0,300,50);
		table44=new JTable();
		String[] lie1={"�κ�","�γ���","�γ�ѧ��","��ѧ��ַ"};
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