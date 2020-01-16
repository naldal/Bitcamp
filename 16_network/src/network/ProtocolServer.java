package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolServer {

	private ServerSocket serverSocket;
	private BufferedReader br;
	private BufferedWriter bw;
	private Socket socket;
	
	public ProtocolServer() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("서버준비완료");
			
			socket = serverSocket.accept(); //낚아챈다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 안됩니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		String line;
		while(true) {
			try {
				//받는 쪽
				line = br.readLine();
				//보내는 쪽
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1]+"님 입장\n");
					bw.flush();
				} else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1]+"님 퇴장\n");
					bw.flush();
					bw.close();
					br.close();
					socket.close();
					System.exit(0);
				} else if(ar[0].equals(Protocol.SEND_MESSAGE)){
					bw.write("["+ar[1]+"]"+ar[2]+"\n");
					bw.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} //while
	}
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
	
}
