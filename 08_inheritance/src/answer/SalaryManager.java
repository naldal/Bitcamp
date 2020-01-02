package answer;

import java.util.Scanner;

public class SalaryManager {
	EmployeeDTO[] emp = new EmployeeDTO[5];
	Scanner scan = new Scanner(System.in);
	
	public void menu() {
		int choice;
		
		while(true) {
			System.out.println("-------------");
			System.out.println("   1. 등록");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 검색");
			System.out.println("   5. 종료");
			System.out.println("-------------");
			System.out.print("번호 선택 : ");
			choice = scan.nextInt();
			
			if (choice == 1) {
				// 등록 메소드
				insert();
			} else if (choice == 2) {
				// 출력 메소드
				list();
			} else if (choice == 3) {
				// 수정 메소드
				update();
			} else if (choice == 4) {
				// 검색 메소드
				search();
			} else if (choice == 5) {
				break;
			}	
		}
	}

	private void search() {
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("직급 입력 : ");
		String position = scan.next();
		int i;

		for (i = 0; i < emp.length; i++) {
			if (emp[i] != null && emp[i].getName().equals(name) && emp[i].getPosition().equals(position)) {
				System.out.println("======================================================");
				System.out.println("name\tposition\tbasepay\tbenefit\ttaxrate\tsalary");
				System.out.println("======================================================");
				System.out.println(emp[i].toString());

			}
		}
		if (i == 5) {
			System.out.println("찾는 직원이 없습니다.");
		}
		
	}

	private void update() {
		String name, position;
		int i, basePay, benefit;

		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("직급 입력 : ");
		position = scan.next();

		for (i = 0; i < emp.length; i++) {
			if (emp[i] != null && emp[i].getName().equals(name) && emp[i].getPosition().equals(position)) {

				System.out.print("수정 할 직급 입력 : ");
				emp[i].setPosition(scan.next());
				System.out.print("수정 할 기본급 입력 : ");
				emp[i].setBasePay(scan.nextInt());
				System.out.print("수정 할 수당 입력 : ");
				emp[i].setBenefit(scan.nextInt());

				System.out.println("1 row(s) updated");
				break;
			}
		}
		if (i == 5) {
			System.out.println("찾는 직원이 없습니다.");
		}
		
	}

	private void list() {
		System.out.println("======================================================");
		System.out.println("name\tposition\tbasepay\tbenefit\ttaxrate\tsalary");
		System.out.println("======================================================");
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				emp[i].calc();
				System.out.println(emp[i].toString());
			}
		}
		System.out.println("======================================================");
		
	}

	private void insert() {
		String name, position;
		int i, basePay, benefit;

		for (i = 0; i < emp.length; i++) {
			if (emp[i] == null)
				break;
		}
		if(i==emp.length) return;
		
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("직급 입력 : ");
		position = scan.next();
		System.out.print("기본급 입력 : ");
		basePay = scan.nextInt();
		System.out.print("수당 입력 : ");
		benefit = scan.nextInt();
		
		emp[i] = new EmployeeDTO(name, position, basePay, benefit);
	}
}