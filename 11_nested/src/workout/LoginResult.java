package workout;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginResult extends JFrame {
	public static final String id="angel";
	public static final String pwd="1004";
	
	private JLabel result;
	public LoginResult(String id, String pwd) {
		this.setLayout(null);
		
//		if(id.equals(LOGINID) && pwd.equals(LOGINPWD))
//			result = new JLabel("로그인 성공");20
//		else 
//			result = new JLabel("로그인 실패");
//		result.setBounds(100, 80, 80, 30);
//	
		
		setBounds(900, 200, 300, 300);
		setVisible(true);
		setResizable(false);
		
//		Container c = this.getContentPane();
//		c.add(result);
//		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	

	@Override
	public void paint(Graphics g) {
		if(id.equals("angel") && pwd.equals("1004")) {
			JOptionPane.showMessageDialog(this, "로그인 성공");
		} else {
			JOptionPane.showMessageDialog(this, "로그인 실패");
		}
			
			
	}
}
