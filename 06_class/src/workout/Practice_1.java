package workout;

import java.util.Scanner;

public class Practice_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String input, now, change, tmp;
		int cnt=0;

		System.out.println("문자열 입력 :");
		input = sc.next();
		input = input.toLowerCase();
		tmp = input;
		
		System.out.println("현재 문자열 입력 : ");
		now = sc.next();
		
		System.out.println("바꿀 문자열 입력 :");
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
			System.out.println("입력한 문자열의 크기가 작습니다");
		} else if (cnt==0){
			System.out.println("치환불가");
		} else {
			System.out.println(cnt+"번 치환");
			System.out.println(tmp.replace(now, change));
		}
	}
}
