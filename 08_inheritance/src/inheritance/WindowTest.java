package inheritance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { // WindowTest is a Frame

	public WindowTest() {
		super("����");

		// setBackground(Color.BLACK);
		setBackground(new Color(155, 78, 55));
		setForeground(Color.yellow);

		// this.setSize(300, 400);
		this.setBounds(700, 300, 300, 400);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) { // Call back �ݹ� �޼ҵ�.(Ư�� ������ �Ǹ� JVM�� ���ؼ� ȣ��Ǵ� �޼ҵ�) ������â�� ��������� ����(setVisible)��
									// ȣ���
		g.drawLine(100, 200, 300, 400); // �ѹ��� ȣ���. �� repaint()�ϸ� �ٽ� ȣ���
		g.drawLine(300, 200, 100, 400);
		g.drawRect(100, 60, 150, 150);
		g.drawOval(80, 130, 180, 180);
	}

	public static void main(String[] args) {
		new WindowTest();

	}
}
