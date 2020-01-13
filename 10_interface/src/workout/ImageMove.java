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
	 * <font style="color : red;"> 왼쪽, 오른쪽, 위, 아래로 이동시키는 버튼이다.</font>
	 */
	public Button newB, westB, northB, eastB, southB;

	/**
	 * 좌표 초기값을 잡아주는 필드이다.
	 */
	public int imgX = 100, imgY = 100;

	Toolkit t = Toolkit.getDefaultToolkit();
	Image img = t.getImage("img.jpg");

	/**
	 * <font style ="color : blue">메인화면을 꾸며주는 메소드</font>
	 */
	public void init() {
		// 화면 크기조정
		setBounds(900, 200, 500, 500);
		setVisible(true);
		setTitle("이미지 이동");

		// 버튼 셋팅
		newB = new Button("초기화");
		westB = new Button("왼쪽");
		northB = new Button("위");
		southB = new Button("아래");
		eastB = new Button("오른쪽");

		Panel p = new Panel();// FlowLayout(순서배치-중앙)
		p.setLayout(new GridLayout(1, 5)); // 1행 5열
		p.add("North", newB);
		p.add("North", westB);
		p.add("North", northB);
		p.add("North", southB);
		p.add("North", eastB);

		this.add("North", p);

		// 이벤트 처리
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
			if (imgY < 400) { // 충분히 밑으로 내려가지 않았으면
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
