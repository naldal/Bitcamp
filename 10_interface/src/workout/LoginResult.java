package workout;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginResult extends JFrame {
	public static final String LOGINID="angel";
	public static final String LOGINPWD="1004";
	
	private JLabel result;
	public LoginResult(String id, String pwd) {
		this.setLayout(null);
		
		if(id.equals(LOGINID) && pwd.equals(LOGINPWD))
			result = new JLabel("로그인 성공");
		else 
			result = new JLabel("로그인 실패");
		result.setBounds(100, 80, 80, 30);
		
		setBounds(900, 200, 300, 300);
		setVisible(true);
		
		Container c = this.getContentPane();
		c.add(result);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
