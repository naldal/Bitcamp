package workout;

import java.util.Scanner;

class Practice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		String str, target, change;
		int index=0;
		int count =0;
		
		System.out.print("문자열 입력: ");
		str = sc.next();
		System.out.print("현재 문자열 입력: ");
		target = sc.next();
		System.out.print("바꿀 문자열 입력: ");
		change = sc.next();
		
		if(str.length() < target.length()) { 
			System.out.println("입력한 문자열의 크기가 작습니다.");
			return;
		}
		
		while((index = str.indexOf(target, index))!=-1) {
			System.out.println(index);
			index+=target.length();
			count++;
		}
		
		System.out.println(str.replace(target, change));
		System.out.println(count+"개 치환");
		
		
		
	}
}
