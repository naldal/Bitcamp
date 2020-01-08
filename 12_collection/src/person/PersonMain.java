package person;

import java.util.ArrayList;

public class PersonMain {
	
	public void init() {
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 30);
		PersonDTO cc = new PersonDTO("코난", 16);
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int age;
		String name;
		
		PersonDTO[] pd = new PersonDTO[3];
		pd[0] = new PersonDTO("홍길동", 25);
		pd[1] = new PersonDTO("또치", 30);
		pd[2] = new PersonDTO("코난", 16);

		PersonMain main = new PersonMain();
		main.init();

		@SuppressWarnings("rawtypes")
		ArrayList arr = new ArrayList();
		arr.add(pd[0]);
		arr.add(pd[1]);
		arr.add(pd[2]);
		
		for(int i=0; i<arr.size(); i++) {
			name = pd[i].getName();
			age = pd[i].getAge();
			System.out.println(name+"  "+age);
		}
	}
}
