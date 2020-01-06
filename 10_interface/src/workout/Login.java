package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
 /*
 ����.
 1. ��� ��ư ������ JTextField(idT, pwdT)�� ���� �ʱ�ȭ
 
 2. LoginResult(�α��ι�ư) �α��� ���� / �α��� ���� â �߰��� , X��ư ������ �ٽ� ���� â����
 - LoginResult.java�� ����
 - LoginResult.java���� ���̵�� ��й�ȣ ��(id: "angel", pwd: "1004")�� ������ ����, �ƴϸ� ����
 - LoginResult ���� �����ư�� ������ �ٽ� �α��� â���� ������� 
 */

public class Login extends JFrame implements WindowListener, ActionListener{ //Swing�� x��ư - ���μ��� ������� ���� (������)
	private JLabel idL, pwdL;
	private JTextField idT, pwdT;
	private JButton loginB, cancelB;
	
	public Login() {
		this.setLayout(null); //border���̾ƿ�(��������)�� ������ - ������ǥ �Է��ؾ���
				
		idL = new JLabel("���̵�");
		pwdL = new JLabel("��й�ȣ");
		
		idT = new JTextField();
		pwdT = new JTextField();
		
		loginB = new JButton("�α���");
		cancelB = new JButton("���");
		
//		idL.setLocation(50, 80);
//		idL.setSize(50,30); //50,80 ��ġ��  50,30 ũ���� �ڽ��� �����
		idL.setBounds(50, 80, 50, 30);
		idT.setBounds(120, 80, 100, 30);
		
		pwdL.setBounds(50, 130, 70, 30);
		pwdT.setBounds(120, 130, 100, 30);
		
		loginB.setBounds(60, 200, 80, 30);
		cancelB.setBounds(160, 200, 80, 30);
		
		Container c = this.getContentPane();
		c.add(idL);
		c.add(idT);
		c.add(pwdL);
		c.add(pwdT);
		c.add(loginB);
		c.add(cancelB);
		
		setBounds(900,100,300,300);
		setVisible(true);
		
		//events
		this.addWindowListener(this);
		loginB.addActionListener(this);
		cancelB.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

	
	//action listener override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelB) {
			idT.setText("");
			pwdT.setText("");
		}
	}
	
	
	// window listener overrides
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
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
