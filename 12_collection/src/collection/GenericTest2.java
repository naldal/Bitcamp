package collection;

public class GenericTest2<T> {

	private T a;
	
	public GenericTest2(T a) {
		this.a = a;
	}
	
	public void setA(T a) {
		this.a =a;
	}
	
	public T getA() {
		return a;
	}
	
	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("홍길동");
		//aa.setA("홍길동"); error 생성자를 통해서 집어넣어야함
		//String name = aa.getA(); error : 현재 aa.getA는 오브젝트 타입임
		String name = (String)aa.getA();
		System.out.println("이름 = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer)bb.getA();
		
		System.out.println(age);
	}
}
