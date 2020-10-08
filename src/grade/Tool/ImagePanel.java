/**
 * ���ܣ����Զ�̬����һ��ͼƬ��������JPanel
 */
package grade.Tool;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
public class ImagePanel extends JPanel{
	
	Image im;
	//���캯��ȥ��̬���ظ�Panel��С
	public ImagePanel(Image im)
	{	
		this.im=im;
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w, h);
	}
	//��������
	public void paintComponent(Graphics g)
	{
		//����
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(),this);
	}
}
