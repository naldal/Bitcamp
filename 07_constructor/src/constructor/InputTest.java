package constructor;

import java.util.Scanner;

public class InputTest {

	private int a;
	private double b;
	
	public InputTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		a=sc.nextInt();
		System.out.print("실수입력 : ");
		b=sc.nextDouble();
	}
	
	public void display() {
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		InputTest it = new InputTest();
		it.display();
		
	}
}
