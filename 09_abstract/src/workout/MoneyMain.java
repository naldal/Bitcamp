package workout;

import java.util.Scanner;

public class MoneyMain{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int korMoney, input;
		Money money = null;
		
		System.out.println("현금입력");
		korMoney = sc.nextInt();
		
		System.out.print("1. 달러   2. 엔화   3. 위안");
		input = sc.nextInt();

		switch (input) {
			case 1 : 
				money = new USMoney();
				break;
			case 2 : 
				money = new JapanMoney();
				break;
			case 3 : 
				money = new ChinaMoney();
				break;
		}
		money.calcMoney(korMoney);
		money.dispMoney(korMoney);
	}
}
