package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Clock extends Frame implements Runnable{
	
	public Clock() {
		this.setFont(new Font("����ü", Font.BOLD, 30));
		setForeground(Color.RED);
		
		setBounds(900, 200, 300, 100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//thread ����
		Thread t = new Thread(this);
		//thread ����
		t.start();
	}
	
	@Override
	public void paint(Graphics g) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH�� mm�� ss��");
		Date date = new Date();
		g.drawString(sdf.format(date), 40, 70);
	}
	
	@Override
	public void run() /*throws InterruptedException*/ { //�������̵� �� �޼ҵ�� ������ �����ϰ�� ��� (throws ����) ���ƾ� �Ѵ�.
		while(true) {
			repaint();
			try {
				Thread.sleep(1000); // 1000�и������� = 1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Clock();
	}

}
