package workout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

//Frame - BorderLayout
public class ImageMove extends Frame implements WindowListener, ActionListener {
	/**
	 * <font style="color : red;"> ����, ������, ��, �Ʒ��� �̵���Ű�� ��ư�̴�.</font>
	 */
	public Button newB, westB, northB, eastB, southB;

	/**
	 * ��ǥ �ʱⰪ�� ����ִ� �ʵ��̴�.
	 */
	public int imgX = 100, imgY = 100;

	Toolkit t = Toolkit.getDefaultToolkit();
	Image img = t.getImage("img.jpg");

	/**
	 * <font style ="color : blue">����ȭ���� �ٸ��ִ� �޼ҵ�</font>
	 */
	public void init() {
		// ȭ�� ũ������
		setBounds(900, 200, 500, 500);
		setVisible(true);
		setTitle("�̹��� �̵�");

		// ��ư ����
		newB = new Button("�ʱ�ȭ");
		westB = new Button("����");
		northB = new Button("��");
		southB = new Button("�Ʒ�");
		eastB = new Button("������");

		Panel p = new Panel();// FlowLayout(������ġ-�߾�)
		p.setLayout(new GridLayout(1, 5)); // 1�� 5��
		p.add("North", newB);
		p.add("North", westB);
		p.add("North", northB);
		p.add("North", southB);
		p.add("North", eastB);

		this.add("North", p);

		// �̺�Ʈ ó��
		this.addWindowListener(this);
		newB.addActionListener(this);
		westB.addActionListener(this);
		northB.addActionListener(this);
		southB.addActionListener(this);
		eastB.addActionListener(this);

	}

	public static void main(String[] args) {
		new ImageMove().init();
	}

	// Toolkit
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, imgX, imgY, this);
		if (imgX > 400) {
			g.drawImage(img, imgX - 500, imgY, this);
		}
		if (imgX < 0) {
			g.drawImage(img, 500 + imgX, imgY, this);
		}
		if (imgY > 400) {
			g.drawImage(img, imgX, imgY - 440, this);
		}
		if (imgY < 60) {
			g.drawImage(img, imgX, 440 + imgY, this);
		}
	}

	// Action Listener
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newB) {
			imgX = 100;
			imgY = 100;
		} else if (e.getSource() == westB) {
			if (imgX < 10) {
				imgX += 300;
			} else if (imgX >= 10) {
				imgX -= 30;
			}
		} else if (e.getSource() == northB) {
			if (imgY < 10) {
				imgY += 300;
			} else if (imgY >= 10) {
				imgY -= 30;
			}
		} else if (e.getSource() == southB) {
			if (imgY < 400) { // ����� ������ �������� �ʾ�����
				imgY = this.imgY + 30;
			} else if (imgY >= 300) {
				imgY = imgY - 450;
			}
		} else if (e.getSource() == eastB) {
			if (imgX > 300) {
				imgX -= 300;
			} else if (imgX <= 300) {
				imgX += 30;
			}
		}
		repaint();

	}

	// Window listener
	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}
