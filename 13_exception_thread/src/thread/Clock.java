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
		this.setFont(new Font("돋움체", Font.BOLD, 30));
		setForeground(Color.RED);
		
		setBounds(900, 200, 300, 100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//thread 생성
		Thread t = new Thread(this);
		//thread 시작
		t.start();
	}
	
	@Override
	public void paint(Graphics g) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		Date date = new Date();
		g.drawString(sdf.format(date), 40, 70);
	}
	
	@Override
	public void run() /*throws InterruptedException*/ { //오버라이드 한 메소드는 구현부 제외하고는 모두 (throws 포함) 같아야 한다.
		while(true) {
			repaint();
			try {
				Thread.sleep(1000); // 1000밀리세컨드 = 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Clock();
	}

}
