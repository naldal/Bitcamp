package workout;

import java.util.Scanner;

public class MoneyMain{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int korMoney, input;
		Money money;
		
		System.out.println("�����Է�");
		korMoney = sc.nextInt();
		
		System.out.print("1. �޷�   2. ��ȭ   3. ����");
		input = sc.nextInt();

		switch (input) {
			case 1 : 
				money = new USMoney();
				money.calcMoney(korMoney);
				money.dispMoney(korMoney);
				break;
			case 2 : 
				money = new JapanMoney();
				money.calcMoney(korMoney);
				money.dispMoney(korMoney);
				break;
			case 3 : 
				money = new ChinaMoney();
				money.calcMoney(korMoney);
				money.dispMoney(korMoney);
				break;
		}
	}
}
