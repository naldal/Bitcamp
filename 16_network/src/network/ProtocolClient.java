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
			socket = new Socket(local, 9500); //1.ip�� ��Ʈ��ȣ�� �޴´�
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (IOException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		String msg, line;
		while(true) {
			try {
				//������ ������ ��
				/*
				 * "100: angel" //����
				 * "200: angel"	//����
				 * "300: angel" //ä��
				 */
				msg = keyboard.readLine();
				
				bw.write(msg+"\n");
				
				bw.flush(); //���ۺ���
			//�����κ��� �޴� ��			
				/*
				 * angel���� ���� <--100 
				 * angel���� ���� <--200
				 * [angel]�ȳ�   <--300
				 */
				
				line = br.readLine();
				System.out.println(line);
				String[] ar = msg.split(":");
				if(ar[0].equals("200")) {
					br.close();
					bw.close();
					socket.close();
					
					keyboard.close();
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} //while
	}
	
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
