package workout;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice3 {
	// 초를 입력받아서 time()에서 시,분,초를 구하여 출력한다.

	public String/* void */ time(String full_second) {

		int time = Integer.parseInt(full_second);
		int hour = time / 3600;
		int minute = time % 3600 / 60;
		int second = time % 60;
		// System.out.println(hour+"시간 "+minute+"분 "+second+"초 입니다.");
		return hour + "시간 " + minute + "분 " + second + "초 입니다.";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice3 p3 = new Practice3();
		System.out.print("초를 입력하시오. : ");
		String full_second = br.readLine();
		String time = p3.time(full_second);
		System.out.println(time);
	}
}
