package workout;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{ //Swing�� x��ư - ���μ��� ������� ���� (������)
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		loginB.addActionListener(this);
		cancelB.addActionListener(this);
	}
	
	//action listener override
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelB) {
			idT.setText("");
			pwdT.setText("");
		}
		
		if(e.getSource()==loginB) {
			if(idT.getText()=="angel") {
				LoginResult lr = new LoginResult();
			}
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}
