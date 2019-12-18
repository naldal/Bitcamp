package method;

public class MethodTest2 {
	public static void disp() {// method�� ����
		System.out.println("static method");
	}

	public void output() {
		System.out.println("non-static method");
	}
	

	public static void main(String[] args) {
		// ȣ��
		MethodTest2.disp();
		disp();

		// new MethodTest2().output();
		MethodTest2 method2 = new MethodTest2();
		method2.output();
		System.out.println("method2 = " + method2);// ��Ű����.Ŭ������@16������ �ּҰ� ���� , toString()����
		System.out.println("method2 = " + method2.toString());
		System.out.println("method2 = " + method2.hashCode());// �ּҰ� 10������ ����
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
	
	//Overload �Ȱ��� �̸��� �޼ҵ带 �������� ����� �ִ� ��, �ڱ��� ��Ȯ�� ���� ã�ư��� �ϱ� ����
}
