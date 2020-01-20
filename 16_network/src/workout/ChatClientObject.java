package workout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class ChatClientObject extends JFrame implements ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	private JTextArea output;
	private JTextField input;
	private JButton send;
	private JScrollPane scroll;
	private BufferedReader br; // 받는거
	private PrintWriter pw; // 보내는거

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	Socket socket;

	public ChatClientObject() {

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

		setBounds(900, 200, 300, 300);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//서버가 응답하기 전까지는 종료해서는 안된다
				if(oos==null||ois==null) {
					System.exit(0);
				}
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT);
				
				try {
					oos.writeObject(dto);
					oos.flush();
				} catch(IOException io) {
					io.printStackTrace();
				}
			}
		});
	}

	private void service() {
		// 서버 IP
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "192.168.0.65");
		if (serverIP == null || serverIP.length() == 0) {
			System.out.println("서버 IP가 입력되지 않았습니다.");
			System.exit(0);
		}

		// 닉네임
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if (nickName == null || nickName.length() == 0) {
			nickName = "guest";
		}

		try {
			socket = new Socket(serverIP, 9500);

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			// 닉네임을 서버로 보내기
			InfoDTO dto = new InfoDTO();
			dto.setNickName(nickName);
			dto.setCommand(Info.JOIN);
			oos.writeObject(dto);
			oos.flush();

		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
		}

		// 스레드 생성
		Thread t = new Thread(this);
		t.start();

		send.addActionListener(this);
		input.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//서버로 보내는 쪽
		String msg = input.getText();
		InfoDTO dto = new InfoDTO();
		if(msg.toLowerCase().trim().equals("exit")) {
			dto.setCommand(Info.EXIT);
		} else {
			dto.setCommand(Info.SEND);
			dto.setMsg(msg);
		}
		
		try {
			oos.writeObject(dto);
			oos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		input.setText("");
	}

	@Override
	public void run() {
		InfoDTO dto = null;
		
		while(true) {
			try {
				dto = (InfoDTO) ois.readObject();
				
				if(dto.getCommand() == Info.EXIT) {
					ois.close();
					oos.close();
					socket.close();
					
					System.exit(0);
				}
				
				if(dto.getCommand() == Info.SEND) {
					output.append(dto.getMsg()+"\n");
					
					int pos = output.getText().length();
					output.setCaretPosition(pos);
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
