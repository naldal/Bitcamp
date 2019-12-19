package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
초를 입력받아서 time()에서 시,분,초를 구하여 출력한다

[실행결과]
초를 입력하시오 : 3850
1시간 4분 10초 입니다
 */

public class Test_3 {

	public void time (int sec) {
		int hour = sec/3600;
		int minute = (sec%3600)/60;
		int second = minute%3600%60;
		System.out.println(sec + "초는 " + hour + "시간 " + minute + "분 " + second + "초 입니다.");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Test_3 t3 = new Test_3();
		
		System.out.print("초를 입력하시오 :");
		
		int sec = Integer.parseInt(br.readLine());
		t3.time(sec);
		
	}
}
