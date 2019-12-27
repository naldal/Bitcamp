package workout;

import java.util.Scanner;

public class MemberMain {
	static Scanner sc = new Scanner(System.in);
	static MemberDTO[] dto = new MemberDTO[5];
	static int cnt=1;
	
	public static void main(String[] args) {
		MemberMain mm = new MemberMain();
		int inputInt;
		
		while(true) {
			System.out.println("***********");
			System.out.println("  1. ����");
			System.out.println("  2. ���");
			System.out.println("  3. ����");
			System.out.println("  4. Ż��");
			System.out.println("  5. ������");
			System.out.println("***********");
			System.out.print("��ȣ : ");
			inputInt = sc.nextInt();
			
			if(inputInt==5) {
				break;
			} else if(inputInt==1) {
				mm.insert();
			} else if(inputInt==2) {
				mm.list();
			} else if(inputInt==3) {
				mm.update();
			} else if(inputInt==4) {
				mm.delete();
			}
		}
	}//main
	
	public void insert() {
		System.out.print("�̸� �Է�: ");
		String tmpName = sc.next();
		System.out.print("���� �Է�: ");
		int tmpAge = sc.nextInt();
		System.out.print("�ڵ��� �Է�: ");
		String tmpPhone = sc.next();
		System.out.print("�ּ� �Է�: ");
		String tmpAddress = sc.next();
		
		MemberDTO dtoInsert = new MemberDTO(tmpName, tmpAge, tmpPhone, tmpAddress);
		
		PHONE: for(int i=cnt-1; i<cnt; i++) {
				if(cnt>5) {
					System.out.println("5���� ������ �� á���ϴ�...");
					continue;
				} else {
					for(int j=0; j<i; j++) {
						if(dto[j].getPhone().equals(tmpPhone)){
							System.out.println("�̹� �ش� ��ȣ�� �ֽ��ϴ�.");
							break PHONE;
						}
					}
				}
			dto[i] = dtoInsert;
			System.out.println("1 row created");
			System.out.println(dto.length-cnt+"�ڸ� ���ҽ��ϴ�");
			cnt++;
			break;
		}
	}
	
	
	public void list() { //��üȸ��
		System.out.println("�̸�\t����\t�ڵ���\t�ּ�");
		for(int i=0; i<cnt-1; i++) {
			System.out.print(dto[i].getName()+"\t"+dto[i].getAge()
					+"\t"+dto[i].getPhone()+"\t"+dto[i].getAddress());
			System.out.println();
		}
		System.out.println();
	}
	
	public MemberDTO update() {
		System.out.println("�ڵ��� ��ȣ �Է� :");
		String tmpUpdate = sc.next();
		int i;
		//MemberDTO dtoUpdate = new MemberDTO();
		
		for(i=0; i<cnt-1; i++) {
			if(dto[i].getPhone().equals(tmpUpdate)) {
				System.out.println(dto[i].getName()+"\t"+
						dto[i].getAge()+"\t"+
						dto[i].getPhone()+"\t"+
						dto[i].getAddress());
				
				System.out.println("���� �� �̸� �Է� : ");
				tmpUpdate = sc.next();
				dto[i].setName(tmpUpdate);
				
				System.out.println("���� �� �ڵ��� �Է�");
				tmpUpdate = sc.next();
				dto[i].setPhone(tmpUpdate);
				
				System.out.println("���� �� �ּ� �Է�");
				tmpUpdate = sc.next();
				dto[i].setAddress(tmpUpdate);
				
			} else {
				System.out.println("ã�� ȸ���� �����ϴ�.");
			}
		}
		return dto[i];
	}
	
	public void delete() {
		System.out.println("�ڵ��� ��ȣ �Է� :");
		String tmpDelete = sc.next();
		int i;
		for(i=0; i<cnt; i++) {
			if(dto[i].getPhone().equals(tmpDelete)) {
				dto[i]=dto[i+1];
				cnt--;
				System.out.println("Ż��Ǽ̽��ϴ�.");
			} else {
				System.out.println("ã�� ȸ���� ����");
			}
		}
	}
}
