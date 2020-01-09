package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukService {
	Scanner sc = new Scanner(System.in);
	ArrayList<SungJukDTO> arraylist = new ArrayList<SungJukDTO>();
	
	public void menu() {
		
		int input;
		while(true) {
			System.out.println("*************");
			System.out.println("    1.�Է�");
			System.out.println("    2.���");
			System.out.println("    3.�˻�");
			System.out.println("    4.����");
			System.out.println("    5.����");
			System.out.println("    6.��");
			System.out.println("*************");
			
			System.out.println("��ȣ ���� : ");
			input=sc.nextInt();
			if(input==6) {
				break;
			} else if (input==1) {
				insertArticle();
			} else if (input==2) {
				display();
			} else if (input==3) {
				searchArticle();
			} else if (input==4) {
				deleteArticle();
			} else if (input==5) {
				sortArticle();
			}
		}
	} //menu()
	
	public ArrayList<SungJukDTO> insertArticle(){
		System.out.println("�л���ȣ�� �Է��Ͻÿ�");
		int num = sc.nextInt();
		System.out.println("�̸��� �Է��Ͻÿ�");
		String name = sc.next();
		System.out.println("������� �Է��Ͻÿ�");
		int kor = sc.nextInt();
		System.out.println("������� �Է��Ͻÿ�");
		int eng = sc.nextInt();
		System.out.println("���м����� �Է��Ͻÿ�");
		int math = sc.nextInt();
		
		SungJukDTO dto = new SungJukDTO();
		dto = new SungJukDTO(num, name, kor, eng, math);
		dto.setAvg();
		dto.setTot();
		arraylist.add(dto);
		
		System.out.println("�Է� �Ϸ�!!");
		return arraylist;
	} //putIn()
	
	public void display() {
		System.out.println("��ȣ \t �̸� \t ���� \t ���� \t ���� \t ��� \t ����");
		for(SungJukDTO dto : arraylist) {
			System.out.println(dto);
		}
	}
	
	public void searchArticle() {
		System.out.println("�˻� �� �̸� �Է� :");
		String name = sc.next();
		int count=0;
	
		for(SungJukDTO dto : arraylist) {
			if(dto.getName().equals(name)){
				System.out.println(dto);
				count++;
			} 

			if(count==0) System.out.println("ã�� �̸��� �����ϴ�.");
		}
	} //3
	
	public void deleteArticle() {
		System.out.println("���� �� �̸� �Է� :");
		String name = sc.next();
		int count=0;
		
		Iterator<SungJukDTO> it = arraylist.iterator();
		while(it.hasNext()) {
			SungJukDTO dto = it.next();
			if(dto.getName().equals(name)) {
				it.remove(); //it.next()�� ��ȯ�� ���� �����
				count++;
			}
			
			
		}
		System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
	}//4
	
	public void sortArticle() {
		System.out.println("1. �̸����� ��������");
		System.out.println("2. �������� ��������");
		int input = sc.nextInt();
		if(input==2) {
			Collections.sort(arraylist);
			System.out.println("��ȣ \t �̸� \t ���� \t ���� \t ���� \t ��� \t ����");
			for(SungJukDTO dto : arraylist) {
				System.out.println(dto);
			}
		} else if(input==1) {
			Comparator<SungJukDTO> newdto = new Comparator<SungJukDTO>() {
				
				@Override
				public int compare(SungJukDTO dto1, SungJukDTO dto2) { //��������. �����ٲٸ� ��������.
					return dto1.getName().compareTo(dto2.getName());
				}
			};
			Collections.sort(arraylist, newdto);
			System.out.println("��ȣ \t �̸� \t ���� \t ���� \t ���� \t ��� \t ����");
			for(SungJukDTO dto : arraylist) {
				System.out.println(dto);
			}
		}
	}
}