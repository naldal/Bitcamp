package workout;

import java.util.Scanner;

public class MemberMain_1 {
	MemberDTO ar[]=new MemberDTO[5];
	Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		MemberMain_1 mm = new MemberMain_1();
		mm.menu();
		
		
	}
	
	public void menu() {
		while(true) {
			int num;
			System.out.println("*************");
			System.out.println("  1. ����");
			System.out.println("  2. ���");
			System.out.println("  3. ����");
			System.out.println("  4. Ż��");
			System.out.println("  5. ������");
			System.out.println("*************");
			System.out.print("  ��ȣ : ");
			num=sc.nextInt();
			if(num==5) break;
			if(num==1) insert();
			if(num==2) this.list();
			if(num==3) this.update();
			if(num==4) delete();
		}
	}
	
	public void insert() {
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) 
			break;
		}
		
		if(i==5) {
			System.out.println("5�� ������ �� á���ϴ�.");
			return; //�޼ҵ带 �����!
		}
		
		//����
		 System.out.print("�̸� �Է� : ");
		 String name=sc.next();
		 System.out.print("���� �Է� : ");
		 int age=sc.nextInt();
		 System.out.print("�ڵ��� �Է� : ");
		 String phone=sc.next();
		 
		 System.out.print("�ּ� �Է� : ");
		 String address=sc.next();
		 
		 ar[i] = new MemberDTO(name, age, phone, address);
		 
		 int cnt=0;
		 System.out.println("1 row created");
		 
		 for(i=0; i<ar.length; i++) {
			 if(ar[i] == null) 
				cnt++; 
		 }
		 System.out.println(cnt+"�ڸ��� ���ҽ��ϴ�.");
	}
	
	public void list() {
		MemberMain mm= new MemberMain();
		
		System.out.println("name\tAge\tPhone\tAddress");
		for(int i=0; i<ar.length;i++) {
			if(ar[i]!=null) {
				System.out.println(
						ar[i].getName()
						+"\t"+ar[i].getAge()
						+"\t"+ar[i].getPhone()
						+"\t"+ar[i].getAddress());
				}
			}
		}
	
	public void update() {
		System.out.println("�ڵ��� ��ȣ �Է�: ");
		String phone = sc.next();
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null && ar[i].getPhone().equals(phone)) { //�տ��� �������̾�� �ڿ��� ã������ ó������ f�������� �ȵ�
				System.out.println(
						ar[i].getName()
						+"\t"+ar[i].getAge()
						+"\t"+ar[i].getPhone()
						+"\t"+ar[i].getAddress());
				//------------------
				
				System.out.print("���� �� �̸� �Է� : ");
				ar[i].setName(sc.next());
				System.out.print("���� �� �ڵ��� �Է� : ");
				ar[i].setPhone(sc.next());
				System.out.print("���� �� �ּ� �Է� : ");
				ar[i].setAddress(sc.next());
				
				System.out.println("1 row updated");
				 
				System.out.println(
							ar[i].getName()
							+"\t"+ar[i].getAge()
							+"\t"+ar[i].getPhone()
							+"\t"+ar[i].getAddress());
				 System.out.println(i+" row(s) updated");
				 break;
			} //if
		} //for
		
		if(i==5) {
			System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
		}
	}
	
	public void delete(){
		System.out.println("�ڵ��� ��ȣ �Է�: ");
		String phone = sc.next();
		int i;
		
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null && ar[i].getPhone().equals(phone)) {
				ar[i] = null;
				System.out.println("1 row deleted");
				break;
			}
		}
		if(i==5)
			System.out.println("ã�� ȸ���� �����ϴ�");
	}
}
