package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
주사위를 2번 던져서 나온 값의 합을 구하시오
주사위는 input()에서 1~6사이의 난수를 발생하여 리턴한다
합은 add()에서 구하여 리턴 받는다

[실행결과]
첫번째 주사위 값 : 3
두번째 주사위 값 : 6
합은 9 이다
 */
public class Test_2 {

	public int dice() {
		int ran = (int) (Math.random() * 6) + 1;
		return ran;
	}

	public int add(int dice1, int dice2) {
		int sum = dice1 + dice2;
		return sum;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Test_2 t2 = new Test_2();

		System.out.print("첫번째 주사위 값 :");
		int dice1 = t2.dice();
		System.out.print(dice1);
		System.out.println();
		System.out.print("두번째 주사위 값 :");
		int dice2 = t2.dice();
		System.out.print(dice2);

		int sum = t2.add(dice1, dice2);
		System.out.println();
		System.out.println(sum);
	}
}
