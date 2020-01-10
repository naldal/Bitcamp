package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JProgressBarEx extends JFrame implements ActionListener, Runnable {

	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
	private JButton startBtn = new JButton("시작");
	private JButton stopBtn = new JButton("멈춤");
	
	public JProgressBarEx() {
		
		super ("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("이것이 프로그래스 바당..."));
		con.add("Center", jpb);
		jpb.setStringPainted(true);
		jpb.setString("0%");
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(startBtn);
		jp.add(stopBtn);
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
		con.add("South", jp);
		setSize(300,150);
		setVisible(true);
	}
	
	private boolean bb =true;
	private static int ii;
	public void run() {
		if(ii==100) ii =0;
		for(int i=ii; i<=100; i++) {
			if(!bb) break;
			try {
				Thread.sleep(50);
			} catch (InterruptedException ee) {}
			
			jpb.setValue(i);
			ii = i;
			jpb.setString(ii+"%");
		}
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startBtn) {
			bb = true; new Thread(this).start();
			startBtn.setEnabled(false);
			stopBtn.setEnabled(true);
		} else if(e.getSource()==stopBtn) {
			bb = false;
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
		
	}
	
	public static void main(String[] args) {
		new JProgressBarEx();
		
		
	}


}
