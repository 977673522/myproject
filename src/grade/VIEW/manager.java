package grade.VIEW;
import java.awt.*;
import grade.DB.TestJDBC;
import grade.Tool.tool;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import grade.MODEL.tianjiamodel;
import grade.MODEL.shanchumodel;
import grade.MODEL.genxinmodel;
import grade.MODEL.ownmimaUPDATE;
import grade.MODEL.selectmodel;
public class manager extends JFrame implements ActionListener{
	//�������------------------------------------------------------------------
	JTabbedPane xxk;													//ѡ�
	JPanel zhu,tj,sc,gx,cx,own;		//���ӣ�ɾ�������£���ѯ�����ң�������ʵ���������
	//tj���������������,1��2�е����񲼾�jp1,jp2--------------------------------
	JPanel jp1;
	JLabel[] jll=new JLabel[11];
	JTextField[] jtt=new JTextField[11];
	JButton an1;
	JPanel jp2;
	JLabel math,english,politics,computer;			
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton an2;
	//scɾ��������������������ʽ��ɾ����ѧ��ɾ����������ɾ����----------------------
	JLabel labell,label1;
	JTextField xuehao,xingming;
	JButton an3,an4;
	//gx����������������������Ϣ�͸��³ɼ���---------------------------------------
	JLabel[] jl=new JLabel[11];
	JTextField[] jt=new JTextField[11];
	JButton an11;
	JLabel math1,english1,politics1,computer1;
	JTextField jtf11,jtf22,jtf33,jtf44;
	JButton an22;
	//cx��ѯ��壨��ѯ��Ϣ�Ͳ�ѯ�ɼ���----------------------------------------------
	JPanel jp5;
	JLabel label11;
	JTextField wenbenk;
	JButton anniu;
	JTable table;
	JScrollPane js;
	JPanel jp6;
	JLabel label111;
	JTextField wenbenk1;
	JButton anniu1;
	JTable table1;
	JScrollPane js1;
	//own����Ա���ҹ�����壬�����޸Ĺ���Ա�����룬��ȷ����ȫ��------------------------
	JLabel yonghuming,yuanmima,newmima;
	JTextField kuang1;
	JPasswordField kuang2,kuang3;
	JButton an,anan,anan1;
	//���캯��----------------------------------------------------------------------
	public manager(){
		this.setTitle("������桪������Ա");
		this.setSize(1500,730);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image/title.jpg"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Initzhu();
		this.InitTJ();
		this.InitSC();
		this.InitGX();
		this.InitCX();
		this.InitOWN();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void Initzhu(){
		xxk=new JTabbedPane();
		this.add(xxk);
		zhu=new JPanel();
		xxk.add("����Ա������", zhu);
		
		zhu.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg------------------------------------------
		ImageIcon background2=new ImageIcon("image\\f.jpg");
		// �ñ�ǩ����ͼƬ����--------------------------------------------------------
		JLabel bb=new JLabel(background2);
		bb.setBounds(0,0,1500,730);
		JLabel bb1=new JLabel("��ӭ�������Ա����");
		bb1.setForeground(Color.RED);
		bb1.setFont(new Font("����",Font.BOLD,50));
		bb1.setBounds(450,200,800,50);
		zhu.add(bb);
		bb.add(bb1);
	}
	//��ʼ������������--------------------------------------------------------------
	public void InitTJ(){
		
		this.add(xxk);
		tj=new JPanel();
		xxk.add("���ѧ����Ϣ�ͳɼ�", tj);
		//tj��������-----------------------------------------------------------------
		tj.setLayout(new GridLayout(1,2));
		//jp1-----------------------------------------------------------------------
		jp1=new JPanel();
		jp1.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg------------------------------------------
		ImageIcon background2=new ImageIcon("image\\49.jpg");
		// �ñ�ǩ����ͼƬ����--------------------------------------------------------
		JLabel bqbq1=new JLabel(background2);
		// ���ñ�ǩ��С--------------------------------------------------------------
		bqbq1.setBounds(0, 0, 750,800);
		jp1.add(bqbq1);
		//��ǩ����
		jll[0]=new JLabel("ѧ			��");jll[1]=new JLabel("��		��");jll[2]=new JLabel("��		��");
		jll[3]=new JLabel("��			��");jll[4]=new JLabel("ס		ַ");jll[5]=new JLabel("��		��");
		jll[6]=new JLabel("��			��");jll[7]=new JLabel("Q 		Q");jll[8]=new JLabel("��		��");
		jll[9]=new JLabel("ר			ҵ");jll[10]=new JLabel("��		ò");
		//��ǩ��������
		jll[0].setFont(tool.f11);jll[1].setFont(tool.f11);jll[2].setFont(tool.f11);
		jll[3].setFont(tool.f11);jll[4].setFont(tool.f11);jll[5].setFont(tool.f11);
		jll[6].setFont(tool.f11);jll[7].setFont(tool.f11);jll[8].setFont(tool.f11);
		jll[9].setFont(tool.f11);jll[10].setFont(tool.f11);
		//��ǩ����������ɫ
		jll[0].setForeground(Color.RED);jll[1].setForeground(Color.RED);jll[2].setForeground(Color.RED);
		jll[3].setForeground(Color.RED);jll[4].setForeground(Color.RED);jll[5].setForeground(Color.RED);
		jll[6].setForeground(Color.RED);jll[7].setForeground(Color.RED);jll[8].setForeground(Color.RED);
		jll[9].setForeground(Color.RED);jll[10].setForeground(Color.RED);
		//��ǩλ������
		jll[0].setBounds(200,50,150,30);
		jll[1].setBounds(200,100,150,30);
		jll[2].setBounds(200,150,150,30);
		jll[3].setBounds(200,200,150,30);
		jll[4].setBounds(200,250,150,30);
		jll[5].setBounds(200,300,150,30);
		jll[6].setBounds(200,350,150,30);
		jll[7].setBounds(200,400,150,30);
		jll[8].setBounds(200,450,150,30);
		jll[9].setBounds(200,500,150,30);
		jll[10].setBounds(200,550,150,30);
		//��ǩ���뵽bqbq3
		bqbq1.add(jll[0]);bqbq1.add(jll[1]);bqbq1.add(jll[2]);bqbq1.add(jll[3]);bqbq1.add(jll[4]);
		bqbq1.add(jll[5]);bqbq1.add(jll[6]);bqbq1.add(jll[7]);bqbq1.add(jll[8]);bqbq1.add(jll[9]);bqbq1.add(jll[10]);
		
		//�ı�����
				jtt[0]=new JTextField(15);jtt[1]=new JTextField(15);jtt[2]=new JTextField(15);
				jtt[3]=new JTextField(15);jtt[4]=new JTextField(15);jtt[5]=new JTextField(15);
				jtt[6]=new JTextField(15);jtt[7]=new JTextField(15);jtt[8]=new JTextField(15);
				jtt[9]=new JTextField(15);jtt[10]=new JTextField(15);
				//�ı���Ķ�λ
				jtt[0].setBounds(400,50,150,30);
				jtt[1].setBounds(400,100,150,30);
				jtt[2].setBounds(400,150,150,30);
				jtt[3].setBounds(400,200,150,30);
				jtt[4].setBounds(400,250,150,30);
				jtt[5].setBounds(400,300,150,30);
				jtt[6].setBounds(400,350,150,30);
				jtt[7].setBounds(400,400,150,30);
				jtt[8].setBounds(400,450,150,30);
				jtt[9].setBounds(400,500,150,30);
				jtt[10].setBounds(400,550,150,30);
				//���ı�����뵽bqbq3
				bqbq1.add(jtt[0]);bqbq1.add(jtt[1]);bqbq1.add(jtt[2]);bqbq1.add(jtt[3]);
				bqbq1.add(jtt[4]);bqbq1.add(jtt[5]);bqbq1.add(jtt[6]);bqbq1.add(jtt[7]);
				bqbq1.add(jtt[8]);bqbq1.add(jtt[9]);bqbq1.add(jtt[10]);
		an1=new JButton("���ѧ����Ϣ");
		an1.addActionListener(this);
		an1.setFont(tool.f5);
		an1.setForeground(Color.BLUE);
		an1.setBounds(200,600,350,30);
		bqbq1.add(an1);
		tj.add(jp1);
		//jp2-------------------------------------------------------------------
		jp2=new JPanel();
		jp2.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg---------------------------------------
		ImageIcon background3=new ImageIcon("image\\49.jpg");
		// �ñ�ǩ����ͼƬ����-----------------------------------------------------
		JLabel bqbq2=new JLabel(background2);
		// ���ñ�ǩ��С------------------------------------------------------------
		bqbq2.setBounds(0, 0, 750,800);
		jp2.add(bqbq2);
		math=new JLabel("��ѧ");			
		jtf1=new JTextField(15);
		math.setForeground(Color.RED);
		english=new JLabel("Ӣ��");		
		jtf2=new JTextField(15);
		english.setForeground(Color.RED);
		politics=new JLabel("����");		
		jtf3=new JTextField(15);
		politics.setForeground(Color.RED);
		computer=new JLabel("�����");	
		jtf4=new JTextField(15);
		computer.setForeground(Color.RED);
		math.setFont(tool.f12);
		english.setFont(tool.f12);
		politics.setFont(tool.f12);
		computer.setFont(tool.f12);
		bqbq2.add(math);							
		bqbq2.add(jtf1);
		bqbq2.add(english);							
		bqbq2.add(jtf2);
		bqbq2.add(politics);						
		bqbq2.add(jtf3);
		bqbq2.add(computer);						
		bqbq2.add(jtf4);
		math.setBounds(200,100,100,30);			
		jtf1.setBounds(400,100,100,30);
		english.setBounds(200,180,100,30);		
		jtf2.setBounds(400,180,100,30);
		politics.setBounds(200,260,100,30);		
		jtf3.setBounds(400,260,100,30);
		computer.setBounds(200,340,100,30);		
		jtf4.setBounds(400,340,100,30);
		an2=new JButton("���ѧ���ɼ�");
		an2.setBounds(200,600,350,30);
		an2.addActionListener(this);
		an2.setFont(tool.f12);
		bqbq2.add(an2);
		jp2.setBackground(Color.GREEN);
		tj.add(jp2);
	}
	//��ʼ��ɾ�����溯��---------------------------------------------
	public void InitSC(){
		sc=new JPanel();
		xxk.add("ɾ��ѧ����Ϣ�ͳɼ�", sc);
		//sc---------------------------------------------------------
		sc.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg---------------------------
		ImageIcon background=new ImageIcon("image\\9.jpg");
		// �ñ�ǩ����ͼƬ����-----------------------------------------
		JLabel bqbq=new JLabel(background);
		// ���ñ�ǩ��С----------------------------------------------
		bqbq.setBounds(0, 0, 1500,800);
		sc.add(bqbq);
		//��ѧ��ɾ��-------------------------------------------------
		labell=new JLabel("��ѧ��");	
		labell.setBounds(500,200,100,30);			
		labell.setFont(tool.f10);
		//������ɾ��-------------------------------------------------
		label1=new JLabel("������");
		label1.setBounds(500,300,100,30);
		label1.setFont(tool.f10);	
		xuehao=new JTextField(15);
		xuehao.setBounds(650,200,150,30);
		bqbq.add(xuehao);
		xingming=new JTextField(15);
		xingming.setBounds(650,300,150,30);
		bqbq.add(xingming);	
		bqbq.add(labell);							
		bqbq.add(label1);							
		an3=new JButton("ɾ��ѧ����Ϣ");
		an3.setBounds(350,400,250,40);
		an3.setFont(tool.f10);
		bqbq.add(an3);
		an4=new JButton("ɾ��ѧ���ɼ�");
		an4.setBounds(650,400,250,40);
		an4.setFont(tool.f10);
		bqbq.add(an4);
		an3.addActionListener(this);
		an4.addActionListener(this);
	}
	//��ʼ�����½��溯��------------------------------------------------
	public void InitGX(){
		gx=new JPanel();
		xxk.add("����ѧ����Ϣ�ͳɼ�", gx);
		gx.setLayout(new GridLayout(1,2));
		JPanel jp3,jp4;
		//jp3
		jp3=new JPanel();
		jp3.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg---------------------------------
		ImageIcon background4=new ImageIcon("image\\42.jpg");
		// �ñ�ǩ����ͼƬ����--------------------------------------------------
		JLabel bqbq3=new JLabel(background4);
		// ���ñ�ǩ��С-----------------------------------------------------
		bqbq3.setBounds(0, 0, 750,800);
		jp3.add(bqbq3);
		//��ǩ����
		jl[0]=new JLabel("ѧ			��");jl[1]=new JLabel("��		��");jl[2]=new JLabel("��		��");
		jl[3]=new JLabel("��			��");jl[4]=new JLabel("ס		ַ");jl[5]=new JLabel("��		��");
		jl[6]=new JLabel("��			��");jl[7]=new JLabel("Q 		Q");jl[8]=new JLabel("��			��");
		jl[9]=new JLabel("ר			ҵ");jl[10]=new JLabel("��		ò");
		//��ǩ��������
		jl[0].setFont(tool.f11);jl[1].setFont(tool.f11);jl[2].setFont(tool.f11);
		jl[3].setFont(tool.f11);jl[4].setFont(tool.f11);jl[5].setFont(tool.f11);
		jl[6].setFont(tool.f11);jl[7].setFont(tool.f11);jl[8].setFont(tool.f11);
		jl[9].setFont(tool.f11);jl[10].setFont(tool.f11);
		//��ǩ����������ɫ
		jl[0].setForeground(Color.RED);jl[1].setForeground(Color.RED);jl[2].setForeground(Color.RED);
		jl[3].setForeground(Color.RED);jl[4].setForeground(Color.RED);jl[5].setForeground(Color.RED);
		jl[6].setForeground(Color.RED);jl[7].setForeground(Color.RED);jl[8].setForeground(Color.RED);
		jl[9].setForeground(Color.RED);jl[10].setForeground(Color.RED);
		//��ǩλ������
		jl[0].setBounds(200,50,150,30);
		jl[1].setBounds(200,100,150,30);
		jl[2].setBounds(200,150,150,30);
		jl[3].setBounds(200,200,150,30);
		jl[4].setBounds(200,250,150,30);
		jl[5].setBounds(200,300,150,30);
		jl[6].setBounds(200,350,150,30);
		jl[7].setBounds(200,400,150,30);
		jl[8].setBounds(200,450,150,30);
		jl[9].setBounds(200,500,150,30);
		jl[10].setBounds(200,550,150,30);
		//��ǩ���뵽bqbq3
		bqbq3.add(jl[0]);bqbq3.add(jl[1]);bqbq3.add(jl[2]);bqbq3.add(jl[3]);bqbq3.add(jl[4]);
		bqbq3.add(jl[5]);bqbq3.add(jl[6]);bqbq3.add(jl[7]);bqbq3.add(jl[8]);bqbq3.add(jl[9]);bqbq3.add(jl[10]);
		
		//�ı�����
				jt[0]=new JTextField(15);jt[1]=new JTextField(15);jt[2]=new JTextField(15);
				jt[3]=new JTextField(15);jt[4]=new JTextField(15);jt[5]=new JTextField(15);
				jt[6]=new JTextField(15);jt[7]=new JTextField(15);jt[8]=new JTextField(15);
				jt[9]=new JTextField(15);jt[10]=new JTextField(15);
				//�ı���Ķ�λ
				jt[0].setBounds(400,50,150,30);
				jt[1].setBounds(400,100,150,30);
				jt[2].setBounds(400,150,150,30);
				jt[3].setBounds(400,200,150,30);
				jt[4].setBounds(400,250,150,30);
				jt[5].setBounds(400,300,150,30);
				jt[6].setBounds(400,350,150,30);
				jt[7].setBounds(400,400,150,30);
				jt[8].setBounds(400,450,150,30);
				jt[9].setBounds(400,500,150,30);
				jt[10].setBounds(400,550,150,30);
				//���ı�����뵽bqbq3
				bqbq3.add(jt[0]);bqbq3.add(jt[1]);bqbq3.add(jt[2]);bqbq3.add(jt[3]);
				bqbq3.add(jt[4]);bqbq3.add(jt[5]);bqbq3.add(jt[6]);bqbq3.add(jt[7]);
				bqbq3.add(jt[8]);bqbq3.add(jt[9]);bqbq3.add(jt[10]);
		//��ť�Ķ��壬�������������ã����壬������ɫ������
		an11=new JButton("�޸�ѧ����Ϣ");an11.addActionListener(this);
		an11.setFont(tool.f5);
		an11.setForeground(Color.BLUE);
		an11.setBounds(200,600,350,30);
		bqbq3.add(an11);
		
		//�����������뵽���jp3
		gx.add(jp3);
		//jp4-----------------------------------------------------------------------
		jp4=new JPanel();
		jp4.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg------------------------------------------
		ImageIcon background5=new ImageIcon("image\\42.jpg");
		// �ñ�ǩ����ͼƬ����
		JLabel bqbq4=new JLabel(background4);
		// ���ñ�ǩ��С----------------------------------------------------------------
		bqbq4.setBounds(0, 0, 750,800);
		jp4.add(bqbq4);
		math1=new JLabel("��ѧ");			jtf11=new JTextField(15);
		english1=new JLabel("Ӣ��");			jtf22=new JTextField(15);
		politics1=new JLabel("����");		jtf33=new JTextField(15);
		computer1=new JLabel("�����");		jtf44=new JTextField(15);
		math1.setFont(tool.f12);math1.setForeground(Color.RED);
		english1.setFont(tool.f12);english1.setForeground(Color.RED);
		politics1.setFont(tool.f12);politics1.setForeground(Color.RED);
		computer1.setFont(tool.f12);computer1.setForeground(Color.RED);
		bqbq4.add(math1);							bqbq4.add(jtf11);
		bqbq4.add(english1);						bqbq4.add(jtf22);
		bqbq4.add(politics1);						bqbq4.add(jtf33);
		bqbq4.add(computer1);						bqbq4.add(jtf44);
		math1.setBounds(200,100,100,30);			jtf11.setBounds(400,100,100,30);
		english1.setBounds(200,180,100,30);			jtf22.setBounds(400,180,100,30);
		politics1.setBounds(200,260,100,30);		jtf33.setBounds(400,260,100,30);
		computer1.setBounds(200,340,100,30);		jtf44.setBounds(400,340,100,30);
		an22=new JButton("�޸�ѧ���ɼ�");an22.addActionListener(this);
		an22.setBounds(200,600,300,30);
		an22.setFont(tool.f12);
		bqbq4.add(an22);
		gx.add(jp4);
	}
	//��ʼ����ѯ���溯��---------------------------------------------------------
	public void InitCX(){
		cx=new JPanel();
		xxk.add("��ѯѧ����Ϣ�ͳɼ�", cx);
		cx.setLayout(new GridLayout(1,2));
		jp5=new JPanel();
		jp5.setLayout(null);
		ImageIcon background6=new ImageIcon("image//31.jpg");
		JLabel bqbq5=new JLabel(background6);
		bqbq5.setBounds(0,0,750,800);
		jp5.add(bqbq5);
		anniu=new JButton("��ѯ��Ϣ");
		anniu.addActionListener(this);
		label11=new JLabel("��ѧ�Ų�ѯ");
		wenbenk=new JTextField(15);
		table=new JTable();
		String[] lieming={"����","�Ա�","����","סַ","����","����"};
		DefaultTableModel model=new DefaultTableModel(lieming,50);
		table.setModel(model);
		js=new JScrollPane(table);
		anniu.setBounds(100,10,100,30);
		label11.setBounds(250,10,100,30);
		wenbenk.setBounds(350,10,200,30);
		js.setBounds(50,50,600,500);
		bqbq5.add(anniu);
		bqbq5.add(label11);
		bqbq5.add(wenbenk);
		bqbq5.add(js);
		cx.add(jp5);
		//jp6----------------------------------------------------------
		jp6=new JPanel();
		jp6.setLayout(null);
		ImageIcon background7=new ImageIcon("image//31.jpg");
		JLabel bqbq6=new JLabel(background7);
		bqbq6.setBounds(0, 0, 750, 800);
		jp6.add(bqbq6);
		anniu1=new JButton("��ѯ�ɼ�");
		anniu1.addActionListener(this);
		label111=new JLabel("��ѧ�Ų�ѯ");
		wenbenk1=new JTextField(15);
		table1=new JTable();
		String[] lieming1={"��ѧ","Ӣ��","����","�����"};
		DefaultTableModel model1=new DefaultTableModel(lieming1,50);
		table1.setModel(model1);
		js1=new JScrollPane(table1);
		anniu1.setBounds(100,10,100,30);
		label111.setBounds(250,10,100,30);
		wenbenk1.setBounds(350,10,200,30);
		js1.setBounds(50,50,600,500);
		bqbq6.add(anniu1);
		bqbq6.add(label111);
		bqbq6.add(wenbenk1);
		bqbq6.add(js1);
		cx.add(jp6);
	}
	//��ʼ������Ա�����Լ���Ϣ���溯��-----------------------------------------
	public void InitOWN(){
		own=new JPanel();
		xxk.add("����Ա��Ϣ�Ĺ���", own);
		own.setLayout(null);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg------------------------------------
		ImageIcon background1=new ImageIcon("image\\45.jpg");
		// �ñ�ǩ����ͼƬ����--------------------------------------------------
		JLabel label1=new JLabel(background1);
		// ���ñ�ǩ��С--------------------------------------------------------
		label1.setBounds(0, 0, 1500,800);
		own.add(label1);
		yonghuming=new JLabel("����Ա�û���");yonghuming.setBounds(500,150,150,30);label1.add(yonghuming);yonghuming.setFont(tool.f12);
		kuang1=new JTextField(15);kuang1.setBounds(650,150,150,30);label1.add(kuang1);
		yuanmima=new JLabel("����Աԭ����");yuanmima.setBounds(500,250,150,30);label1.add(yuanmima);yuanmima.setFont(tool.f12);
		kuang2=new JPasswordField(15);kuang2.setBounds(650,250,150,30);label1.add(kuang2);
		newmima=new JLabel("����Ա������");newmima.setBounds(500,350,150,30);label1.add(newmima);newmima.setFont(tool.f12);
		kuang3=new JPasswordField(15);kuang3.setBounds(650,350,150,30);label1.add(kuang3);
		an=new JButton("�޸Ĺ���Ա����");an.setFont(tool.f1);an.setBounds(400,420,150,30);label1.add(an);an.addActionListener(this);//�޸İ�ťע�����
		anan=new JButton("ɾ������Ա�˺�");anan.setFont(tool.f1);anan.setBounds(550,420,150,30);label1.add(anan);anan.addActionListener(this);//ɾ����ťע�����
		anan1=new JButton("��ѯ����Ա����");anan1.setFont(tool.f1);anan1.setBounds(700,420,150,30);label1.add(anan1);anan1.addActionListener(this);//��ѯ��ťע�����
		yonghuming.setForeground(Color.BLUE);yuanmima.setForeground(Color.BLUE);
		newmima.setForeground(Color.BLUE);an.setForeground(Color.BLUE);
	}
	//������-----------------------------------------------------------------------------
	
	 public static void main(String[] args){
	 
		new manager();
	}
	
	//�¼�����---------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
		Connection con=new TestJDBC().getCon();//�������ݿ⣬�������Ӷ���con--------------
		
		//tj����е����ѧ����Ϣ��ѧ���ɼ��Ĺ���ʵ��---------------------------------------
		if(e.getSource()==an1){
			tianjiamodel TJ=new tianjiamodel();
			TJ.TIAN(jtt[0].getText(), jtt[1].getText(), jtt[2].getText(), jtt[3].getText(), jtt[4].getText(), 
					jtt[5].getText(), jtt[6].getText(),jtt[7].getText(),jtt[8].getText(),jtt[9].getText(),jtt[10].getText());
			jtt[2].setText("");jtt[3].setText("");jtt[4].setText("");jtt[5].setText("");jtt[6].setText("");jtt[7].setText("");
			jtt[8].setText("");jtt[9].setText("");jtt[10].setText("");jtt[11].setText("");
		}
		else if(e.getSource()==an2){
			tianjiamodel TJ=new tianjiamodel();
			TJ.TIAN1(jtt[0].getText(),jtt[1].getText(),jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText());
			jtt[0].setText("");jtt[1].setText("");jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
		}
		
		//sc�����ɾ��ѧ����Ϣ�ͳɼ���ģʽ����ʵ��------------------------------------------
		else if(e.getSource()==an3){
			shanchumodel sc=new shanchumodel();
			sc.SC(xuehao.getText(),xingming.getText());
		}
		else if(e.getSource()==an4){
			shanchumodel sc=new shanchumodel();
			sc.SC1(xuehao.getText(),xingming.getText());
		}
		
		//��ѧ�Ų�ѯ������Ϣ------------------------------------------------------------------
		else if(e.getSource()==anniu){
			selectmodel S=new selectmodel();
			String[] shou=S.Se(wenbenk.getText(), 0);
			for(int i=0;i<6;i++){
				table.setValueAt(shou[i], 0, i);	
			}
		}
		//��ѧ�Ų�ѯ�ɼ�-----------------------------------------------------------------------
		else if(e.getSource()==anniu1){
			selectmodel S=new selectmodel();
			String[] shou1=S.Se(wenbenk1.getText(), 1);
			for(int i=0;i<4;i++){
				table1.setValueAt(shou1[i], 0, i);	
			}
		}	
		
		//���£�ͨ��ѧ�Ų��ҵ���ϢȻ����£�ѧ�����������ܸ���-----------------------------------
		else if(e.getSource()==an11){
			genxinmodel GENXIN=new genxinmodel();
			GENXIN.GGXX(jt[0].getText(), jt[1].getText(), jt[2].getText(), jt[3].getText(), jt[4].getText(), 
					jt[5].getText(), jt[6].getText(),jt[7].getText(),jt[8].getText(),jt[9].getText(),jt[10].getText());
			jt[2].setText("");jt[3].setText("");jt[4].setText("");jt[5].setText("");jt[6].setText("");
		}
			
		else if(e.getSource()==an22){
			genxinmodel GENXIN=new genxinmodel();
			GENXIN.GGXX1( jt[0].getText(),jt[1].getText(),jtf11.getText(), jtf22.getText(), jtf33.getText(), jtf44.getText());
		}
		
		//own����й���Ա������޸Ĺ��ܵ�ģʽʵ��(anan,anan1���ܻ�δʵ��)---------------------------------
		else if(e.getSource()==an){
			ownmimaUPDATE mima=new ownmimaUPDATE();
			mima.ownUP(kuang1.getText(),new String(kuang2.getPassword()),new String(kuang3.getPassword()));
			this.dispose();
		}//ɾ���˺�------------------------------------------------------------------------------------
		else if(e.getSource()==anan){
			ownmimaUPDATE mima=new ownmimaUPDATE();
			mima.del(kuang1.getText());
		}//��ѯ����-------------------------------------------------------------------------------------
		else if(e.getSource()==anan1){
			ownmimaUPDATE mima=new ownmimaUPDATE();
			String B=mima.chaxun(kuang1.getText());
			kuang2.setText(B);
			System.out.println("ԭ����Ϊ��"+B);
		}
	}	
}