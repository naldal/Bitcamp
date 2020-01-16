package multiChat;

import java.awt.BorderLayout;
import java.awt.Container; 
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame{

	private JTextArea output;
	private JTextField input;
	private JButton send;
	private JScrollPane scroll;
	private JPanel p;
	
	public ChatClient() {
	
		output = new JTextArea();
		scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField(20);
		send = new JButton("전송");
		output.setEditable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		p.add("Center", input);
		p.add("East", send);
		
		Container con = this.getContentPane();
		con.add("Center", scroll);
		con.add("South", p);
		
		
		
		setBounds(900,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private void service() {
		//서버 IP
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "192.168.0.65");
		if(serverIP==null||serverIP.length()==0) {
			System.out.println("서버 IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if(nickName==null || nickName.length()==0) {
			nickName="guest";
		}
		
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}



	
}
