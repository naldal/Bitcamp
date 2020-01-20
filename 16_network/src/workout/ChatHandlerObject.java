package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import multiChat.ChatHandler;

public class ChatHandlerObject extends Thread {

	private Socket socket;
	private List<ChatHandlerObject> list;
	private BufferedReader br;
	private PrintWriter pw;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;

		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());

	}

	@Override
	public void run() {
		try {
			InfoDTO dto = null;
			String nickName = null;

			while (true) {
				// �޴���
				dto = (InfoDTO) ois.readObject();

				if (dto.getCommand() == Info.JOIN) {
					nickName = dto.getNickName();

					// ��� Ŭ���̾�Ʈ���� �޼��� ������
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName + "���� �����Ͽ����ϴ�.");
					broadcast(sendDTO);

				} else if (dto.getCommand() == Info.EXIT) {
					InfoDTO sendDTO = new InfoDTO();

					// Ŭ���̾�Ʈ�κ��� quit�� �޾�����
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();

					oos.close();
					ois.close();
					socket.close();

					// ���� Ŭ���̾�Ʈ���� ���� �޼��� ������
					list.remove(this);

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName + "���� �����Ͽ����ϴ�.");
					broadcast(sendDTO);

				} else if (dto.getCommand() == Info.SEND) {
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg("[" + nickName + "]" + dto.getMsg());
					broadcast(sendDTO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void broadcast(InfoDTO sendDTO) {
		for (ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
