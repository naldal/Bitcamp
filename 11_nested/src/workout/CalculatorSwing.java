package workout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorSwing extends JFrame{
	
	JButton[] jbutton = null;
	String[] buttonStr = {"7", "8", "9", "/",
			"4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=", "+"};
	
	//요소
	JLabel label1, label2;
	
	JButton back;
	JButton clear;
	
	JTextField jp1;
	JTextField jp2;
	
	//패널
	JPanel buttonPanel;
	JPanel backAndClear;
	JPanel labelPanel;
	
	public CalculatorSwing() {
		super("계산기");	
		this.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		backAndClear = new JPanel();
		labelPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(4,4,5,5));
		backAndClear.setLayout(new GridLayout(1,2,5,30));
		labelPanel.setLayout(new GridLayout(2,1,5,5));
		
		jbutton = new JButton[16];	
		for(int i=0; i<jbutton.length; i++) {
			jbutton[i] = new JButton(buttonStr[i]);
			buttonPanel.add(jbutton[i]);
		}
		
		labelPanel.setBackground(new Color(255,255,255));
		
		back = new JButton("←");
		clear = new JButton("C");
		
		jp1 = new JTextField("Label1");
		jp2 = new JTextField("Lable2");
		
		labelPanel.add(jp1);
		labelPanel.add(jp2);
		
		backAndClear.add(back);
		backAndClear.add(clear);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(backAndClear, BorderLayout.CENTER);
		this.add(labelPanel, BorderLayout.NORTH);
		
		setBounds(900, 200, 300, 250);
		setVisible(true);
		setResizable(false);
		
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