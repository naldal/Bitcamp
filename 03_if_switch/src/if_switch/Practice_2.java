package if_switch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("x값 입력 : ");
		int x = Integer.parseInt(br.readLine());
		System.out.println("y값 입력 : ");
		int y = Integer.parseInt(br.readLine());
		int num = 0;

		for (int i = 0; i < y; i++) {
			if (i == 0) {
				num += x;

			} else {
				num *= x;
			}
		}
		System.out.println(x + "의 " + y + "승 " + num);

	}
}

/*
 * [문제2] 제곱을 구하시오 (x의 y의 승) [실행결과] x값 입력 : 2 y값 입력 : 5 2의 5승 xx (2*2*2*2*2) 또는
 * x값 입력 : 3 y값 입력 : 4 3의 4승 xx (3*3*3*3)
 */
