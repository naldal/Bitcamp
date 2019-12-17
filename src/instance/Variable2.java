package instance;

public class Variable2 {
	//필드변수
	int a;//초기값 0, static 없음 -> 인스턴스변수 -> 객체생성 필요
	static int b; // static 있음 -> 클래스변수 -> 객체생성 필요없음 바로 끌어다 쓰면 됨
	//int a=5 불가능. 설정만 가능하고 선언 불가능
	String str;
	
	public static void main(String[] args) {
		Variable2 var2 = new Variable2();
		int a = 10; //local variable 지역변수, 쓰레기값 초기화(선언)
		System.out.println("지역 a="+a);
		System.out.println("필드 a="+var2.a);
		System.out.println("필드 b="+b); //Variable2.b 와 같음
		System.out.println("필드 str="+var2.str);
	}
}
