package nested;

public class Outer { //내부 클래스는 외부클래스에 접근할 수 있지만(오로지 같은 클래스 안에서만), 외부클래스는 내부클래스를 포함할 수 없다. (상속관계와 다르다) / 다만 객체생성하면 접근이 가능하다.

	private String name;
	
	public void output() {
		// System.out.println("이름="+name+"\t 나이="+age); 외부클래스는 내부클래스에 접근하지 못함
		System.out.println("이름="+name+"\t 나이="+new Inner().age); //객체생성시 가능
	}
	
	class Inner {	//중첩의 목적 : 동떨어진 클래스끼리의 setter/getter을 이용한 필드멤버 접근의 불편함을 줄이기 위해
		private int age;
		
		public void disp() {
			System.out.println("이름="+Outer.this.name+"\t 나이="+age); //외부클래스의 멤버 명시하는 법
		}
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer(); //Inner 클래스까지 만들지 않음 자기껏만 만듦
		outer.name = "홍길동";
		
		System.out.println("이름="+outer.name);
		
		Outer.Inner inner = outer.new Inner();
		inner.age=25;
		inner.disp();
		
		Outer.Inner inner2 = outer.new Inner();
		inner2.age = 30;
		inner2.disp();
		
		Outer.Inner inner3 = new Outer().new Inner();
		inner3.age =35;
		inner3.disp();
		
	}
}
