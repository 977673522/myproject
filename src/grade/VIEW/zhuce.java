//�ļ���
package grade.VIEW;
//����
import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
//�Լ���������Ϊ��
import grade.Tool.tool;
import grade.MODEL.zhucemodel;
//ע����
public class zhuce {
	//������
	
	 public static void main(String[] args){
		new zhuce();//��������
	}
	
	//�������--------------------------------------------------------------
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
	//���캯��--------------------------------------------------------------
	public zhuce(){
		//������----------------------------------------------------------
		jf = new JFrame("��ӭ����ɼ���Ϣ����ϵͳ");
		jf.setResizable(false);
		//�������,��������е�����------------------------------------------
		jl1=new JLabel("ע���û���");
		jl1.setFont(tool.f6);
		jt1=new JTextField(15);
		jl2=new JLabel("ע������");
		jl2.setFont(tool.f6);
		jl3=new JLabel("��ӭ����ѧ����Ϣ����ϵͳ����������ע���ٵ�¼");
		jl3.setForeground(Color.RED);
		jl3.setFont(tool.f10);
		jt2=new JTextField(15);
		gl=new JCheckBox("����Ա");
		gl.setFont(tool.f3);
		pt=new JCheckBox("ѧ��");
		pt.setFont(tool.f3);
		jb1=new JButton("ע��");
		jb1.setFont(tool.f5);
		// ���ر���ͼƬ------------------------------------------------------
		background=new ImageIcon("image\\f.jpg");
		// �ñ�ǩ����ͼƬ----------------------------------------------------
		label=new JLabel(background);
		// ���ñ�ǩ��С------------------------------------------------------
		label.setBounds(0, 0, 1500,800);
		// ������������JPanel----------------------------------------------
		jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		jp=(JPanel)jf.getContentPane();
		//JPanel����ſ��Ե���setOpaque(false);�����Ƿ�͸��-------------------
		jp.setOpaque(false);
		jpanel = new JPanel();
		jpanel.setOpaque(false);
		// ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ----------------------
		jpanel.setLayout(null);
		jpanel.setBorder(BorderFactory.createTitledBorder("��ӭ����ע�����"));
		//setBounds()�������������λ�úʹ�С----------------------------------
		jl3.setBounds(10,10,1500,30);
	    jl1.setBounds(550,100,100,30);
	    jt1.setBounds(700,100,150,30);
	    jl2.setBounds(550,150,100,30);
	    jt2.setBounds(700,150,150,30);
	    gl.setBounds(550,220,100,30);
	    pt.setBounds(750,220,100,30);
	    jb1.setBounds(650,300,100,30);
	    //������������к������嵽�����-------------------------------------
	    jpanel.add(jl3); 
	    jpanel.add(jl1); 
	    jpanel.add(jt1); 
	    jpanel.add(jl2);
	    jpanel.add(jt2);
	    jpanel.add(gl);
	    jpanel.add(pt);
	    jpanel.add(jb1);
	    jf.add(jpanel);
		//���ÿ�ܵı���,��С,�ɼ���,�رս��̲���--------------------------------
	    jf.setTitle("ע�����");
		jf.setSize(1500,800);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\title.jpg"));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ťע�ᶯ��������ʵ�ֹ���--------------------------------------------
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(gl.isSelected()==false&&pt.isSelected()==false){
					JOptionPane.showMessageDialog(null,"��ѡ��ע���û��Ľ�ɫ��");
				}
				//��zhucemodelģʽ��ʵ��ע�Ṧ��---------------------------------
				else if(gl.isSelected()==true&&pt.isSelected()==false){
					if(jt1.getText().equals("")&&jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע����û��������룡");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע����û�����");
						jt2.setText("");
					}else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע���û������룡");
					}else{
						zhucemodel zc=new zhucemodel();
						zc.zc(jt1.getText(),jt2.getText(),true);
						jf.dispose();
					}	
			    }else if(pt.isSelected()==true&&gl.isSelected()==false){
					if(jt1.getText().equals("")&&jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע����û��������룡");
					}
					else if(jt1.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע����û�����");
						jt2.setText("");
					}else if(jt2.getText().equals("")){
						JOptionPane.showMessageDialog(null,"��������Ҫע���û������룡");
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
/*��ģʽ��ע��ѧ���û��͹���Ա�û����ܵ�ʵ��
 * 	Connection conn=new TestJDBC().getCon();
	String sql="insert into M values(?,?)";//�������Ա�˺š����뱣���ڱ�M��
	PreparedStatement pst = null;
	//�������Աѡ���ѡ����ע�����Ա�û�
	if(gl.isSelected()==true){
		try
		{
			//�жϵ�½���Ƿ��Ѿ�����
			Statement s = null;
			ResultSet rs = null;
			String sql_ck = "Select ID FROM M";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, jt1.getText());
				pst.setString(2, jt2.getText());
				//�жϵ�½���Ƿ��Ѿ�����
				s = conn.createStatement();
				rs = s.executeQuery(sql_ck);
				int i=1;
				while(rs.next()){//Ϊʲô�� rs.getString(2)����ʾ ��Ч��������
					if( rs.getString(i).equals(jt1.getText())){
						JOptionPane.showMessageDialog(null,"�ù���Ա�û��Ѿ����ڣ�ע��ʧ��");		
						jt1.setText("");
						jt2.setText("");
						System.exit(0);
						new LOGIN();
					}
				}
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"ע�����Ա�ɹ�,����������ݿ��в鿴���ע�����Ϣ");
						jf.dispose();
						new LOGIN();
				} 
			catch (Exception ev) {}	
		}
		catch (Exception ev) {}
		
}
	//�������Աѡ���ѡ����ע��ѧ���û�
		if(pt.isSelected()==true){
			try
			{
				
				Statement s = null;
				ResultSet rs = null;
				//Ϊ���жϵ�½���Ƿ��Ѿ����ڣ������Ƿ���һ�����û���
				String sql_ck = "Select ID FROM LOGIN";
				//���Ҳ����ע���õ��û������ݿ���
				String sql1="insert into LOGIN values(?,?)";//�������Ա�˺š����뱣���ڱ�M��
				try {
					pst = conn.prepareStatement(sql1);
					pst.setString(1, jt1.getText());
					pst.setString(2, jt2.getText());
					//�жϵ�½���Ƿ��Ѿ�����
					s = conn.createStatement();
					rs = s.executeQuery(sql_ck);
					int i=1;
					while(rs.next()){
							if( rs.getString(i).equals(jt1.getText())){
								JOptionPane.showMessageDialog(null,"����ͨ�û��Ѿ����ڣ�ע��ʧ��");
								jt1.setText("");
								jt2.setText("");
								System.exit(0);
								new LOGIN();
						}
					}
						pst.executeUpdate();//���µ����ݿ�
						JOptionPane.showMessageDialog(null,"ע����ͨ�û��ɹ�,����������ݿ��в鿴���ע�����Ϣ");
						jf.dispose();
						new LOGIN();
					}
				catch (Exception ev) {}		
		}
		catch (Exception ev) {}
	}*/