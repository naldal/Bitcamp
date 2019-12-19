package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SwitchTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("a�� �Է� : ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("b�� �Է� : ");
		int b = Integer.parseInt(br.readLine());
		
		System.out.print("������ �Է� : ");
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
		default : System.out.print("������ error");
		}
	}
}
