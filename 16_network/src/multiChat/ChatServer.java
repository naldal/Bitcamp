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
			System.out.println("서버준비완료!");
			
			list = new ArrayList<ChatHandler>();
			
			while(true) { //서버가 계속 켜지는 상태
				socket = serverSocket.accept(); //낚아챈다
				
				ChatHandler handler = new ChatHandler(socket, list); //스레드 생성(핸들러가 스레드 이므로 핸들러생성 -> 스래드생성)
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
