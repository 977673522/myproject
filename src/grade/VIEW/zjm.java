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
	
	//�������-------------------------------------------------
	JMenuBar JMB;
	JMenu JM1,JM2,JM3;
	JMenuItem jm1,jm2,jm3,jm4,jm5,jm6,jm7;
	JToolBar gjl;
	JButton an1,an2,an3,an4,an5,an6,an7,an8,an9,an10;
	JLabel label;
	//���캯��------------------------------------------------
	public zjm(){
		this.setTitle("ѧ��������");
		this.setSize(1500,800);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//�������������------------------------------------------
		gjl=new JToolBar(SwingConstants.VERTICAL);
		gjl.setBackground(Color.CYAN);
		//���ù��������Ը���----------------------------------------
		gjl.setFloatable(false);
		an1=new JButton(new ImageIcon("image/jb1.png"));
		an2=new JButton(new ImageIcon("image/jb2.png"));
		an3=new JButton(new ImageIcon("image/jb9.png"));
		an4=new JButton(new ImageIcon("image/jb10.jpg"));
		an5=new JButton(new ImageIcon("image/jb12.png"));an5.setBackground(Color.lightGray);
		an6=new JButton(new ImageIcon("image/jb3.png"));
		an7=new JButton(new ImageIcon("image/���±�LOGO.png"));
		an8=new JButton(new ImageIcon("image/ji.png"));
		an9=new JButton(new ImageIcon("image/jb7.png"));
		an10=new JButton(new ImageIcon("image/jb8.png"));
		//���빤����-------------------------------------------------
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
		// ���ر���ͼƬ-------------------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// �ñ�ǩ����ͼƬ-----------------------------------------
		JLabel label=new JLabel(background);
		// ���ñ�ǩ��С-------------------------------------------
		label.setBounds(0, 0, 1500,800);//background.getIconWidth(), background.getIconHeight());
		// ������������JPanel-----------------------------------
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane();
		//JPanel����ſ��Ե���setOpaque(false);�����Ƿ�͸��-------
		jp.setOpaque(false);
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ---------
		jpanel.setLayout(null);
		label=new JLabel("��ӭ����ѧ����Ϣ����ϵͳ");
		label.setForeground(Color.RED);
		label.setFont(new Font("����",Font.BOLD,50));
		label.setBounds(350,200,800,50);
		jpanel.add(label,BorderLayout.CENTER);
		this.add(jpanel);	
		//����ʹ����˵���,�˵��Ͳ˵���---------------------------
		JMB=new JMenuBar();	JMB.setBackground(Color.CYAN);
		JM1=new JMenu("ϵͳ����");	JM1.setFont(tool.f5);	JM1.setForeground(Color.MAGENTA);	
		JM2=new JMenu("��ѯ����");	JM2.setFont(tool.f5);	JM2.setForeground(Color.MAGENTA);	
		JM3=new JMenu("����");		JM3.setFont(tool.f5);	JM3.setForeground(Color.MAGENTA);	
		ImageIcon image1=new ImageIcon("image/image1.png");
		ImageIcon image2=new ImageIcon("image/image2.jpg");
		ImageIcon image3=new ImageIcon("image/image3.png");
		jm1=new JMenuItem("���µ�¼",image1);	jm1.setFont(tool.f5);	jm1.setForeground(Color.MAGENTA);	
		jm2=new JMenuItem("�޸�����",image2);	jm2.setFont(tool.f5);	jm2.setForeground(Color.MAGENTA);	
		jm3=new JMenuItem("�˳�",image3);		jm3.setFont(tool.f5);	jm3.setForeground(Color.MAGENTA);	
		jm4=new JMenuItem("ѧ����Ϣ��ѯ");		jm4.setFont(tool.f5);	jm4.setForeground(Color.MAGENTA);	
		jm5=new JMenuItem("ѧ���ɼ���ѯ");		jm5.setFont(tool.f5);	jm5.setForeground(Color.MAGENTA);	
		jm6=new JMenuItem("ϵͳ���");			jm6.setFont(tool.f5);	jm6.setForeground(Color.MAGENTA);	
		jm7=new JMenuItem("OS�汾");				jm7.setFont(tool.f5);	jm7.setForeground(Color.MAGENTA);	
		//���˵�����ص��˵�--------------------------------------
		JM1.add(jm1);
		JM1.add(jm2);
		JM1.add(jm3);
		JM2.add(jm4);
		JM2.add(jm5);
		JM3.add(jm6);
		JM3.add(jm7);
		//���˵����ص��˵���--------------------------------------
		JMB.add(JM1);
		JMB.add(JM2);
		JMB.add(JM3);
		//���˵������ص����--------------------------------------
		this.setJMenuBar(JMB);
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image/title.jpg"));
		//�˵������µ�¼ע���¼�����	----------------------------
		jm1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				 dispose();//�ر��������-----------------------
				 new LOGIN();//��ת����¼�������µ�¼------------
			}
		});
		//�˵����޸�����ע���¼�����-----------------------------
		jm2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
						//�޸����빦��	-----------------------
					dispose();
					new xiugaimima();
				}
		});
		//�˵����˳�ע���¼�����---------------------------------				
		jm3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//�˳�------------------------------------------
				int yes=JOptionPane.showConfirmDialog(null, "ȷ���˳�", "��ܰ��ʾ", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	else{
					JOptionPane.showMessageDialog(null, "��������ʹ�ã�");
				}
			}
		});
		//�˵����ѯѧ����Ϣע���¼�����-------------------------
		jm4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new cx2();
			}
		});
		//�˵����ѯѧ���ɼ�ע���¼�����-------------------------
		jm5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new cx2();	
			}
		});
		//�˵���ϵͳ���ע���¼�����----------------------------
		jm6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//dispose();
				new ϵͳ���();
			}
		});
		//�˵���ϵͳ�汾ע���¼�����----------------------------
		jm7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JOptionPane.showMessageDialog(null,"�����ϵͳΪWindows 10��ͥ���İ�");	
			}
		});
		//��ť���µ�½ע���¼�����-----------------------------
		an1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				dispose();
				new LOGIN();
			}
		});
		//��ť�޸�����ע���¼�����------------------------------
		an2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//�޸����빦��--------------------------------
				dispose();
				new xiugaimima();
			}
		});
		an3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//��Ϣ��ѯ-------------------------------------
				//dispose();
				new cx2();
			}
		});
		an4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//�ɼ���ѯ------------------------------------
				//dispose();
				new cx2();
			}
		});
		an5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//ѧ��ѡ��-----------------------------------
				//dispose();
				new cx2();
				
			}
		});
		an6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//��������-----------------------------------
				dispose();
				new suoping();
			}
		});
		an7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//���±�------------------------------------
				new jishi();
			}
		});
		an8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				//������------------------------------------
				new JS();
			}
		});
		an9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JOptionPane.showMessageDialog(null,"������ҵı�ҵ�������:ѧ����Ϣ����ϵͳ������");	
			}
		});
		an10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				int yes=JOptionPane.showConfirmDialog(null, "ȷ���˳�", "��ܰ��ʾ", JOptionPane.YES_OPTION);
				if(yes==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}	else{
					JOptionPane.showMessageDialog(null, "��������ʹ�ã�");
				}
			}
		});
	}	
}