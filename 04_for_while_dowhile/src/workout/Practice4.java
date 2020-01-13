package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, value, input, lose = 0, win=0;
		int total=0;
		int q=0;
		String yn="";
		boolean flag = false;
		
		
		LOOP:while(true) {
			a=(int)(Math.random()*99)+11;
			b=(int)(Math.random()*99)+11;
			
			++q; //문제 번호
			value = a+b;
			System.out.println(value);
			
			for(int j=1; j<=3; j++) {
				System.out.print("["+q+"]"+a+"+"+b+"=");
				input = Integer.parseInt(br.readLine());
				
				if(input==value) {
					System.out.println("정답입니다.");
					total+=20;
					win++;
						break;
				} else if(input!=value) {
					++lose;  //틀린횟수 2면 정답공개
					if(lose>=2) {
						System.out.println("틀렸습니다. 정답: "+value);
						break;
					} else {
						System.out.println("틀렸습니다.");
						continue;
					}
				}
			}
			if(q>4) {
				System.out.println("당신은 총"+win+"문제를 맟주어서"+total+"점 입니다.");
								
				while(true) {
					System.out.println("계속하시겠습니까? (y/n)");
					yn = br.readLine();
					
					if(yn.equals("Y")||yn.equals("y")) {
						q=0;
						break;
					} else if (yn.equals("N")||yn.equals("n")) {
						System.out.println("시스템 종료");
						break LOOP; //continue LOOP도 됨;
					} else {
						System.out.println("다시 입력하세요");
						continue;
					}
				}
			}
		}//while
	}
}
