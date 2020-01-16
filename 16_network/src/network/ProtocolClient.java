package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ProtocolClient {

	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedReader keyboard;
	
	private InetAddress local;
	
	public ProtocolClient(){
		try {
		local = InetAddress.getLocalHost();
			socket = new Socket(local, 9500); //1.ip와 포트번호를 받는다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (IOException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}
		String msg;
		while(true) {
			//서버로 보내는 쪽
			try {
				msg = keyboard.readLine();
				
				bw.write(msg+"\n");
				
				bw.flush();
			//서버로부터 받는 쪽				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} //while
	}
	
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
