package inheritance;

public class ChildTest extends SuperTest {

	private String name;
	private int age;

	public ChildTest() {
		System.out.println("SubTest 기본 생성자");
	}

	public ChildTest(String name, int age, double weight, double height) {
		super(weight, height); // 부모의 인자 두개의 생성자 호출 : 반드시 첫째줄에 적어야함

		System.out.println("ChildTest 생성자");
		this.name = name;
		this.age = age;
		// super.weight=weight; //this.weight = weight; super 있으면 필요없음!
		// super.height=height; //this.height = height;
	}

	public void disp() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 =" + weight);
		System.out.println("키 =" + height);
	}

	public static void main(String[] args) {
		ChildTest aa = new ChildTest("홍길동", 25, 79.5, 185.3);
		aa.disp();
		System.out.println();

		SuperTest bb = new ChildTest("또치", 16, 52.3, 162.3);
		bb.disp();
	}
}
