package abstract_1;

import java.util.Scanner;

public class Assert {

	private static int x, y;
	
	public static void main(String[] args) {
		Assert as = new Assert();
		
		as.input();
		as.output();
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("x�� �� �Է�");
		x = sc.nextInt();
		
		System.out.println("y�� �� �Է�");
		y = sc.nextInt();
	}
	
	public void output() {
		assert y>=0 : "y�� 0���� ũ�ų� ���ƾ��Ѵ�";	//Ʋ���� �����߻�
		
		System.out.print(x+"�� "+y+"���� ");
		int result = 1;
		//result = (int) Math.pow(x, y);
		for(int i=0; i<y; i++) {
			result *= x;
		}
		
		System.out.println(result);
	}
}
