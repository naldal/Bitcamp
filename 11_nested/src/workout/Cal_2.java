package workout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cal_2 extends JFrame{

	private JLabel dispL, inputL;
	private JButton[] button;
	
	public Cal_2() {
		
		setLayout(null);
		setTitle("°è»ê±â");
		setBounds(800,300,400,500);
		setBackground(Color.black);
		
		dispL = new JLabel("", JLabel.RIGHT);
		dispL.setBackground(Color.WHITE);
		dispL.setOpaque(true);
		dispL.setBounds(9,10,375,50);
		
		inputL = new JLabel("0", JLabel.RIGHT);
		inputL.setBackground(Color.WHITE);
		inputL.setOpaque(true);
		inputL.setBounds(9,70,375,50);
		
		String[] title = {"¡ç","C",
				"7","8","9","/",
				"4","5","6","*",
				"1","2","3","-",
				".","0","=","/"};
		
		button = new JButton[18];
		for(int i=0; i<button.length; i++) {
			button[i] = new JButton(title[i]);
		}
		
		button[0].setBounds(199,160,185,50);
		button[1].setBounds(9,160,185,50);
				
		button[5].setBounds(294,220,90,50);
		button[4].setBounds(199,220,90,50);
		button[3].setBounds(104,220,90,50);
		button[2].setBounds(9,220,90,50);
		
		button[9].setBounds(294,280,90,50);
		button[8].setBounds(199,280,90,50);
		button[7].setBounds(104,280,90,50);
		button[6].setBounds(9,280,90,50);
		
		button[13].setBounds(294,340,90,50);
		button[12].setBounds(199,340,90,50);
		button[11].setBounds(104,340,90,50);
		button[10].setBounds(9,340,90,50);
		
		button[17].setBounds(294,400,90,50);
		button[16].setBounds(199,400,90,50);
		button[15].setBounds(104,400,90,50);
		button[14].setBounds(9,400,90,50);
		
		add(dispL);
		add(inputL);
		for(int i=0; i<button.length; i++) {
			add(button[i]);
		}

		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Cal_2 cal2 = new Cal_2();
	}
	
}
