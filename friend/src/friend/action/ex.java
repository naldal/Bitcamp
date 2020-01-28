package friend.action;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ex extends JFrame {

	private JPanel contentPane;
	private JTextField nameT;
	private JTextField numT2;
	private JTextField numT3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex frame = new ex();
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
	public ex() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setBounds(48, 305, 588, 109);
		contentPane.add(area);
		
		JList list = new JList();
		list.setBounds(399, 46, 237, 222);
		contentPane.add(list);
		
		nameT = new JTextField();
		nameT.setBounds(93, 44, 177, 21);
		contentPane.add(nameT);
		nameT.setColumns(10);
		
		JComboBox numT1 = new JComboBox();
		numT1.setBounds(93, 73, 50, 21);
		contentPane.add(numT1);
		
		numT2 = new JTextField();
		numT2.setBounds(158, 73, 50, 21);
		contentPane.add(numT2);
		numT2.setColumns(10);
		
		numT3 = new JTextField();
		numT3.setBounds(219, 73, 51, 21);
		contentPane.add(numT3);
		numT3.setColumns(10);
		
		JRadioButton maleRadio = new JRadioButton("New radio button");
		maleRadio.setBounds(93, 115, 19, 23);
		contentPane.add(maleRadio);
		
		JRadioButton femaleRadio = new JRadioButton("New radio button");
		femaleRadio.setBounds(154, 115, 19, 23);
		contentPane.add(femaleRadio);
		
		JCheckBox bookCheck = new JCheckBox("New check box");
		bookCheck.setBounds(93, 161, 22, 23);
		contentPane.add(bookCheck);
		
		JCheckBox movieCheck = new JCheckBox("New check box");
		movieCheck.setBounds(154, 161, 22, 23);
		contentPane.add(movieCheck);
		
		JCheckBox musicCheck = new JCheckBox("New check box");
		musicCheck.setBounds(212, 161, 22, 23);
		contentPane.add(musicCheck);
		
		JCheckBox gameCheck = new JCheckBox("New check box");
		gameCheck.setBounds(278, 161, 22, 23);
		contentPane.add(gameCheck);
		
		JCheckBox shoppingCheck = new JCheckBox("New check box");
		shoppingCheck.setBounds(339, 161, 22, 23);
		contentPane.add(shoppingCheck);
		
		JButton submitB = new JButton("\uB4F1\uB85D");
		submitB.setBounds(93, 229, 60, 23);
		contentPane.add(submitB);
		
		JButton updateB = new JButton("\uC218\uC815");
		updateB.setEnabled(false);
		updateB.setBounds(170, 229, 60, 23);
		contentPane.add(updateB);
		
		JButton deleteB = new JButton("\uC0AD\uC81C");
		deleteB.setEnabled(false);
		deleteB.setBounds(240, 229, 60, 23);
		contentPane.add(deleteB);
		
		JButton clearB = new JButton("\uC9C0\uC6B0\uAE30");
		clearB.setEnabled(false);
		clearB.setBounds(310, 229, 80, 23);
		contentPane.add(clearB);
		
		JLabel nameL = new JLabel("\uC774\uB984");
		nameL.setBounds(12, 47, 57, 15);
		contentPane.add(nameL);
		
		JLabel phoneNumL = new JLabel("\uC804\uD654\uBC88\uD638");
		phoneNumL.setBounds(12, 76, 57, 15);
		contentPane.add(phoneNumL);
		
		JLabel genderL = new JLabel("\uC131\uBCC4");
		genderL.setBounds(12, 119, 57, 15);
		contentPane.add(genderL);
		
		JLabel hobbyL = new JLabel("\uCDE8\uBBF8");
		hobbyL.setBounds(12, 165, 57, 15);
		contentPane.add(hobbyL);
		
		JLabel femaie = new JLabel("\uC5EC\uC790");
		femaie.setBounds(179, 119, 41, 15);
		contentPane.add(femaie);
		
		JLabel male = new JLabel("\uB0A8\uC790");
		male.setBounds(118, 119, 41, 15);
		contentPane.add(male);
		
		JLabel bookL = new JLabel("\uB3C5\uC11C");
		bookL.setBounds(118, 165, 32, 15);
		contentPane.add(bookL);
		
		JLabel movieL = new JLabel("\uC601\uD654");
		movieL.setBounds(179, 165, 30, 15);
		contentPane.add(movieL);
		
		JLabel musicL = new JLabel("\uC74C\uC545");
		musicL.setBounds(235, 165, 32, 15);
		contentPane.add(musicL);
		
		JLabel gameL = new JLabel("\uAC8C\uC784");
		gameL.setBounds(300, 165, 32, 15);
		contentPane.add(gameL);
		
		JLabel shoppingL = new JLabel("\uC1FC\uD551");
		shoppingL.setBounds(366, 165, 32, 15);
		contentPane.add(shoppingL);
		
		JLabel analyze_personal = new JLabel("\uAC1C\uC778 \uC815\uBCF4 \uBD84\uC11D");
		analyze_personal.setBounds(229, 280, 142, 15);
		contentPane.add(analyze_personal);
		
		JLabel personal_info = new JLabel("\uAC1C\uC778\uC815\uBCF4\uC785\uB825");
		personal_info.setBounds(136, 10, 134, 15);
		contentPane.add(personal_info);
		
		JLabel total_list = new JLabel("\uC804\uCCB4 \uBAA9\uB85D");
		total_list.setBounds(474, 21, 162, 15);
		contentPane.add(total_list);
	}
}
