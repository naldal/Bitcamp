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
	private int foodx1, foody1, foodx2, foody2, foodx3, foody3, foodx4, foody4, foodx5, foody5;
	private int packx1, packx2, packy1;
	
	public Packman() {
		packman = Toolkit.getDefaultToolkit().getImage("packman.jpg");
		food = Toolkit.getDefaultToolkit().getImage("food.png");
		
		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(true);
		
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
		g.drawImage(packman, x, y, x+50, y+50,	//화면위치
					sel*50, 0 , sel*50+50, 50,	//펙멘모습 상하좌우
					this);
		
		g.drawImage(food, foodx1, foody1, this);
		g.drawImage(food, foodx2, foody2, this);
		g.drawImage(food, foodx3, foody3, this);
		g.drawImage(food, foodx4, foody4, this);
		g.drawImage(food, foodx5, foody5, this);
		
	}
	
	// runnable
	@Override
	public void run() {
		foodx1 = (int)(Math.random()*461)+20;
		foody1 = (int)(Math.random()*431)+50;
		foodx2 = (int)(Math.random()*461)+20;
		foody2 = (int)(Math.random()*431)+50;
		foodx3 = (int)(Math.random()*461)+20;
		foody3 = (int)(Math.random()*431)+50;
		foodx4 = (int)(Math.random()*461)+20;
		foody4 = (int)(Math.random()*431)+50;
		foodx5 = (int)(Math.random()*461)+20;
		foody5 = (int)(Math.random()*431)+50;

		while(true) {
			if(sel%2==0) sel++;
			else sel--;             //입깜빡이
				
			x+=mx;					
			y+=my;					//방향키에 따른 위치이동
			
			if(x>500) {				//테두리 넘어가면 순간이동처리
				x=0;
			} else if(x<0) {
				x=500;
			}
			
			if(y>500) {
				y=0;
			} else if(y<0) {
				y=500;
			}
			
			try {
				if( x+25>=foodx1-24 && y+25>=foody1-24 && x+25<=foodx1+24 && y+25<=foody1+24) {
					foodx1 = -1;
					foody1 = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=foodx2-24 && y+25>=foody2-24 && x+25<=foodx2+24 && y+25<=foody2+24) {
					foodx2 = -1;
					foody2 = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=foodx3-24 && y+25>=foody3-24 && x+25<=foodx3+24 && y+25<=foody3+24) {
					foodx3 = -1;
					foody3 = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=foodx4-24 && y+25>=foody4-24 && x+25<=foodx4+24 && y+25<=foody4+24) {
					foodx4 = -1;
					foody4 = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=foodx5-24 && y+25>=foody5-24 && x+25<=foodx5+24 && y+25<=foody5+24) {
					foodx5 = -1;
					foody5 = -1;
					System.out.println((x+25)+" "+(y+25));
				} 
				Thread.sleep(50);
				
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
