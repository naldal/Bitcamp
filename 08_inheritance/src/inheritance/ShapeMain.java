package inheritance;

import java.util.Scanner;

class ShapeTest {
	protected Scanner sc = new Scanner(System.in);
	protected double area;
	
	public ShapeTest() {
		
		System.out.println("ShapeTest 기본생성자");
	}
	
	public void calcArea() {
		System.out.println("도형을 계산합니다.");
	}
	// public void calcArea() {} 추상클래스 : 메모리에서 크기를 차지하지 않고 하위클래스에서의 구현부 생성을 강제하기 위함
	
	public void dispArea() {
		System.out.println("도형을 출력합니다.");
	}
}

//----------------
class SamTest extends ShapeTest{
	private int base, height;
	
	public SamTest() {
		System.out.println("SamTest 기본생성자");
	}
	
	@Override
	public void calcArea() {
		base = sc.nextInt();
		height = sc.nextInt();
		area = base*height/2.0;
	}
	
	public void dispArea() {
		System.out.println("삼각형 넓이 = "+area);
	}
}

//----------------
class SaTest extends ShapeTest{ //사각형 넓이
	private int width, height;
	

	public SaTest() {
		System.out.println("SaTest 기본생성자");
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
class SdariTest extends ShapeTest{ //사다리꼴 넓이
	private int top, bottom, height;
	

	public SdariTest() {
		System.out.println("SdariTest 기본생성자");
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
		
		sh = new SamTest();  //결합도 낮추기, 부모=자식, 자식=(자식)부모
		sh.calcArea();
		sh.dispArea();
		System.out.println();
		
		sh = new SaTest();
		sh.calcArea();
		sh.dispArea();
		System.out.println();
	}
}
