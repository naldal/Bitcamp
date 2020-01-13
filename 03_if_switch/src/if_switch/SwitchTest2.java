package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SwitchTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("a값 입력 : ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("b값 입력 : ");
		int b = Integer.parseInt(br.readLine());
		
		System.out.print("연산자 입력 : ");
		String sth = br.readLine();
	
		double val;
		
		switch(sth) {
		case "+":
			System.out.print("a+b = "+(a+b));
			break;
		case "-":
			System.out.print("a-b = "+(a-b));
			break;
		case "*":
			System.out.print("a*b = "+(a*b));
			break;
		case "/":
			val = (double)a/b;
			// System.out.print("a/b = "+(String.format("%.3f", val)));
			DecimalFormat df = new DecimalFormat("#.###");
			System.out.print("a/b = "+(df.format(val)));
			
			break;
		default : System.out.print("연산자 error");
		}
	}
}
