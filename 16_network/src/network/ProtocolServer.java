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
			System.out.println("�����غ�Ϸ�");
			
			socket = serverSocket.accept(); //����æ��
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵ˴ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		
		String line;
		while(true) {
			try {
				//�޴� ��
				line = br.readLine();
				//������ ��
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1]+"�� ����\n");
					bw.flush();
				} else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1]+"�� ����\n");
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
