package workout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {

			System.out.println("가위(1), 바위(2), 보(3) 중 번호를 입력하세요 : ");
			int me = Integer.parseInt(br.readLine());
			int computer = (int) (Math.random() * 3) + 1;

			if (me == 1) {
				if (computer == 2) {
					System.out.println("컴퓨터 : 바위\t나 : 가위");
					System.out.println("You Lose!!");
				} else if (computer == 3) {
					System.out.println("컴퓨터 : 보자기\t나 : 가위");
					System.out.println("You Win!!");
				} else {
					System.out.println("컴퓨터 : 가위\t나 : 가위");
					System.out.println("You Draw!!");
				}
			} else if (me == 2) {
				if (computer == 1) {
					System.out.println("컴퓨터 : 가위\t나 : 바위");
					System.out.println("You Win!!");
				} else if (computer == 2) {
					System.out.println("컴퓨터 : 바위\t나 : 바위");
					System.out.println("You Draw!!");
				} else {
					System.out.println("컴퓨터 : 보자기\t나 : 바위");
					System.out.println("You Lose!!");
				}
			} else if (me == 3) {
				if (computer == 1) {
					System.out.println("컴퓨터 : 가위\t나 : 보자기");
					System.out.println("You Lose!!");
				} else if (computer == 2) {
					System.out.println("컴퓨터 : 바위\t나 : 보자기");
					System.out.println("You Win!!");
				} else {
					System.out.println("컴퓨터 : 보자기\t나 : 보자기");
					System.out.println("You Draw!!");
				}
			} else {
				System.out.println("잘못된 값입니다.");
			}
			System.out.println("또 할래?(Y/N)");
			String again = br.readLine();
			if (again.equals("N")) {
				System.out.println("프로그램을 종료합니다.");
				break;

			}
		}
	}
}

//가위바위보
/*
 * [실행결과] 가위(1), 바위(2), 보(3) 중 번호 입력 : 3(user) 컴퓨터 : 바위 나 : 보자기 You Win!! 가위(1),
 * 바위(2), 보(3) 중 번호 입력 : 3(user) 컴퓨터 : 가위 나 : 보자기 You Lose!! 가위(1), 바위(2), 보(3)
 * 중 번호 입력 : 3(user) 컴퓨터 : 가위 나 : 가위 You Draw!!
 */