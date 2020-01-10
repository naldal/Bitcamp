package inheritance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // WindowTest is a Frame

	public WindowTest() {
		super("제목");

		// setBackground(Color.BLACK);
		setBackground(new Color(155, 78, 55));
		setForeground(Color.yellow);

		// this.setSize(300, 400);
		this.setBounds(700, 300, 300, 400);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) { // Call back 콜백 메소드.(특정 시점이 되면 JVM에 의해서 호출되는 메소드) 프레임창이 만들어지는 시점(setVisible)에
									// 호출됨
		g.drawLine(100, 200, 300, 400); // 한번만 호출됨. 단 repaint()하면 다시 호출됨
		g.drawLine(300, 200, 100, 400);
		g.drawRect(100, 60, 150, 150);
		g.drawOval(80, 130, 180, 180);
	}

	public static void main(String[] args) {
		new WindowTest();

	}
}
