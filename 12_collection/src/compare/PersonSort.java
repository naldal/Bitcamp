package compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {
	
	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		
		System.out.println("���� �� : ");
		for(String data : ar) {
			System.out.print(data+" ");
		}
		System.out.println();
		
		Arrays.sort(ar);
		System.out.println("���� �� : ");
		for(String data : ar) {
			System.out.print(data+" ");
		}
		System.out.println("\n");
		
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 30);
		PersonDTO cc = new PersonDTO("�ڳ�", 16);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		System.out.println("���� �� : "+list);
		Collections.sort(list);
		System.out.println("���� �� :"+list);
		System.out.println();

		
		//���ı����� �̸����� ���Ӱ� ����
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() { //�͸��̹Ƿ� new�� �͸�Ŭ������ �ǹ���
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) {
				//��������
				return dto1.getName().compareTo(dto2.getName());
				
				//��������
				//return dto2.getName().compareTo(dto1.getName());
				//Ȥ��
				//return dto2.getName().compareTo(dto1.getName())*-1;
			}
		};
		
		System.out.println("�̸����� ���Ӱ� ����");
		Collections.sort(list, com);
		System.out.println(list);
	}	
}





