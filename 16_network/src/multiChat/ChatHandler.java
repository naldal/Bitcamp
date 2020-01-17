package multiChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ChatHandler extends Thread{
	private Socket socket;
	private List<ChatHandler> list;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatHandler(Socket socket, List<ChatHandler> list) {
		this.socket = socket;
		this.list = list;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		try {
			//�г��� �޴� ��
			String nickName = br.readLine();
			broadcast(nickName+"���� ��5���Ͽ����ϴ�");

			String line;
			while(true) {
				//�޴� �� 
				line = br.readLine();
				if(line==null||line.toLowerCase().contentEquals("quit")) {
					break;
				}
				
				//������ ��
				broadcast("["+nickName+"]"+line);
			}//while
			
			//Ŭ���̾�Ʈ�κ��� quit�� �޾��� ��
			pw.println("quit");
			pw.flush();
			
			//���� Ŭ���̾�Ʈ���� ���� �޽��� ������
			list.remove(this); //�����ϰڴٴ� ��(this)�� ������
			broadcast(nickName+"���� �����ϼ̽��ϴ�.");
			
			br.close();
			pw.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void broadcast(String msg) {
		for(ChatHandler handler : list) {
			handler.pw.write(msg+"\n");
			handler.pw.flush();
		}
	}
}
