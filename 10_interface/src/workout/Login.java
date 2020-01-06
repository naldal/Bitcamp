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

public class Login extends JFrame implements ActionListener{ //Swing은 x버튼 - 프로세스 종료되지 않음 (히든임)
	private JLabel idL, pwdL;
	private JTextField idT, pwdT;
	private JButton loginB, cancelB;
	
	public Login() {
		this.setLayout(null); //border레이아웃(동서남북)을 깨버림 - 직접좌표 입력해야함
				
		idL = new JLabel("아이디");
		pwdL = new JLabel("비밀번호");
		
		idT = new JTextField();
		pwdT = new JTextField();
		
		loginB = new JButton("로그인");
		cancelB = new JButton("취소");
		
//		idL.setLocation(50, 80);
//		idL.setSize(50,30); //50,80 위치에  50,30 크기의 박스를 잡아줌
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
