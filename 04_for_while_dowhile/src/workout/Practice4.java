package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {

//	덧셈 공부
//	10~99 사이의 난수를 2개(a,b) 발생하여 합을 맞추는 게임
//	문제수는 총 5문제를 제공한다
//	1문제당 점수 20점씩 계산
//	만약 틀리면 기회를 1번 더 제공한다
//	[실행결과]
//			[1] 25 + 36 = 45
//			틀렸다
//			[1] 25 + 36 = 61
//			딩동뎅
//
//			[2] 78 + 10 = 100
//			틀렸다
//			[2] 78 + 10 = 95
//			틀렸다...정답 :
//			...
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, value, input, lose = 0, win=0;
		int total=0;
		int q=0;
		String yn="";
		boolean flag = false;
		
		
		while(true) {
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
						flag=true;
						break;
					} else {
						System.out.println("다시 입력하세요");
						continue;
					}
				}
			}
			if(flag==true) {
				break;
			}
		}//while
	}
}
