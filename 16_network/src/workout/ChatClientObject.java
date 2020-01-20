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
	private BufferedReader br; // �޴°�
	private PrintWriter pw; // �����°�

	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	Socket socket;

	public ChatClientObject() {

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
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//������ �����ϱ� �������� �����ؼ��� �ȵȴ�
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

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			// �г����� ������ ������
			InfoDTO dto = new InfoDTO();
			dto.setNickName(nickName);
			dto.setCommand(Info.JOIN);
			oos.writeObject(dto);
			oos.flush();

		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�.");
		}

		// ������ ����
		Thread t = new Thread(this);
		t.start();

		send.addActionListener(this);
		input.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ������ ��
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
