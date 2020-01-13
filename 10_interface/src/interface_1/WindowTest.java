package interface_1;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowTest extends Frame implements MouseListener, MouseMotionListener{

	public WindowTest() {
		setTitle("���� ���� ������");
		this.setBounds(900,200,300,400);
		setVisible(true);
		
		//�̺�Ʈ ó��
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
		System.out.println("���콺 Ŭ��");
		System.out.println("X :"+e.getX()+"\t Y:"+e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 OUT");
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
		System.out.println("���콺 �巡��");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("���콺 Moves");
	}
}
