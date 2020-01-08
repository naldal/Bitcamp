package person;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMain_2{
	
	public ArrayList<PersonDTO> init() {
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 30);
		PersonDTO cc = new PersonDTO("코난", 16);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list;
	}

	public static void main(String[] args) {
		PersonMain_2 main = new PersonMain_2();
		ArrayList<PersonDTO> list = main.init();
	
		for(int i=0; i<list.size(); i++) {
			System.out.println("이름 :"+list.get(i).getName()
					+"\t나이 : "+list.get(i).getAge());
		}
		
		System.out.println("===================================");
		//혹은
		for(PersonDTO dto : list) {
			System.out.println("이름 :"+dto.getName()
					+"\t나이 : "+dto.getAge());
		}
		
		System.out.println("===================================");
		//혹은
		for(PersonDTO dto : list) {
			System.out.println(dto);	//toString 생략
		}
		
		System.out.println("===================================");
		//혹은
		Iterator<PersonDTO> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}