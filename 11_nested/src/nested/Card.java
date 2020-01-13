package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Card {
	private Frame frame;
	private CardLayout card;

	public Card() {
		frame = new Frame();		
		card = new CardLayout();
		frame.setLayout(card);
		
		String[] title = {"»¡°­","ÃÊ·Ï","ÆÄ¶û","³ë¶û","º¸¶ó","ÇÏ´Ã"};
		Color[] color = {Color.red, Color.green, Color.blue, Color.yellow, Color.magenta, Color.cyan};
		Panel[] p = new Panel[6];
		for(int i=0; i<p.length; i++) {
			p[i] = new Panel();
			p[i].setBackground(color[i]);
			
			frame.add(p[i], title[i]);
			
			p[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					card.show(frame,"º¸¶ó");
				}
			});
		}		
		
		frame.setBounds(900, 200, 300, 300);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Card card = new Card();
	}
}
