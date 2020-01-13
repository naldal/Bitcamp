package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Practice8_8 {
	static int balance;
	static int deposit, withdraw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice8_8 p8=new Practice8_8();
		
		Practice8_8 p = new Practice8_8();
		int num;
		
		while(true) {
			System.out.println("***********");
			System.out.println(" 1. 예금");
			System.out.println(" 2. 출금");
			System.out.println(" 3. 잔고");
			System.out.println(" 4. 종료");
			System.out.println("***********");
			System.out.print("번호 선택 : ");
			num = Integer.parseInt(br.readLine());
			if(num==4) break;
			if(num==1) {
				balance=p8.input(balance);
			} else if(num==2) {
				balance=p8.output(balance);
			} else if(num==3) {
				System.out.println("당신의 잔액은 "+balance+"입니다.");
			}
		}
	}

	public int output(int balance) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int deposit;
		
		System.out.println("출금액 :");
		deposit = Integer.parseInt(br.readLine());
		
		if(balance >= deposit) {
			balance -= deposit;
			System.out.println("당신의 잔액은"+balance+"원입니다");
		} else
			System.out.println("잔액이 부족");
		return balance;
	}

	public int input(int balance) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int deposit;
		
		System.out.println("예금액: ");
		deposit = Integer.parseInt(br.readLine());
		
		if(deposit%10000==0) {
			balance += deposit;
			System.out.println("당신의 잔액은 "+balance+"원 입니다");
		}else
			System.out.println("만원단위로 입력하세요");
		
		return balance;
	}
}