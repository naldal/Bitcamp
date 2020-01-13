package thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import workout.RunRace;

@SuppressWarnings("serial")
public class Racer extends Canvas implements Runnable{ 
	
	private Image horse;
	private int pos;
	
	public Racer() {
		horse = Toolkit.getDefaultToolkit().getImage("horse.gif");
		setBackground(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)Math.random()*256));
		
//		Thread t = new Thread(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		g.drawImage(horse, pos, 0, 100, this.getHeight(), this); //x, y, width, height
	}

	@Override
	public void run() {
	
		for(int i=0; i<600; i+=(int)(Math.random()*10+1)) {
			pos = i;
			repaint();
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(RunRace.cnt+"�� ���� :"+Thread.currentThread().getName());
		RunRace.cnt++;
	}
}
