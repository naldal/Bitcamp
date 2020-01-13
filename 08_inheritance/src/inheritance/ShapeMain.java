package inheritance;

import java.util.Scanner;

class ShapeTest {
	protected Scanner sc = new Scanner(System.in);
	protected double area;
	
	public ShapeTest() {
		
		System.out.println("ShapeTest �⺻������");
	}
	
	public void calcArea() {
		System.out.println("������ ����մϴ�.");
	}
	// public void calcArea() {} �߻�Ŭ���� : �޸𸮿��� ũ�⸦ �������� �ʰ� ����Ŭ���������� ������ ������ �����ϱ� ����
	
	public void dispArea() {
		System.out.println("������ ����մϴ�.");
	}
}

//----------------
class SamTest extends ShapeTest{
	private int base, height;
	
	public SamTest() {
		System.out.println("SamTest �⺻������");
	}
	
	@Override
	public void calcArea() {
		base = sc.nextInt();
		height = sc.nextInt();
		area = base*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = "+area);
	}
}

//----------------
class SaTest extends ShapeTest{ //�簢�� ����
	private int width, height;
	

	public SaTest() {
		System.out.println("SaTest �⺻������");
	}
	
	@Override
	public void calcArea() {
		width=sc.nextInt();
		height=sc.nextInt();
	}
	
	@Override
	public void dispArea() {
		System.out.println(width*height/2.0);
	}
}

//----------------
class SdariTest extends ShapeTest{ //��ٸ��� ����
	private int top, bottom, height;
	

	public SdariTest() {
		System.out.println("SdariTest �⺻������");
	}
	
	@Override
	public void calcArea() {
		top=sc.nextInt();
		bottom=sc.nextInt();
		height=sc.nextInt();
	}
	
	@Override
	public void dispArea() {
		System.out.println(top+bottom*height/2.0);
	}
}

//----------------
public class ShapeMain{

	public static void main(String[] args) {
		ShapeTest sh = new SdariTest();
		sh.calcArea();
		sh.dispArea();
		System.out.println();
		
		sh = new SamTest();  //���յ� ���߱�, �θ�=�ڽ�, �ڽ�=(�ڽ�)�θ�
		sh.calcArea();
		sh.dispArea();
		System.out.println();
		
		sh = new SaTest();
		sh.calcArea();
		sh.dispArea();
		System.out.println();
	}
}
