package workout;

import java.util.Scanner;

class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		String str, target, change;
		int index=0;
		int count =0;
		
		System.out.print("���ڿ� �Է�: ");
		str = sc.next();
		System.out.print("���� ���ڿ� �Է�: ");
		target = sc.next();
		System.out.print("�ٲ� ���ڿ� �Է�: ");
		change = sc.next();
		
		if(str.length() < target.length()) { 
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
			return;
		}
		
		while((index = str.indexOf(target, index))!=-1) {
			System.out.println(index);
			index+=target.length();
			count++;
		}
		
		System.out.println(str.replace(target, change));
		System.out.println(count+"�� ġȯ");
		
		
		
	}
}
