package method;

public class MethodTest2 {
	public static void disp() {// method의 구현
		System.out.println("static method");
	}

	public void output() {
		System.out.println("non-static method");
	}
	

	public static void main(String[] args) {
		// 호출
		MethodTest2.disp();
		disp();

		// new MethodTest2().output();
		MethodTest2 method2 = new MethodTest2();
		method2.output();
		System.out.println("method2 = " + method2);// 패키지명.클래스명@16진수로 주소값 전달 , toString()생략
		System.out.println("method2 = " + method2.toString());
		System.out.println("method2 = " + method2.hashCode());// 주소값 10진수로 전달
		System.out.println();

		int sum = method2.plus(25, 36);
		int sub = method2.minus(25, 36);
		int mul = method2.multiply(25, 36);
		double div = method2.divide(25, 36);
		
		System.out.println("25 + 36 = " + sum);
		System.out.println("25 - 36 = " + sub);
		System.out.println("25 * 36 = " + mul);
		System.out.println("25 / 36 = " + String.format("%.2f", div));
		
		
	}
	
	public int plus(int i, int j) {
		return i + j;
	}
	
	public int minus(int i, int j) {
		return i - j;
	}
	
	public int multiply(int i, int j) {
		return i * j;
	}
	
	public double divide(int i, int j) {
		return (double)i / (double)j;
	}
	
	//Overload 똑같은 이름의 메소드를 여러가지 만들어 주는 것, 자기의 정확한 형을 찾아가게 하기 위해
}
