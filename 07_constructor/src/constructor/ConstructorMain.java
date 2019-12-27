package constructor;

class ConstructorTest{
	private String name;
	private int age;
	
	public ConstructorTest() {
		System.out.println("기본생성자");
	}
	
	public ConstructorTest(String name) {
		this.name=name;
	}
	
	public ConstructorTest(int age) {
		this.age=age;
	}										//생성자 오버로드
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

}

//---------
public class ConstructorMain {

	public static void main(String[] args) {
		ConstructorTest aa = new ConstructorTest();
		System.out.println("이름 ="+aa.getName()+"\t 나이="+aa.getAge());
		System.out.println();
		
		ConstructorTest bb = new ConstructorTest("홍길동");
		System.out.println("이름 ="+bb.getName()+"\t 나이="+bb.getAge());
		System.out.println();
		
		ConstructorTest cc = new ConstructorTest(25);
		System.out.println("이름 ="+cc.getName()+"\t 나이="+cc.getAge());
		System.out.println();
	}
}
