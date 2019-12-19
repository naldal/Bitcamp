package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(br.readLine());
		String tmp = "";
		
		for(int i=1 ; i<=num; i++) {
			if(num%i==0) {
				tmp+=i+" ";
			}
		}
		System.out.println(tmp);
	}
}
