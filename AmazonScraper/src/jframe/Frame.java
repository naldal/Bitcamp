package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(147, 63, 245, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("시작");
		btnNewButton.setBounds(234, 162, 102, 51);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(147, 112, 245, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("종료");
		btnNewButton_1.setBounds(98, 162, 102, 51);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("크롤링 할 사이트");
		lblNewLabel.setBounds(32, 63, 102, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("저장 할 경로");
		lblNewLabel_1.setBounds(55, 117, 78, 15);
		contentPane.add(lblNewLabel_1);
	}
}
