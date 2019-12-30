package class_2;

public class StaticTest {
	private int a;
	private static int b;
	
	public StaticTest(){
		System.out.println("기본생성자");
		a=3;
	}
	
	public void disp() {
		a++;
		b++;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public static void output() {
		System.out.println("static method..");
		//System.out.println("a="+a+"\t b="+b); - 에러 : 스태틱 안에서는 일반 필드는 사용할 수 없다 오로지 스테틱 변수만 가능
	}
	
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		st.calc();
		st.disp();
		System.out.println();
		
		StaticTest st2 = new StaticTest();
		st2.calc();
		st2.disp();
		System.out.println();
		
		StaticTest st3 = new StaticTest();
		st3.calc();
		st3.disp();
		System.out.println();
		
		StaticTest.output(); //static 메소드이므로 클래스명.메소드로 접근가능
		output();  // 클래스명 생략가능
		st.output(); //객체가 있으면 객체로 접근가능
	}
}
