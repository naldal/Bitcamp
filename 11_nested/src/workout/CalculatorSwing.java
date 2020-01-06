package workout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorSwing extends JFrame{
	JPanel label1, label2;
	JButton[] jbutton = null;
	String[] buttonStr = {"¡ç", "C", "+", "-", "*", "/",
			".", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	public CalculatorSwing() {
		super("°è»ê±â");
		
		getContentPane().setLayout(getLayout());
		label1 = new JPanel(new GridLayout(2,1));
		
		
		
		
		
		setBounds(900, 200, 400, 700);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) {
		new CalculatorSwing();
	}
}
