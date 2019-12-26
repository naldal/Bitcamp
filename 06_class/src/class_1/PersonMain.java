package class_1;

/*
 object oriented programming
- 모의실험을 목적으로 사용
- 실제 사물의 속성(데이터)과 기능(메소드)을 정의하여 가상세계를 구현
- 모의실험을 통해 많은 시간과 노력을 절감
- 객체지향이론은 캡슐화, 상속, 추상화 개념
- 코드의 재사용이 높다
- 유지보수가 용이하다
- 캡슐화, 상속, 다형성의 특징
*/

class Person {

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setData(String name, int age) {
		this.name=name;
		this.age=age;
	}
}

//----------------------------------------------

public class PersonMain {

	public static void main(String[] args) {
		Person aa;
		aa = new Person();
		System.out.println(aa.toString());
			
		aa.setName("홍길동");
		aa.setAge(25);
		System.out.println("이름="+aa.getName()+"\t 나이="+aa.getAge());
		
		Person bb = new Person();
		System.out.println(bb.toString());
		bb.setAge(16);
		bb.setName("코난");
		System.out.println("이름="+bb.getName()+"\t 나이="+bb.getAge());
		
		Person cc = new Person();
		System.out.println(cc.toString());
		cc.setData("또치", 30);
		System.out.println("이름="+cc.getName()+"\t 나이="+cc.getAge());
		System.out.println();
	}
}

//int aa;		정수형 변수
//double aa;	실수형 변수
//char aa;	문자형 변수
//
//Person aa;	객체(주솟값 쥐고있음)
