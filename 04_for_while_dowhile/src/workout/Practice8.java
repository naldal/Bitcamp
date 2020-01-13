package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice8 {
	static int total;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice8 t5 = new Practice8();
		int input;
		int thorwAway = 0;
		
		while(true) {
			System.out.println("***********");
			System.out.println("  1.예금");
			System.out.println("  2.출금");
			System.out.println("  3.잔고");
			System.out.println("  4.종료");
			System.out.println("***********");
			
			System.out.println("번호선택");
			input = Integer.parseInt(br.readLine());
			
			if(input==1) {
				System.out.print("예금액 :");
				input = Integer.parseInt(br.readLine());
				
				if(input%10000==0) {
					int resultOne = t5.input(input);
					System.out.println("당신의 잔액은 "+resultOne+"원 입니다");
				} else {
					System.out.println("만원단위로 입력하세요");
					continue;
				}
			} else if(input==2) {
				System.out.print("출금액 :");
				input = Integer.parseInt(br.readLine());
				thorwAway = t5.output(input);
				if(thorwAway>0) {
					System.out.println("당신의 잔액은"+thorwAway+"입니다");
				} else {
					System.out.println("잔액이 부족합니다");
				}
			} else if(input==3) {
				System.out.println("당신의 잔액은 "+total+"입니다");
			} else {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	} //main
	
	public int input(int money) {
		total += money;
		return total;
	}
	
	public int output(int money) {
		total -= money;
		return total;
	}

}
