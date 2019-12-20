package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGame {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int usrNum;
		int computRan = (int)(Math.random()*100)+1;
		int cnt=0;
		
		while(true) {
			System.out.print("숫자입력 : ");
			usrNum = Integer.parseInt(br.readLine());
			cnt++;
			if(usrNum > computRan) {
				System.out.println(usrNum+"보다 작습니다.");
			} else if (usrNum < computRan) {
				System.out.println(usrNum+"보다 큽니다.");
			} else {
				System.out.println("딩동댕"+cnt+"만에 맞추셨습니다.");
				break;
			}
		}
	}
}
