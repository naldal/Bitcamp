package abstract_1;

public class AbstarctMain extends AbstractTest{


	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); error: 추상클래스는 new하지 못한다(메모리에 생성하지 못한다).
		AbstractTest at = new AbstarctMain();
		at.setName("홍길동"); //호출
		System.out.println("이름="+at.getName());
	}
}
