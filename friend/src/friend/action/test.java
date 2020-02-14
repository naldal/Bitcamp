package friend.action;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
        int a = sc.nextInt();
        System.out.print("세로 : ");
        int b = sc.nextInt();
        
        for(int i=1; i<=b; i++) {
        	for(int j=1; j<=a; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}
}
