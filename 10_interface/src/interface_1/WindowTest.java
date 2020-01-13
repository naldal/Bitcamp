package interface_1;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowTest extends Frame implements MouseListener, MouseMotionListener{

	public WindowTest() {
		setTitle("내가 만든 윈도우");
		this.setBounds(900,200,300,400);
		setVisible(true);
		
		//이벤트 처리
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		
	}
	
	public static void main(String[] args) {
		new WindowTest();
	} //main

	
	//Mouse Listener Override - Event Handler
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
		System.out.println("X :"+e.getX()+"\t Y:"+e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 OUT");
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
		System.out.println("마우스 드래그");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("마우스 Moves");
	}
}
