package if_switch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice_3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자를 입력해주세요 : ");
		int a = Integer.parseInt(br.readLine());

		for (int i = 1; i <= a; i++) {
			if (a % i == 0) {
				System.out.print(i + " ");
			}
		}

	}
}
