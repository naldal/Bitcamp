package person;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonMain_2{
	
	public ArrayList<PersonDTO> init() {
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 30);
		PersonDTO cc = new PersonDTO("�ڳ�", 16);
		
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
			System.out.println("�̸� :"+list.get(i).getName()
					+"\t���� : "+list.get(i).getAge());
		}
		
		System.out.println("===================================");
		//Ȥ��
		for(PersonDTO dto : list) {
			System.out.println("�̸� :"+dto.getName()
					+"\t���� : "+dto.getAge());
		}
		
		System.out.println("===================================");
		//Ȥ��
		for(PersonDTO dto : list) {
			System.out.println(dto);	//toString ����
		}
		
		System.out.println("===================================");
		//Ȥ��
		Iterator<PersonDTO> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}