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
		System.out.println("x의 값 입력");
		x = sc.nextInt();
		
		System.out.println("y의 값 입력");
		y = sc.nextInt();
	}
	
	public void output() {
		assert y>=0 : "y는 0보다 크거나 같아야한다";	//틀리면 에러발생
		
		System.out.print(x+"의 "+y+"승은 ");
		int result = 1;
		//result = (int) Math.pow(x, y);
		for(int i=0; i<y; i++) {
			result *= x;
		}
		
		System.out.println(result);
	}
}
