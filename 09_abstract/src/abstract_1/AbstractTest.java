package abstract_1;

public abstract class AbstractTest { //POJO(plain old java object) == 누구에게도 상속받지 않는 단순한 클래스 + setter getter
	String name;
	
//	public void setName(String name){ //구현
//		this.name = name;
//	}
	
	public abstract void setName(String name); //추상메서드
	//추상클래스는 추상메소드가 무조건 하나 이상 있지만 일반메서드가 있을 수도 있다.
	public String getName() {
		return name;
	}
	
	
}
