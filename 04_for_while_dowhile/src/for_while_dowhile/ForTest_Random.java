package for_while_dowhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ForTest_Random {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("A~Z 무작위로 100개를 출력하시오 ");
		int cnt=0;
		for(int i=1 ; i<=100 ; i++ ) {
			
			int ch = (int) (Math.random()*26+65);
			if(ch=='A') { 
				cnt++;
			}
			System.out.print((char)ch+" ");
			
			if(i%10==0) {
				System.out.println();
			}
		}
		System.out.println("A의 갯수:"+cnt);
	}
}
