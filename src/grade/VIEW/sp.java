/**
 * �û���¼������Ч��
 */
package grade.VIEW;//����
import javax.swing.*;//����javax.swing�е�������
import java.awt.*;//����java.awt�е�������

//��������sp�̳���Jwindow�ಢʵ����Runnable�ӿ�
public class sp extends JWindow implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����paint���󣬸�paint�����ڵ���İ���
	paint p;
	//������
	public static void main(String []args){
		//����sp��Ķ���
		sp s=new sp ();
		//�����̶߳������Ϊsp��Ķ���
		Thread t=new Thread(s);
		//�̶߳�����÷���
		t.start();
	  }

	//@Override
	//���Ǹ���ķ���
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//���ݼ������ǵȴ�����Ч������������ת���û���¼����
			try {
				//����ֱ�ӵ��÷���
				Thread.sleep(31*330);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ת����¼����
			System.out.println("����Ч������");
			new LOGIN();//����һ��LOGIN����
			this.dispose();//�رյ�ǰ����
			break;//��ֹ
		}
	}
	
	//����һ�������࣬����sp��Ĺ��췽��
	public sp()
	{
		//����p;
		p=new paint();
		this.add(p);
		this.setSize(400,250);
		//ȷ��JWindow�ĳ�ʼλ��
		//int width=Toolkit.getDefaultToolkit().getScreenSize().width/2;
		//int height=Toolkit.getDefaultToolkit().getScreenSize().height/2;
		int width=450;
		int height=200;
		this.setLocation(width,height);
		//this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}
		
}
//����һ��������
class paint extends JPanel implements Runnable
{
	
	private static final long serialVersionUID = 1L;

	Thread t;
	int x = 10, i = 0, j = 40, u = 10;
	int width = 180, height = 0, dian = 0,k = 0, tt = 0;
	String[] gg = { "ϵ", "ͳ", "��", "��", "��", "��", "��", "��", "��" }, 
			shi = { "Ȱ","ѧ", "ʫ", 
			"��", "��", "��", "��", "��", "��", "��", 
			"��", "��", "��", "��","��", "��", "ʱ",
			"��", "��", "��", "֪", "��", "ѧ", "��",
			"��", "��", "��","��", "��", "��","��" };
	Font f = new Font("����", Font.BOLD,22);

	boolean ifok = true;
	
