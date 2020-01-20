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
				// 받는쪽
				dto = (InfoDTO) ois.readObject();

				if (dto.getCommand() == Info.JOIN) {
					nickName = dto.getNickName();

					// 모든 클라이언트에게 메세지 보내기
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName + "님이 입장하였습니다.");
					broadcast(sendDTO);

				} else if (dto.getCommand() == Info.EXIT) {
					InfoDTO sendDTO = new InfoDTO();

					// 클라이언트로부터 quit을 받았을때
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();

					oos.close();
					ois.close();
					socket.close();

					// 남은 클라이언트에게 퇴장 메세지 보내기
					list.remove(this);

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMsg(nickName + "님이 퇴장하였습니다.");
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
