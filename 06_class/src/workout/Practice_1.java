package workout;

import java.util.Scanner;

public class Practice_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String input, now, change, tmp;
		int cnt=0;

		System.out.println("���ڿ� �Է� :");
		input = sc.next();
		input = input.toLowerCase();
		tmp = input;
		
		System.out.println("���� ���ڿ� �Է� : ");
		now = sc.next();
		
		System.out.println("�ٲ� ���ڿ� �Է� :");
		change = sc.next();
		
		while(true) {
			if(input.indexOf(now)!=-1) {
				cnt++;
				input = input.substring(input.indexOf(now)+now.length()); 
			} else {
				break;
			}
		}
		
		if(tmp.length()<now.length()) {
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");
		} else if (cnt==0){
			System.out.println("ġȯ�Ұ�");
		} else {
			System.out.println(cnt+"�� ġȯ");
			System.out.println(tmp.replace(now, change));
		}
	}
}
