package user.main;

import java.util.Scanner;

public class UserMain {
	Scanner sc = new Scanner(System.in);
	UserAction userAction = null;
	
	public void menu() {
		while (true) {
			System.out.println("***********");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.검색");
			System.out.println("6.종료");
			System.out.println("***********");
			
			int input = sc.nextInt();
			
			if (input == 1) {
				userAction = new UserInsertAction();
				
			} else if (input == 2) {				
				userAction = new UserSelectAction();
				
			} else if (input == 3) {
				userAction = new UserUpdateAction();
				
			} else if (input == 4) {
				userAction = new UserDeleteAction();
				
			} else if (input == 5) {
				userAction = new UserSearchAction();
				
			} else if(input == 6) {
				break;
			}
			
			userAction.execute();
		}
	}

	public static void main(String[] args) {
		new UserMain().menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
