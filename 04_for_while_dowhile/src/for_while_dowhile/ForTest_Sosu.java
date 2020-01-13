package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_Sosu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		int num;
		
		while(true) {
			System.out.println("숫자 입력");
			num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				break;
			}
			
			for(int i=1; i<num; i++) {
				if(num%i==0) {
					cnt++;
			}
		
			if(cnt!=2) {
				System.out.println(num+"는 소수가 아니다");
					break;
			} else {
				System.out.println(num+"는 소수이다");
					break;
			}
		} //while
		System.out.println("프로그램 종료");
				
	}
}
}