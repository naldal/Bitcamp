package thread;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Packman extends Frame implements KeyListener, Runnable{

	private Image packman;
	private Image food;
	private int sel=2;
	private int x=225, y=225;
	private int mx, my;
	private int foodx, foody;
	
	public Packman() {
		packman = Toolkit.getDefaultToolkit().getImage("packman.jpg");
		food = Toolkit.getDefaultToolkit().getImage("food.jpg");
		
		setBounds(110, 700, 500, 500);
		setVisible(true);
		setResizable(false);
		
		//먹이 (20,50) (480,480) 사이에 뿌린다, 먹이의 크기는 20,20
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		
		
		addKeyListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(packman, x, y, x+50, y+50,//화면위치
					sel*50, 0 , sel*50+50, 50,
					this);
		g.drawImage(food, foodx, foody, foodx, foody, 24, 24, 48, 48, this);
		
	}
	
	// runnable
	@Override
	public void run() {
		foodx = (int)(Math.random()*300)+20;
		foody = (int)(Math.random()*300)+50;
		
		while(true) {
			if(sel%2==0) sel++;
			else sel--; 
				
			x+=mx;
			y+=my;
			if(x>500) x=0;
			else if(x<0) x=500;
			if(y>500) y=0;
			else if(y<0) y=500;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		
		
	}
	
	//key
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			sel=0;
			mx=-10; my=0;
		} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			sel=2;
			mx=+10; my=0;
		} else if (e.getKeyCode()==KeyEvent.VK_UP) {
			sel=4;
			mx=0; my=-10;
		} else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			sel=6;
			mx=0; my=10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
		new Packman();
	}
}
