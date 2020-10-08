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
		JMenu jm=new JMenu("文件(F)");
		JMenuItem jmi1=new JMenuItem("新建(N)");
		JMenuItem jmi2=new JMenuItem("打开(O)...");
		JMenuItem jmi3=new JMenuItem("保存(S)");
		JMenuItem jmi4=new JMenuItem("另存为(A)...");
		JMenuItem jmi5=new JMenuItem("退出(X)");
		JMenuItem jmi6=new JMenuItem("页面布局(U)");
		JMenuItem jmi7=new JMenuItem("打印(P)");
		JMenu jm2=new JMenu("编辑(E)");
		JMenuItem jmi8=new JMenuItem("撤销(U)");JMenuItem jmi9=new JMenuItem("剪切(T)");
		JMenuItem jmi10=new JMenuItem("复制(C)");JMenuItem jmi11=new JMenuItem("粘贴(P)");
		JMenuItem jmi12=new JMenuItem("删除(L)");JMenuItem jmi13=new JMenuItem("查找(F)...");
		JMenuItem jmi14=new JMenuItem("查找下一个(N)");JMenuItem jmi15=new JMenuItem("替换(R)...");
		JMenuItem jmi16=new JMenuItem("转到(G)...");JMenuItem jmi17=new JMenuItem("全选(A)");
		JMenuItem jmi18=new JMenuItem("时间/日期(D)");
		JMenu jm3=new JMenu("格式(O)");
		JMenuItem jmi19=new JMenuItem("自动换行(W)");
		JMenuItem jmi20=new JMenuItem("字体");
		JMenu jm4=new JMenu("查看(V)");
		JMenuItem jmi21=new JMenuItem("状态栏(S)");
		JMenu jm5=new JMenu("帮助(H)");
		JMenuItem jmi22=new JMenuItem("查看帮助(H)");
		JMenuItem jmi23=new JMenuItem("关于记事本(A)");
	
		JTextArea jta=new JTextArea();
	
	//@Override
	File selectFile;
	public void actionPerformed(ActionEvent e){
		String a=null;
		if(jmi1==e.getSource()){//新建功能
			this.setTitle("无标题 - 记事本");
			jta.setText("");
			selectFile=null;
		}else if(jmi2==e.getSource()){//打开.txt文件功能
			JFileChooser jf=new JFileChooser();
			jf.showOpenDialog(this);
			selectFile=jf.getSelectedFile();
			try{
				//开始读取文件，按selectFile地址读文件
				FileReader f=new FileReader(selectFile);
				//设置好一个缓存读取方式，这样可以优化读取速度
				BufferedReader br=new BufferedReader(f);
				String txt="";
				String line=null;
				while((line=br.readLine())!=null){
					txt+=line+"\n";
				}
				br.close();
				this.setTitle(selectFile.getName()+"-记事本");
				jta.setText(txt);
			}
			catch(Exception e1){
				
			}	
		}else if(jmi3==e.getSource()){//保存功能
			
			if(selectFile==null){//没有打开过文件
				
				JFileChooser jf=new JFileChooser();
				jf.showSaveDialog(this);
				selectFile=jf.getSelectedFile();
				this.setTitle(selectFile.getName()+"- 记事本");
				}
			//有打开过以前的文件，就按照以前的文件路径保存
				try{
					FileWriter f=new FileWriter(selectFile);
					f.write(jta.getText());
					f.close();
				}catch(Exception e2){
					
				}
		}else if(jmi4==e.getSource()){//另存为功能
			JFileChooser jf=new JFileChooser();
			jf.showSaveDialog(this);
			selectFile=jf.getSelectedFile();
			this.setTitle(selectFile.getName()+"- 记事本");
			try{
				FileWriter f=new FileWriter(selectFile);
				f.write(jta.getText());
				f.close();
			}catch(Exception e2){
				
			}
		}else if(jmi5==e.getSource()){//退出功能
				if(selectFile==null){//没有打开过文件
				
				JFileChooser jf=new JFileChooser();
				jf.showSaveDialog(this);
				selectFile=jf.getSelectedFile();
				this.setTitle(selectFile.getName()+"- 记事本");
				}
			//有打开过以前的文件，就按照以前的文件路径保存
				try{
					FileWriter f=new FileWriter(selectFile);
					f.write(jta.getText());
					f.close();
				}catch(Exception e2){
					
				}
			System.exit(0);
		}
		else if(jmi6==e.getSource()){
			JOptionPane.showMessageDialog(null, "页面布局功能尚未实现，对不起！");
		}
		else if(jmi7==e.getSource()){
			JOptionPane.showMessageDialog(null, "打印功能尚未实现，对不起！");
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
		this.setTitle("新建文本文档 - 记事本");
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
		this.setIconImage(Toolkit.getDefaultToolkit().createImage("image//记事本LOGO.png"));
		this.setVisible(true);
	}
	public static void main(String[] args){
		new jishi();
	}
}
