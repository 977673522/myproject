package grade.VIEW;//�ļ���----------------------------------------------

//����-------------------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.swing.*;

import grade.DB.TestJDBC;
import grade.MODEL.loginmodel;
import grade.Tool.tool;
//��¼��̳�JFrame��ʵ���˼����ӿ�--------------------
public class LOGIN extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//���������
	JButton btn1 ;
	JButton btn2 ;
	JButton btn3 ;
	JRadioButton jrb1;
	JRadioButton jrb2;
	JTextField jt1 ;
	JPasswordField jpassword;
	JFrame jf ;
	
	
	//������-----------------------------------------------------------
	public static void main(String[] args)
	{		
		//���������----------------------------------------------------
		new LOGIN();
	}
	//���캯��---------------------------------------------------------
	public LOGIN(){
		
		//������ܣ�JFrame��ģ�����-------------------------------------------------
		jf = new JFrame("��ӭ����ɼ���Ϣ����ϵͳ");
		//���ñ߿򲼾�
		jf.setLayout(new BorderLayout());
		//����ͼƬ���󲢼���ͼƬ----------------------------------------
		Image img = new ImageIcon("image\\title.jpg").getImage();
		//��������ͼ��ͼ��-------------------------------------------
		jf.setIconImage(img);
		//���ÿ�ܵ�����-----------------------------------------------
		jf.setTitle("��¼����");
		//���ÿ�ܵĴ�С-----------------------------------------------
		jf.setSize(1500, 800);
		jf.setLocation(0,0);
		//	jf.setResizable(false);
		//��ܵĿɼ������÷���ÿ�����������뵽��������Ϊ�ɼ�true----
		//jf.setVisible(true);
		//���ÿ�ܵ��˳����ͷ���Դ�ͷ��ڴ�ռ䣬������ת����һ������X�رջ�һͬ�ر�֮ǰ�Ľ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������ǩlb0��lb1,lb2�Ҵ���������Ϣ ,����������ɫ�����ͣ�״̬�ʹ�С
		JLabel lb0 = new JLabel("ѧ����Ϣ����");
		lb0.setForeground(Color.RED);
		lb0.setFont(new Font("����",Font.BOLD,60));//���壬�Ӵ֣�60������
		
		JLabel lb1 = new JLabel("��       ��      ��:");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("����",Font.PLAIN,18));//���壬ϸ��18������
		
		JLabel lb2 = new JLabel("��               ��:");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("����",Font.PLAIN,18));//���壬ϸ��18������
		
		//�����ı������jt1��jt2,����15---------------------------------------
		jt1 = new JTextField(15);jt1.addActionListener(this);
		jt1.setBorder(BorderFactory.createLoweredBevelBorder());
		jt1.setFont(tool.f10);
		jpassword = new JPasswordField(15);jpassword.addActionListener(this);
		jpassword.setBorder(BorderFactory.createLoweredBevelBorder());
		jpassword.setFont(tool.f10);
		//���������Ļ����ַ�-------------------------------------------------
		jpassword.setEchoChar('*');
		//������ѡ��ťjrb1,jrb2,���Ҵ���������Ϣ-------------------------------
		jrb1=new JRadioButton("����Ա");
		jrb2=new JRadioButton("ѧ     ��");
		//������ťbn1,bn2,bn3,���Ҵ���������ʾ------------------------------------
		btn1 = new JButton("��  ¼");btn1.addActionListener(this);
		btn2 = new JButton("�� ��");btn2.addActionListener(this);
		btn3 = new JButton("ע��");btn3.addActionListener(this);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg------------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// �ñ�ǩ����ͼƬ����--------------------------------------------------
		JLabel label=new JLabel(background);
		// ���ñ�ǩ��С---------------------------------------------------------
		label.setBounds(0, 0, 1500,800);
		//background.getIconWidth(), background.getIconHeight());����ǰ�����Ƭ�Ĵ�С���ؽ����ģ����Դ���1500,800
		
		// ������������JPanel��岢����ӱ�ǩ��������������---------------------
		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		//jf.add(label,BorderLayout.CENTER);
		JPanel jpanel1=(JPanel)jf.getContentPane();
		//JPanel����ſ��Ե���setOpaque(false);�����Ƿ�͸��----------------------
		jpanel1.setOpaque(false);
		//������岢����ָ����Ƿ�͸��------------------------------------------
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ-----------------------
		jpanel.setLayout(null);
		//�������ı߿����֡���ӭ�����¼���桱-----------------------------------
	    jpanel.setBorder(BorderFactory.createTitledBorder("��ӭ�����¼����"));
	    //����׳��Ŭ�����ϴ�ͽ�˱�������ı�ǩ����Ĵ������Լ���ǩ�������úͱ�ǩ��ɫ����
	   JLabel label1=new JLabel("��");label1.setFont(tool.f9);label1.setForeground(Color.red);
	    JLabel label2=new JLabel("׳");label2.setFont(tool.f9);label2.setForeground(Color.red);
	    JLabel label3=new JLabel("��");label3.setFont(tool.f9);label3.setForeground(Color.red);
	    JLabel label4=new JLabel("Ŭ");label4.setFont(tool.f9);label4.setForeground(Color.red);
	    JLabel label5=new JLabel("��");label5.setFont(tool.f9);label5.setForeground(Color.red);
	    JLabel label6=new JLabel("��");label6.setFont(tool.f9);label6.setForeground(Color.red);
	    JLabel label7=new JLabel("��");label7.setFont(tool.f9);label7.setForeground(Color.red);
	    JLabel label8=new JLabel("ͽ");label8.setFont(tool.f9);label8.setForeground(Color.red);
	    JLabel label9=new JLabel("��");label9.setFont(tool.f9);label9.setForeground(Color.red);
	    JLabel label10=new JLabel("��");label10.setFont(tool.f9);label10.setForeground(Color.red);
	    //����׳��Ŭ�����ϴ�ͽ�˱�������ı�ǩ����Ķ�λ------------------------------
	    label1.setBounds(200, 100, 300,60);
	    label2.setBounds(200, 180, 300,60);
	    label3.setBounds(200, 260, 300,60);
	    label4.setBounds(200, 340, 300,60);
	    label5.setBounds(200, 420, 300,60);
	    label6.setBounds(1170, 100, 300,60);
	    label7.setBounds(1170, 180, 300,60);
	    label8.setBounds(1170, 260, 300,60);
	    label9.setBounds(1170, 340, 300,60);
	    label10.setBounds(1170, 420, 300,60);
	  
	  
		//�û�����ǩ���ı��������ǩ���ı���������λ--------------------------------
		lb0.setBounds(500,50, 600, 60);
		lb1.setBounds(500,150, 200, 40);
		lb2.setBounds(500,200, 200, 40);
		jt1.setBounds(700, 150, 180, 30);
		jpassword.setBounds(700, 200, 180,30);
		//����Ա��ѧ���ĵ�ѡ��ť����Ķ�λ----------------------------------------------
		jrb1.setBounds(550,280, 100, 30);
		jrb2.setBounds(720,280, 100, 30);
		//��¼�����ã�ע�ᰴť����Ķ�λ------------------------------------------------
		btn1.setBounds(500,360, 120, 35);
		btn2.setBounds(620,360, 120, 35);
		btn3.setBounds(740,360, 120, 35);
		
		//�����������ӵ����jpanel��-------------------------------------------------
		jpanel.add(label1);jpanel.add(label2);
		jpanel.add(label3);jpanel.add(label4);jpanel.add(label5);
		jpanel.add(label6);jpanel.add(label7);
		jpanel.add(label8);jpanel.add(label9);jpanel.add(label10);
		jpanel.add(lb0);
		jpanel.add(lb1);
		jpanel.add(lb2);
		jpanel.add(btn1);
		jpanel.add(btn2);
		jpanel.add(btn3);
		
		jpanel.add(jt1);
		jpanel.add(jpassword);
		jpanel.add(jrb1);
		jpanel.add(jrb2);
		//���jpanel��ӵ�����У��������ÿ�ܿɼ�-------------------------------------
		jf.add(jpanel);
		jf.setVisible(true);	
	}
	loginmodel l=new loginmodel();
	Connection conn=new TestJDBC().getCon();
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn1){
			if(jrb1.isSelected()==false&&jrb2.isSelected()==false){
				JOptionPane.showMessageDialog(null,"��ѡ���ɫ��");
			}else if(jrb1.isSelected()==true){
				if(jt1.getText().equals("")){
        			JOptionPane.showMessageDialog(null,"�û�����Ϊ��");
			    }else if(new String(jpassword.getPassword()).equals(""))
			    {
        			JOptionPane.showMessageDialog(null,"���벻��Ϊ��");
        		}else{
        			
        			
        			//��д�����û���Ҫ��֤�û����ĺϷ���
			    	//�����û��������ݿ�����û���ƥ�䣬���Ƿ�����ͬ���û�������
			    	/*try{
						ResultSet rs;
						String SQ="SELECT ID FROM LOGIN ";
						PreparedStatement statl=conn.prepareStatement(SQ);
						rs=statl.executeQuery();
						int i=0;
						while(rs.next()){
							if(rs.getString(i+1).equals(jt1.getText())){
								JOptionPane.showMessageDialog(null,"���û�����");
							}
							i++;
					    }
					}catch(Exception exception){
						System.out.println("NOT"+exception);
					}*/
			 
			    	
			    	 	//��ģʽ�µĹ���Ա��¼���ܵ�ʵ��-----------------------------------
						//��֤-----------------------------------------------------------
						loginmodel model=new loginmodel();
						boolean i=false;
						String res=model.checkUser(jt1.getText().trim(),i);
						if(res.equals(new String(jpassword.getPassword())))
						{
							jf.dispose();
							JOptionPane.showMessageDialog(null,"��ӭ"+jt1.getText()+"����Ա����ѧ������ϵͳ");
							new manager();
						}else {
							//��������ĵ�¼��Ϣ------------------------------------------
							JOptionPane.showMessageDialog(null, "����Ա�������,��������������");
							jt1.setText("");
							jpassword.setText("");
						}
        		}
			}else if(jrb2.isSelected()==true){
				if(jt1.getText().equals("")){
        			JOptionPane.showMessageDialog(null,"�û�����Ϊ��");
			    }else if(new String(jpassword.getPassword()).equals(""))
			    {
        			JOptionPane.showMessageDialog(null,"���벻��Ϊ��");
        		}else	if(jrb2.isSelected()==false){
        			JOptionPane.showMessageDialog(null,"��ѡ���ɫ");
        		}else{
			    	 	//��ģʽ�µ�ѧ����¼���ܵ�ʵ��-----------------------------------
						//��֤----------------------------------------------------------
						//loginmodel model=new loginmodel();
						boolean i1=true;
						String res=l.checkUser(jt1.getText().trim(),i1);
						if(res.equals(new String(jpassword.getPassword())))
						{
							jf.dispose();
							JOptionPane.showMessageDialog(null,"��ӭ"+jt1.getText()+"ѧ������ѧ������ϵͳ");
							new zjm();
						}else {
							//��������ĵ�¼��Ϣ---------------------------------------------
							JOptionPane.showMessageDialog(null, "�û��������,��������������");
							jt1.setText("");
							jpassword.setText("");
						}
        		}        			
			}
		}
		else if(e.getSource()==btn2){//���ð�ťע�������-------------------------------
			jt1.setText("");
			jpassword.setText("");
		}
		else if(e.getSource()==btn3){//ע�ᰴťע�������-------------------------------
			jf.dispose();
			new zhuce();
		}
	}
}