	//���캯��
	paint()
		{
			t=new Thread(this);
			t.start();
		}
	@Override
	public void run() {
		while (true) {
			if (x <= 380)
				repaint();
			try {
				Thread.sleep(70);
				i++;
				j = j - 6;
				u = u + 10;

				if (tt == 3)
					width = width - 20;

				if (i == 4) {
					tt++;
					if (ifok && x > 120 + k * 20)
						k++;
					if (k >= gg.length - 1)
						ifok = false;
					x = x + 10;
					i = 0;
					j = 40;
					u = 10;
					dian++;
					if (dian > 3)
						dian = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("�߳��ж�");
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("image/back.jpg");
		g.drawImage(image, 0, 0, this.getWidth(), 200, this);
		int r = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		int y = (int) (Math.random() * 255);
		g.setColor(new Color(253, 250, 250));
		g.fillRect(x, 210, 390 - x, 30);
		g.setColor(new Color(253, 250, 250));
		if (i > 1)
			g.fillRect(x, 225 - (j + 20) / 2, 10, j + 20);
		if (j > 28)
			g.setColor(new Color(r, b, y));
		else
			g.setColor(new Color(123, 194, 252));
		g.fillRect(x, 225 - j / 2, 10, j);
		g.setColor(new Color(123, 194, 252));
		g.drawRect(10, 210, 380, 30);

		if (x < 120) {
			for (int l = 0; l < gg.length; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString(gg[l], 120 + l * 20, 230);
			}
			for (int l = 0; l < dian; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString("*", 300 + l * 10, 235);
			}
			g.drawString("*", 300 + 10 * dian, 235);
		} else {
			g.setColor(new Color(23, 23, 230));
			g.drawString(gg[k], 120 + k * 20, 230);
			for (int l = k + 1; l < gg.length; l++) {
				g.setColor(new Color(0, 0, 0));
				g.drawString(gg[l], 120 + l * 20, 230);
			}
			if (x > 300 + dian * 10)
				g.setColor(new Color(23, 23, 230));
			for (int l = 0; l < dian; l++) {
				g.drawString("*", 300 + l * 10, 235);
			}
			g.drawString("*", 300 + 10 * dian, 235);
		}

		// ---------------------------����дʫ

		if (tt < 3) {
			for (int rr = 0; rr <= tt; rr++) {
				g.setColor(new Color(r, b, y));
				g.drawString(shi[rr], 180, 60 + rr * 20);
			}
			g.drawString(shi[tt], 180, 60 + tt * 20);
		}

		if (tt >= 3&& tt < 9) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 3; rr++)
				g.drawString(shi[rr], 180, 60 + rr * 20);
			g.setColor(new Color(r, b, y));
			if (tt <10)
				for (int rr = 3; rr <= tt; rr++)
					g.drawString(shi[rr], 150, rr * 20 - 20);
			if (tt >=9) {
				for (int rr = 3; rr <=10; rr++)
					g.drawString(shi[rr], 150, rr * 20 - 20);
			}
		}

		if (tt >= 9 && tt < 17) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 3; rr++)
				g.drawString(shi[rr], 180, 60 + rr * 20);
			for (int rr = 3; rr <= 9; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 20);
			g.setColor(new Color(r, b, y));
			if (tt <18)
				for (int rr = 10; rr <=tt; rr++)
					g.drawString(shi[rr], 120, rr * 20 - 160);
			if (tt >=17)
				for (int rr = 10; rr <17; rr++)
					g.drawString(shi[rr], 120, rr * 20 - 160);
		}

		if (tt >= 17 && tt < 24) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 3; rr++)
				g.drawString(shi[rr], 180, 60 + rr * 20);
			for (int rr = 3; rr <= 9; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 20);
			for (int rr = 10; rr <17; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 160);
			g.setColor(new Color(r, b, y));
			if (tt <25)
				for (int rr = 17; rr <= tt; rr++)
					g.drawString(shi[rr], 90, rr * 20 - 300);
			if (tt >= 24)
				for (int rr = 17; rr < 24; rr++)
					g.drawString(shi[rr], 90, rr * 20 - 300);
		}

		if (tt >= 24 && tt < 31) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 3; rr++)
				g.drawString(shi[rr], 180, 60 + rr * 20);
			for (int rr = 3; rr <= 9; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 20);
			for (int rr = 10; rr < 17; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 160);
			for (int rr = 17; rr < 24; rr++)
				g.drawString(shi[rr], 90, rr * 20 - 300);
			g.setColor(new Color(r, b, y));
			if (tt < 32)
				for (int rr = 24; rr <= tt; rr++)
					g.drawString(shi[rr], 60, rr * 20 - 440);
			if (tt >=31)
				for (int rr = 24; rr < 31; rr++)
					g.drawString(shi[rr], 60, rr * 20 - 440);
		}

		if (tt >= 31) {
			g.setColor(new Color(230, 0, 0));
			for (int rr = 0; rr < 3; rr++)
				g.drawString(shi[rr], 180, 60 + rr * 20);
			for (int rr = 3; rr <= 9; rr++)
				g.drawString(shi[rr], 150, rr * 20 - 20);
			for (int rr = 10; rr < 17; rr++)
				g.drawString(shi[rr], 120, rr * 20 - 160);
			for (int rr = 17; rr < 24; rr++)
				g.drawString(shi[rr], 90, rr * 20 - 300);
			for (int rr = 24; rr < 31; rr++)
				g.drawString(shi[rr], 60, rr * 20 - 440);
		}
	}
}