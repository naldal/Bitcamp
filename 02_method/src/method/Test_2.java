package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
�ֻ����� 2�� ������ ���� ���� ���� ���Ͻÿ�
�ֻ����� input()���� 1~6������ ������ �߻��Ͽ� �����Ѵ�
���� add()���� ���Ͽ� ���� �޴´�

[������]
ù��° �ֻ��� �� : 3
�ι�° �ֻ��� �� : 6
���� 9 �̴�
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

		System.out.print("ù��° �ֻ��� �� :");
		int dice1 = t2.dice();
		System.out.print(dice1);
		System.out.println();
		System.out.print("�ι�° �ֻ��� �� :");
		int dice2 = t2.dice();
		System.out.print(dice2);

		int sum = t2.add(dice1, dice2);
		System.out.println();
		System.out.println(sum);
	}
}
