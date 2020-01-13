package interface_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame�� BorderLayout �������� ���� �����ִ�
public class WindowTest2 extends Frame implements WindowListener, ActionListener{

	private Button newB, exitB;
	private TextArea area;
	
	public void init() {
		newB = new Button("���θ����");
		exitB = new Button("������");
		area = new TextArea();
		
		Panel p = new Panel();	//FlowLayout(����� �߽����� ������� ��ġ��)
		p.setBackground(new Color(255,200,200));
		newB.setBackground(new Color(200,200,240));
		
		p.add("North", newB);
		p.add("North", exitB); //�ϳ��ۿ� ���ö�
		
		this.add("North", p);
		add("Center", area);
		
		this.setBounds(900,200,300,400);
		setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(this);
		newB.addActionListener(this);
		exitB.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new WindowTest2().init();
	}
	

	
	// ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newB) {
			area.setText(" ");
			area.setText(""); //�ʱ�ȭ
		} else if(e.getSource()==exitB) {
			System.exit(0);
		}
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
