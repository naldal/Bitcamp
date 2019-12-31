package workout;

import java.util.Scanner;

public class SalaryManage {
	Scanner sc = new Scanner(System.in);
	EmployeeDTO[] dto  = new EmployeeDTO[5];
	int cnt=0;

	public void main() {
		while(true) {
			System.out.println("1.���");
			System.out.println("2.���");
			System.out.println("3.����");
			System.out.println("4.�˻�");
			System.out.println("5.����");
			
			int input = sc.nextInt();
			
			if(input==1) {
				insert();
			} else if(input==2) {
				output();
			} else if(input==3) {
				fix();
			} else if(input==4) {
				search();
			} else {
				exit();
			}
		}
	}
	
	public void insert() {
			dto[cnt] = new EmployeeDTO();
			System.out.print("�̸��Է� : ");
			dto[cnt].setName(sc.next());
			System.out.print("�����Է� : ");
			dto[cnt].setDepartment(sc.next());
			System.out.print("�⺻���Է� : ");
			dto[cnt].setBasepay(sc.nextInt());
			System.out.print("�����Է� : ");
			dto[cnt].setBenefit(sc.nextInt());
			++this.cnt;
	} //insert
	
	public void output() {
		for(int i=0; i<cnt; i++) {
			System.out.println(dto[i].getName()+"\t"+dto[i].getDepartment()+
					"\t"+dto[i].getBasepay()+"\t"+dto[i].getBenefit()+"\t"+dto[i].getTaxrate()+"\t"+dto[i].getSal());
		}
	}
	
	public void fix() {
		System.out.println("�̸� �Է� : ");
		String name = sc.next();
	
		for(int i=0; i<cnt; i++) {
			if(dto[i].getName().equals(name)) {
				System.out.println("�ٲ� ����");
				dto[i].setDepartment(sc.next());
				System.out.println("�ٲ� ����");
				dto[i].setSal(sc.nextInt());
				System.out.println("�ٲ� �⺻��");
				dto[i].setBasepay(sc.nextInt());
			}
		}
	}
	
	public void search() {
		System.out.println("�̸��Է�");
		String name = sc.next();
//		System.out.println("cnt:"+cnt);
		for(int i=0; i<cnt; i++) {
			if(dto[i].getName().equals(name)) {
				System.out.println(dto[i].getName()+" "+dto[i].getDepartment()+" "+dto[i].getBasepay()+" "+dto[i].getTaxrate()+" "+dto[i].getSal());
			}
		}
		
	}
	
	public void exit() {
		System.out.println("���α׷� ����");
		
	}
	
}
