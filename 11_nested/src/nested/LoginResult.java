package nested;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginResult extends JFrame {
	
	public LoginResult() {
		this.setLayout(null);
		
		setBounds(900, 200, 300, 300);
		setVisible(true);

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		LoginResult loginResult = new LoginResult();
		
	}
}
