package thread;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class RunRace extends Frame implements ActionListener {
	private int count;
	private String[] name;
	private Button btn;
	private Racer[] r;
	static String finName;
	
	public RunRace(int count, String [] name) {
		this.count = count;
		this.name = name;
		btn = new Button(" 출발  ");
		
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(btn);
		
		Panel p2 = new Panel(new GridLayout(count,1));
		r = new Racer[count];
		for(int i=0; i<count; i++) {
			r[i] = new Racer();//Canvas 생성
			p2.add(r[i]);
		}
		
		
		add("South", p);
		add("Center", p2);
		
		setBounds(700, 100, 600, 500);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		btn.setEnabled(false);
		
		//스레드 생성
		Thread[] t = new Thread[count]; 
		for(int i=0; i<count; i++) {
			t[i] = new Thread(r[i], name[i]);//스레드 생성, 스레드 이름생성
			t[i].setPriority((int)(Math.random()*10+1));//1~10
			t[i].start();

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("경주마 수를 입력 : ");
		int count = scan.nextInt();
		
		String[] name = new String[count];
		for(int i=0; i<count; i++) {
			System.out.print("경주마 이름를 입력 : ");
			name[i] = scan.next();
		}
		
		new RunRace(count, name);
	}

	
}
