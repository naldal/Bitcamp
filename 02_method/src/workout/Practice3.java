package workout;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice3 {
	// �ʸ� �Է¹޾Ƽ� time()���� ��,��,�ʸ� ���Ͽ� ����Ѵ�.

	public String/* void */ time(String full_second) {

		int time = Integer.parseInt(full_second);
		int hour = time / 3600;
		int minute = time % 3600 / 60;
		int second = time % 60;
		// System.out.println(hour+"�ð� "+minute+"�� "+second+"�� �Դϴ�.");
		return hour + "�ð� " + minute + "�� " + second + "�� �Դϴ�.";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice3 p3 = new Practice3();
		System.out.print("�ʸ� �Է��Ͻÿ�. : ");
		String full_second = br.readLine();
		String time = p3.time(full_second);
		System.out.println(time);
	}
}
