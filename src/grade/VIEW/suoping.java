package grade.VIEW;
import java.awt.*;
import grade.Tool.*;
import javax.swing.*;
import java.awt.event.*;
public class suoping extends JFrame implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jiesuo){
			//����������֤����ܻص�������(�˹���δʵ��)--------------------
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
		this.setUndecorated(true);//ȥ���߿���ǣ�----------------------
		this.InitVIEW();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void InitVIEW(){
		jiesuo=new JButton("����");
		jiesuo.setFont(tool.f8);
		jiesuo.setForeground(Color.blue);
		jiesuo.addActionListener(this);
		this.add(jiesuo,BorderLayout.NORTH);
		// ����ͼƬ�����Ҽ��ر���ͼƬf.jpg-------------------------------
		ImageIcon background=new ImageIcon("image\\f.jpg");
		// �ñ�ǩ����ͼƬ����----------------------------------------------
		JLabel label=new JLabel(background);
		// ���ñ�ǩ��С
		label.setBounds(0, 0, 1500,1000);
		//background.getIconWidth(), background.getIconHeight());����ǰ�����Ƭ�Ĵ�С���ؽ����ģ����Դ���1500,800
		// ������������JPanel��岢����ӱ�ǩ��������������
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jpanel1=(JPanel)this.getContentPane();
		//JPanel����ſ��Ե���setOpaque(false);�����Ƿ�͸��----------------------------
		jpanel1.setOpaque(false);
		//������岢����ָ����Ƿ�͸��-------------------------------------------------
		JPanel jpanel = new JPanel();
		jpanel.setOpaque(false);
		// ȥ��JPanelĬ�ϲ��ַ�ʽ,��ʵ�ָ����ؼ��Լ��Ķ�λ------------------------------
		jpanel.setLayout(null);
		this.add(label,BorderLayout.CENTER);
	}
}
