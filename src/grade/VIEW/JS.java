package grade.VIEW;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
public class JS extends JFrame implements ActionListener {
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12,jb13,jb14,jb15,jb16;
	JTextArea jt1;
	public static void main(String[] args){
		new JS();
	}
	int i=0;
	String A[]=new String[10];
	int j=0;
	int op;
	int a,b,C;
	int k=1;
	int p=0;
	int q=0;
	int m=1;
	int B[]=new int[10];
	int count=0;
	int n=0;
	public void actionPerformed(ActionEvent e){
		if(!(e.getSource()==jb15)){
			if(e.getSource()==jb1){
					jt1.append(jb1.getText());
					A[i]=jb1.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}else if(e.getSource()==jb2){
					jt1.append(jb2.getText());
					A[i]=jb2.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb3){
					jt1.append(jb3.getText());
					A[i]=jb3.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb4){
					jt1.append(jb4.getText());
					A[i]=jb4.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
			}
			else if(e.getSource()==jb5){
					jt1.append(jb5.getText());
					A[i]=jb5.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb6){
					jt1.append(jb6.getText());
					A[i]=jb6.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb7){
					jt1.append(jb7.getText());
					A[i]=jb7.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb8){
					jt1.append(jb8.getText());
					A[i]=jb8.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb9){
					jt1.append(jb9.getText());
					A[i]=jb9.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			else if(e.getSource()==jb10){
					jt1.append(jb10.getText());
					A[i]=jb10.getText();i++;
					for(;k==i;){B[j++]=Integer.valueOf(A[p++]);k++;}
					count++;
					n=1;
			}
			//ÔËËã·û
			else if(e.getSource()==jb11){
				jt1.append("+");
				op=1;
				if(count==1){	B[q++]=Integer.valueOf(A[0]);	count--;}
				if(count==2){	B[q++]=(Integer.valueOf(A[0]))*(q*10);	B[q++]=Integer.valueOf(A[1]);	count=count-2;}
				if(count==3){	
					B[q++]=(Integer.valueOf(A[0]))*(q*100);	
					B[q++]=Integer.valueOf(A[1])*10;	
					B[q++]=Integer.valueOf(A[1]);	
					count=count-3;
				}
			}
			else if(e.getSource()==jb12){
				jt1.append("-");
				op=2;
				if(count==1){	B[q++]=Integer.valueOf(A[0]);	count--;}
				if(count==2){	B[q++]=(Integer.valueOf(A[0]))*(q*10);	B[q++]=Integer.valueOf(A[1]);	count=count-2;}
				if(count==3){	
					B[q++]=(Integer.valueOf(A[0]))*(q*100);	
					B[q++]=Integer.valueOf(A[1])*10;	
					B[q++]=Integer.valueOf(A[1]);	
					count=count-3;
				}
			}
			else if(e.getSource()==jb13){
				jt1.append("*");
				op=3;
				if(count==1){	B[q++]=Integer.valueOf(A[0]);	count--;}
				if(count==2){	B[q++]=(Integer.valueOf(A[0]))*(q*10);	B[q++]=Integer.valueOf(A[1]);	count=count-2;}
				if(count==3){	
					B[q++]=(Integer.valueOf(A[0]))*(q*100);	
					B[q++]=Integer.valueOf(A[1])*10;	
					B[q++]=Integer.valueOf(A[1]);	
					count=count-3;
				}
			}
			else if(e.getSource()==jb14){
				jt1.append("/");
				op=4;
				if(count==1){	B[q++]=Integer.valueOf(A[0]);	count--;}
				if(count==2){	B[q++]=(Integer.valueOf(A[0]))*(q*10);	B[q++]=Integer.valueOf(A[1]);	count=count-2;}
				if(count==3){	
					B[q++]=(Integer.valueOf(A[0]))*(q*100);	
					B[q++]=Integer.valueOf(A[1])*10;	
					B[q++]=Integer.valueOf(A[1]);	
					count=count-3;
				}
			}
		}else{
			jt1.append("=");
			int G=0;
			switch(op){
					case 1: { 
						jt1.append(String.valueOf(B[G++]+B[G++]+B[G++]*10+B[G++])); 
						break;
					}
					case 2: { 
						jt1.append(String.valueOf(B[G++]+B[G++]-B[G++]*10-B[G++])); 
						break;
					}
					case 3: { 
						jt1.append(String.valueOf((B[G++]+B[G++])*(B[G++]*10+B[G++]))); 
						break;
					}
					case 4: {
						jt1.append(String.valueOf((double)((B[G++]+B[G++])/(B[G++]*10+B[G++])))); 
						break;
					}
			}
		}
	}
	
	public JS(){
		JFrame jf=new JFrame();
		jf.setResizable(false);
		jf.setTitle("¼ÆËãÆ÷");
		jf.setSize(300,200);
		jf.setLocation(300, 200);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img1=new ImageIcon("image/title.jpg").getImage();
		jf.setIconImage(img1);
		jf.setLayout(new BorderLayout());
		JPanel jp1,jp2;
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(1,1));
		jt1=new JTextArea(1,1);
		jt1.setBackground(Color.green);
		jp1.add(jt1);
		jp2=new JPanel();
		jp2.setLayout(new GridLayout(4,4));
		jb1=new JButton("1");	jb1.addActionListener(this);
		jb2=new JButton("2");	jb2.addActionListener(this);
		jb3=new JButton("3");	jb3.addActionListener(this);
		jb4=new JButton("4");	jb4.addActionListener(this);
		jb5=new JButton("5");	jb5.addActionListener(this);
		jb6=new JButton("6");	jb6.addActionListener(this);
		jb7=new JButton("7");	jb7.addActionListener(this);
		jb8=new JButton("8");	jb8.addActionListener(this);
		jb9=new JButton("9");	jb9.addActionListener(this);
		jb10=new JButton("0");	jb10.addActionListener(this);
		jb11=new JButton("+");	jb11.addActionListener(this);
		jb12=new JButton("-");	jb12.addActionListener(this);
		jb13=new JButton("*");	jb13.addActionListener(this);
		jb14=new JButton("/");	jb14.addActionListener(this);
		jb15=new JButton("=");	jb15.addActionListener(this);
		jb16=new JButton(".");	jb16.addActionListener(this);
		jp2.add(jb7);jp2.add(jb8);jp2.add(jb9);jp2.add(jb14);
		jp2.add(jb4);jp2.add(jb5);jp2.add(jb6);jp2.add(jb13);
		jp2.add(jb1);jp2.add(jb2);jp2.add(jb3);jp2.add(jb12);
		jp2.add(jb16);jp2.add(jb10);jp2.add(jb15);jp2.add(jb11);
		jf.add(jp1,BorderLayout.NORTH);
		jf.add(jp2,BorderLayout.CENTER);
		jf.setVisible(true);
	}
}