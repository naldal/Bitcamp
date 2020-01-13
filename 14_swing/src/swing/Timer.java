package swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("all")
public class Timer extends JFrame implements Runnable, KeyListener, ActionListener {
	private JLabel jl = new JLabel();
	private JButton startBtn, stopBtn;
	private JPanel jpL;
	private boolean bb = true;
	private static Thread t;

	public Timer() {

		setTitle("타이머");
		setBounds(700, 400, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jpL = new JPanel();

		jl.setBounds(100, 100, 100, 100);
		jl.setFont(new Font("산돌고딕", Font.BOLD, 70));
		setLayout(null);
		startBtn = new JButton("시작");
		stopBtn = new JButton("멈춤");

		add(startBtn);
		add(stopBtn);
		add(jl);
		startBtn.setBounds(300, 100, 60, 30);
		stopBtn.setBounds(300, 140, 60, 30);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);

		t = new Thread(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startBtn) {
			t.start();
			bb = true;
			startBtn.setEnabled(false);// 버튼 안눌리게
			stopBtn.setEnabled(true);
		} else if (e.getSource() == stopBtn) {
			t = null;
			bb = false;
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);

		}

	}

	@Override
	public void run() {
		for (int n = 1; n <= 20; n++) {
			jl.setText(Integer.toString(n));
			if (!bb)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		startBtn.setEnabled(true);
		stopBtn.setEnabled(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new Timer();
	}
}