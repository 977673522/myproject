package grade.VIEW;

import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class jishi extends JFrame implements ActionListener{
	
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("�ļ�(F)");
		JMenuItem jmi1=new JMenuItem("�½�(N)");
		JMenuItem jmi2=new JMenuItem("��(O)...");
		JMenuItem jmi3=new JMenuItem("����(S)");
		JMenuItem jmi4=new JMenuItem("���Ϊ(A)...");
		JMenuItem jmi5=new JMenuItem("�˳�(X)");
		JMenuItem jmi6=new JMenuItem("ҳ�沼��(U)");
		JMenuItem jmi7=new JMenuItem("��ӡ(P)");
		JMenu jm2=new JMenu("�༭(E)");
		JMenuItem jmi8=new JMenuItem("����(U)");JMenuItem jmi9=new JMenuItem("����(T)");
		JMenuItem jmi10=new JMenuItem("����(C)");JMenuItem jmi11=new JMenuItem("ճ��(P)");
		JMenuItem jmi12=new JMenuItem("ɾ��(L)");JMenuItem jmi13=new JMenuItem("����(F)...");
		JMenuItem jmi14=new JMenuItem("������һ��(N)");JMenuItem jmi15=new JMenuItem("�滻(R)...");
		JMenuItem jmi16=new JMenuItem("ת��(G)...");JMenuItem jmi17=new JMenuItem("ȫѡ(A)");
		JMenuItem jmi18=new JMenuItem("ʱ��/����(D)");
		JMenu jm3=new JMenu("��ʽ(O)");
		JMenuItem jmi19=new JMenuItem("�Զ�����(W)");
		JMenuItem jmi20=new JMenuItem("����");
		JMenu jm4=new JMenu("�鿴(V)");
		JMenuItem jmi21=new JMenuItem("״̬��(S)");
		JMenu jm5=new JMenu("����(H)");
		JMenuItem jmi22=new JMenuItem("�鿴����(H)");
		JMenuItem jmi23=new JMenuItem("���ڼ��±�(A)");
	
		JTextArea jta=new JTextArea();
	
	//@Override
	File selectFile;
	public void actionPerformed(ActionEvent e){
		String a=null;
		if(jmi1==e.getSource()){//�½�����
			this.setTitle("�ޱ��� - ���±�");
			jta.setText("");
			selectFile=null;
		}else if(jmi2==e.getSource()){//��.txt�ļ�����
			JFileChooser jf=new JFileChooser();
			jf.showOpenDialog(this);
			selectFile=jf.getSelectedFile();
			try{
				//��ʼ��ȡ�ļ�����selectFile��ַ���ļ�
				FileReader f=new FileReader(selectFile);
				//���ú�һ�������ȡ��ʽ�����������Ż���ȡ�ٶ�
				BufferedReader br=new BufferedReader(f);
				String txt="";
				String line=null;
				while((line=br.readLine())!=null){
					txt+=line+"\n";
				}
				br.close();
				this.setTitle(selectFile.getName()+"-���±�");
				jta.setText(txt);
			}
			catch(Exception e1){
				
			}	
		}else if(jmi3==e.getSource()){//���湦��
			
			if(selectFile==null){//û�д򿪹��ļ�
				
				JFileChooser jf=new JFileChooser();
				jf.showSaveDialog(this);
				selectFile=jf.getSelectedFile();
				this.setTitle(selectFile.getName()+"- ���±�");
				}
			//�д򿪹���ǰ���ļ����Ͱ�����ǰ���ļ�·������
				try{
					FileWriter f=new FileWriter(selectFile);
					f.write(jta.getText());
					f.close();
				}catch(Exception e2){
					
				}
		}else if(jmi4==e.getSource()){//���Ϊ����
			JFileChooser jf=new JFileChooser();
			jf.showSaveDialog(this);
			selectFile=jf.getSelectedFile();
			this.setTitle(selectFile.getName()+"- ���±�");
			try{
				FileWriter f=new FileWriter(selectFile);
				f.write(jta.getText());
				f.close();
			}catch(Exception e2){
				
			}
		}else if(jmi5==e.getSource()){//�˳�����
				if(selectFile==null){//û�д򿪹��ļ�
				
				JFileChooser jf=new JFileChooser();
				jf.showSaveDialog(this);
				selectFile=jf.getSelectedFile();
				this.setTitle(selectFile.getName()+"- ���±�");
				}
			//�д򿪹���ǰ���ļ����Ͱ�����ǰ���ļ�·������
				try{
					FileWriter f=new FileWriter(selectFile);
					f.write(jta.getText());
					f.close();
				}catch(Exception e2){
					
				}
			System.exit(0);
		}
		else if(jmi6==e.getSource()){
			JOptionPane.showMessageDialog(null, "ҳ�沼�ֹ�����δʵ�֣��Բ���");
		}
		else if(jmi7==e.getSource()){
			JOptionPane.showMessageDialog(null, "��ӡ������δʵ�֣��Բ���");
		}
		else if(jmi8==e.getSource()){
			jta.setText("");
		}
		
		else if(jmi9==e.getSource()){
			a=jta.getText();
			jta.setText("");
			//jta.setText(a);
		}
		else if(jmi10==e.getSource()){
			jta.getText();
		}
		else if(jmi11==e.getSource()){
			jta.setText(a);
		}
	}
	
	public jishi(){
		this.setTitle("�½��ı��ĵ� - ���±�");
		this.setSize(500,400);
		this.setLocation(500, 200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);
		jmi6.addActionListener(this);
		jmi7.addActionListener(this);
		jmi8.addActionListener(this);
		jmi9.addActionListener(this);
		jmi10.addActionListener(this);
		jmi11.addActionListener(this);
		jm.add(jmi1);jm.add(jmi2);jm.add(jmi3);jm.add(jmi4);jm.add(jmi6);jm.add(jmi7);jm.add(jmi5);
		jm2.add(jmi8);jm2.add(jmi9);jm2.add(jmi10);jm2.add(jmi11);
		jm2.add(jmi12);jm2.add(jmi13);jm2.add(jmi14);jm2.add(jmi15);
		jm2.add(jmi16);jm2.add(jmi17);jm2.add(jmi18);
		jm3.add(jmi19);jm3.add(jmi20);
		jm4.add(jmi21);
		jm5.add(jmi22);jm5.add(jmi23);
		jmb.add(jm);jmb.add(jm2);jmb.add(jm3);jmb.add(jm4);jmb.add(jm5);
		this.setJMenuBar(jmb);
		JScrollPane js=new JScrollPane();
		js.getViewport().setView(jta);
		this.add(js);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("image//���±�LOGO.png"));
		this.setVisible(true);
	}
	public static void main(String[] args){
		new jishi();
	}
}
