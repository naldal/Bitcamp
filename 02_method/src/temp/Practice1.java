package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice1 {
	// 정수(dec)를 입력받아서 2진수(binary), 8진수(octor), 16진수(hexa) 변환하시오
	// Integer클래스 메소드를 이용하시오
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("10진수를 입력하세요: ");
		System.out.println();
		int dec = Integer.parseInt(br.readLine());

		// String binary = Integer.toBinaryString(dec);
		// String octor = Integer.toOctalString(dec);
		// String hexa = Integer.toHexString(dec);
		System.out.println("2진수 = " + Integer.toBinaryString(dec));
		System.out.println("8진수 = " + Integer.toOctalString(dec));
		System.out.println("16진수 = " + Integer.toHexString(dec));
		
	}
}
