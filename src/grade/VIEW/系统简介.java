package grade.VIEW;
import java.awt.*;
import javax.swing.*;
import grade.Tool.*;
public class ϵͳ��� extends JFrame {
	
	 public static void main(String[] args){
	 
		new ϵͳ���();
	}
	
	public ϵͳ���(){
		//����ͼ��ķ�ʽ����
		//��ʽһ��
		//Image img=new ImageIcon("image\\title.jpg").getImage();
		//jf.setIconImage(img);
		//��ʽ��
		//Image img1=new ImageIcon("image/title.jpg").getImage();
		//jf.setIconImage(img1);
		//��ʽ��
		//jf.setIconImage(Toolkit.getDefaultToolkit().getImage("image/title.jpg"));
		//��ʽ��
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\title.jpg"));
		this.setTitle("ϵͳ���");
		this.setSize(500,400);
		this.setLocation(500,200);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.Initneirong();
		this.setVisible(true);
		this.setResizable(false);
	}
	public void Initneirong(){
		//�ı�������ϵͳ�Ĺ���
		JTextArea jta=new JTextArea(10,10);
		jta.setText("        ѧ����Ϣ����ϵͳ����ѧУ�Ĺ�������˵�Ƿǳ���Ҫ��Ҳ��Ϊ����Ӧ�ִ���ѧУ�������Ҫ,�ӿ��ƽ�ѧУ���ֻ�����,������Ч������У԰���Ͷ�ý���"
				+ "�����Ӧ�ü������ֶΡ�ѧ����Ϣ����ϵͳ "+"�� ѧ����Ϣ����ϵͳ ��"+"ժ Ҫ��Ŀǰ��ѧУ��ģ���󣬹������ӡ������ڶ࣬����һ���ʺϴ��ڵġ������Ժõ�"+
				"ϵͳ�Ǻ��б�Ҫ�ġ�ѧ����Ϣ����ϵͳ����ѧУ�Ĺ�������˵������Ҫ��ѧ����Ϣ��ѧУ�ǳ���Ҫ��һ��������Դ��������������������漰����Ա��㣬������Ҫ��ʱ����"+
				"��ͳ���˹�����ʽ�Ȳ����ڹ淶��������Ч��Ҳ���ߣ��������ü����ʵ�ֶ�ѧ����Ϣ�����Ϊ��Ȼ�����ơ�����SIMS�������Լ����Ͷ�����ʹ�ã�����Ҳ�ӿ��˲�ѯ�ٶ�"+
				"��ǿ�˹����俪����Ҫ������̨���ݿ�Ľ�����ά���Լ�ǰ��Ӧ�ó���Ŀ����������档����ǰ��ʹ��SQL����������һ���Ժ�������ǿ�����ݰ�ȫ�Ժã�ʹ��ӵ�нϴ��������"+
				"���Ϳ��ٵ����л��ơ������ں���ʹ��JSP��Ϊ��������Ҫ��Ӧ�ó��������û�Ȩ�޹��������Ϣ¼�롢��Ϣ��ѯ����Ϣ�޸ġ���Ϣɾ���ȹ��ܡ�����ϵͳ��Tomcat5.5������������"+
				"��Բ�ͬ���û���ɲ�ͬ�Ĺ��ܡ�");
		jta.setFont(tool.f2);
		jta.setForeground(Color.BLACK);
		jta.setLineWrap(true);
		JScrollPane js=new JScrollPane(jta);
		this.add(js);
	}
}
