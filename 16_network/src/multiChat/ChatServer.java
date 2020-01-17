package multiChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private List<ChatHandler> list;
	
	
	public ChatServer() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ�Ϸ�!");
			
			list = new ArrayList<ChatHandler>();
			
			while(true) { //������ ��� ������ ����
				socket = serverSocket.accept(); //����æ��
				
				ChatHandler handler = new ChatHandler(socket, list); //������ ����(�ڵ鷯�� ������ �̹Ƿ� �ڵ鷯���� -> ���������)
				handler.start();
				
				list.add(handler);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new ChatServer();
	}
	
}
