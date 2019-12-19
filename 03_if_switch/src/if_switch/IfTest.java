package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		if(a>50)
		System.out.println("a: ");

				
		if(true)
		if(false) System.out.println("A");
		else System.out.println("B");
		System.out.println("C");
		System.out.println();
		
		if(a%2==1) System.out.println(a+"는 홀수");
		else System.out.println(a+"는 홀수");
		
		if(a>='A' && a<='Z') //65~90
			System.out.println((char)a+"는 대문자");
		else if(a>='a' && a<='z') //97~122
			System.out.println((char)a+"는 소문자");
		else
			System.out.println((char)a+"는 숫자이거나 특수문자");
		
	}
}
