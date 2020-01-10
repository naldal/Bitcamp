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
	private int foody1, foodx2, foody2, foodx3, foody3, foodx4, foody4, foodx5, foody5;
	public int[] xValue = new int[5];
	public int[] yValue = new int[5];
	
	public Packman() {
		packman = Toolkit.getDefaultToolkit().getImage("packman.jpg");
		food = Toolkit.getDefaultToolkit().getImage("food.png");
		
		setBounds(700, 200, 500, 500);
		setVisible(true);
		setResizable(true);
		
		//���� (20,50) (480,480) ���̿� �Ѹ���, ������ ũ��� 20,20
		
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
		g.drawImage(packman, x, y, x+50, y+50,
					sel*50, 0 , sel*50+50, 50,	
					this);
		
		g.drawImage(food, xValue[0], yValue[0], this);
		g.drawImage(food, xValue[1], yValue[1], this);
		g.drawImage(food, xValue[2], yValue[2], this);
		g.drawImage(food, xValue[3], yValue[3], this);
		g.drawImage(food, xValue[4], yValue[4], this);
		
	}
	
	// runnable
	@Override
	public void run() {
		for(int i=0; i<xValue.length; i++) {
			xValue[i]=(int)(Math.random()*461)+20;
			yValue[i]=(int)(Math.random()*431)+50;
		}

		while(true) {
			if(sel%2==0) sel++;
			else sel--;             
				
			x+=mx;					
			y+=my;					
			
			if(x>500) {x=0;}
			else if(x<0) {x=500;}
			if(y>500) {y=0;}
			else if(y<0) {y=500;}
			
			try {
				if( x+25>=xValue[0]-24 && y+25>=yValue[0]-24 && x+25<=xValue[0]+24 && y+25<=yValue[0]+24) {
					xValue[0] = -1;
					yValue[0] = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=xValue[1]-24 && y+25>=yValue[1]-24 && x+25<=xValue[1]+24 && y+25<=yValue[1]+24) {
					xValue[1] = -1;
					yValue[1] = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=xValue[2]-24 && y+25>=yValue[2]-24 && x+25<=xValue[2]+24 && y+25<=yValue[2]+24) {
					xValue[2] = -1;
					yValue[2] = -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=xValue[3]-24 && y+25>=yValue[3]-24 && x+25<=xValue[3]+24 && y+25<=yValue[3]+24) {
					xValue[3] = -1;
					yValue[3]= -1;
					System.out.println((x+25)+" "+(y+25));
				} else if (x+25>=xValue[4]-24 && y+25>=yValue[4]-24 && x+25<=xValue[4]+24 && y+25<=yValue[4]+24) {
					xValue[4] = -1;
					yValue[4] = -1;
					System.out.println((x+25)+" "+(y+25));
				} 
				
				if(xValue[0]==-1 && xValue[1]==-1 && xValue[2]==-1 && xValue[3]==-1 && xValue[4]==-1) {
					break;
				}
				Thread.sleep(10);
				
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
