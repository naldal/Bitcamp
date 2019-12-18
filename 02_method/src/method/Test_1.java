package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

정수(dec)를 입력받아서 2진수(binary), 8진수(octor), 16진수(hexa) 변환하시오
Integer클래스 메소드를 이용하시오

[실행결과]
10진수를 입력하세요 : 250

2진수 = 11111010
8진수 = 372
16진수 = fa

 */
public class Test_1 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dec = Integer.parseInt(br.readLine());
		String a2 = Integer.toBinaryString(dec);  // 10진수 -> 2진수
		String a8= Integer.toOctalString(dec);    // 10진수 -> 8진수
		String a16 = Integer.toHexString(dec);

		System.out.println("2 진수 : " + a2);
		System.out.println("8 진수 : " + a8);
		System.out.println("16 진수 : " + a16);

	
	}
}
