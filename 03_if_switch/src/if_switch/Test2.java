package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("x값 입력 : ");
		int tmp = 1;
		int x = Integer.parseInt(br.readLine());
		
		System.out.print("y값 입력 : ");
		int y = Integer.parseInt(br.readLine());
		
		for(int i=1 ; i<=y ; i++) {
			tmp *= x;
			
		} //for
		
		System.out.println(x+"의 "+y+"승 "+tmp);
	}
}
