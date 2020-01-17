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
			//닉네임 받는 쪽
			String nickName = br.readLine();
			broadcast(nickName+"님이 입5장하였습니다");

			String line;
			while(true) {
				//받는 쪽 
				line = br.readLine();
				if(line==null||line.toLowerCase().contentEquals("quit")) {
					break;
				}
				
				//보내는 쪽
				broadcast("["+nickName+"]"+line);
			}//while
			
			//클라이언트로부터 quit을 받았을 때
			pw.println("quit");
			pw.flush();
			
			//남은 클라이언트에게 퇴장 메시지 보내기
			list.remove(this); //퇴장하겠다는 나(this)를 제거함
			broadcast(nickName+"님이 퇴장하셨습니다.");
			
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
