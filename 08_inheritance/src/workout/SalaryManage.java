package workout;

import java.util.Scanner;

public class SalaryManage {
	Scanner sc = new Scanner(System.in);
	EmployeeDTO[] dto  = new EmployeeDTO[5];
	int cnt=0;

	public void main() {
		while(true) {
			System.out.println("1.등록");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.검색");
			System.out.println("5.종료");
			
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
			System.out.print("이름입력 : ");
			dto[cnt].setName(sc.next());
			System.out.print("직급입력 : ");
			dto[cnt].setDepartment(sc.next());
			System.out.print("기본급입력 : ");
			dto[cnt].setBasepay(sc.nextInt());
			System.out.print("수당입력 : ");
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
		System.out.println("이름 입력 : ");
		String name = sc.next();
	
		for(int i=0; i<cnt; i++) {
			if(dto[i].getName().equals(name)) {
				System.out.println("바꿀 직급");
				dto[i].setDepartment(sc.next());
				System.out.println("바꿀 월급");
				dto[i].setSal(sc.nextInt());
				System.out.println("바꿀 기본급");
				dto[i].setBasepay(sc.nextInt());
			}
		}
	}
	
	public void search() {
		System.out.println("이름입력");
		String name = sc.next();
//		System.out.println("cnt:"+cnt);
		for(int i=0; i<cnt; i++) {
			if(dto[i].getName().equals(name)) {
				System.out.println(dto[i].getName()+" "+dto[i].getDepartment()+" "+dto[i].getBasepay()+" "+dto[i].getTaxrate()+" "+dto[i].getSal());
			}
		}
		
	}
	
	public void exit() {
		System.out.println("프로그램 종료");
		
	}
	
}
