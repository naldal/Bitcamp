package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("a값 입력");
		int a = Integer.parseInt(br.readLine());
		System.out.println("b값 입력");
		int b = Integer.parseInt(br.readLine());
		System.out.println("c값 입력");
		int c = Integer.parseInt(br.readLine());

		int tmp1=0, tmp2=0, tmp3=0;
		
		if(a>=b) {
			tmp1=a;
			tmp2=b;
			
			if(b>=c) {
				tmp2=b;
				tmp3=c;
			} else {
				tmp2=c;
				tmp3=b;
			}
		} else if(b>=a) {
			tmp1=b;
			tmp2=a;
			
			if(a>=c) {
				tmp2=a;
				tmp3=c;
			} else {
				tmp2=c;
				tmp3=a;
			}
		} else if(c>=a) {
			tmp1=c;
			tmp2=a;
			
			if(a>=b) {
				tmp2=a;
				tmp3=b;
			} else {
				tmp2=b;
				tmp3=a;
			}	
		}
		
		System.out.println(tmp3+" "+tmp2+" "+tmp1);

	}
}
