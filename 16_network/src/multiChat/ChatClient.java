package multiChat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea output;
	private JTextField input;
	private JButton send;
	private JScrollPane scroll;
	private BufferedReader br; // �޴°�
	private PrintWriter pw; // �����°�
	Socket socket;

	public ChatClient() {

		output = new JTextArea();
		scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField(20);
		send = new JButton("����");
		output.setEditable(false);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		p.add("Center", input);
		p.add("East", send);

		Container con = this.getContentPane();
		con.add("Center", scroll);
		con.add("South", p);

		setBounds(900, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void service() {
		// ���� IP
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���", "192.168.0.65");
		if (serverIP == null || serverIP.length() == 0) {
			System.out.println("���� IP�� �Էµ��� �ʾҽ��ϴ�.");
			System.exit(0);
		}

		// �г���
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}

		try {
			socket = new Socket(serverIP, 9500);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�.");
		}
		pw.println(nickName);
		pw.flush();

		// ������ ����
		Thread t = new Thread(this);
		t.start();

		send.addActionListener(this);
		input.addActionListener(this);
	}

	@Override
	public void run() {
		//�������� ���� �� �޴� ��
		String line;
		while(true) {
			try {
				line = br.readLine();
				if(line==null || line.equals("quit")) {
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ��������
		String msg = input.getText();
		pw.println(msg);
		pw.flush();
		input.setText("");
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}

}
