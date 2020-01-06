package nested;

public class AbstractMain {

	public static void main(String[] args) {
		AbstractTest at = new AbstractTest() { //익명 이너 클래스. 대신 오버라이드 해준다
			
			public void setName(String name) {this.name = name;}

		}; 
		
		InterA aa = new InterA() {	//굳이 extends implements할 필요 없이 자리에서 바로 생성이 가능하다
		//여기에서 new는 InterA를 생성하는 것이 아니라 익명클래스 {}를 생성하는 것
			public void aa() {} 
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {}; //추상메서드가 없기 때문에 선택적으로 오버라이드 가능. 아예 안해도 됨
	}
}
