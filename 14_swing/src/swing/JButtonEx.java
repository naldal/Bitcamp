package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class JButtonEx extends JFrame {

	private Icon icon1 = new ImageIcon("img/angry.png");
	private Icon icon2 = new ImageIcon("img/happy.png");
	private Icon icon3 = new ImageIcon("img/sad.jpg");
	private Icon icon4 = new ImageIcon("img/what.png");
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonEx() {
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i=0; i<4; i++) {
			jb[i] = new JRadioButton(i + 1 + "�� ��ư", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 + "��° ��ư�̴�. ����...");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);
		}
		pack();
		setVisible(true);
	}
	
			
	public static void main(String[] args) {
		
		new JButtonEx();
		
	}
}
