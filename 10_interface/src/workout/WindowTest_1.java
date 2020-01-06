package workout;

import java.awt.Color; 
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame; //확장패키지

public class WindowTest_1 extends JFrame implements MouseListener, MouseMotionListener{
	
	int strX;
	int strY;
	
	public WindowTest_1() {
		setTitle("내가 만든 윈도우");
		
		this.setBounds(900,200,300,400);
		setVisible(true);
		
		setBackground(new Color(200,240,200));
		setForeground(Color.black);
		
		//이벤트 처리
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawString(strX+" "+strY, strX, strY);
	}
	
	public static void main(String[] args) {
		new WindowTest_1();
		
	} //main

	
	//Mouse Listener Override - Event Handler
	@Override
	public void mouseClicked(MouseEvent e) {
		strX = e.getX();
		strY = e.getY();
		
		repaint(); //update() 를 찾음. 그런데 update()없어서 paint()로 넘어감
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	
	//MouseMotionListener Override - Event Handler
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
}
