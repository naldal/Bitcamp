package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] com = new int[3];
		int[] user = new int[3];
		int strike=0;
		int ball=0;
		
		while(true) {
			System.out.println("게임을 시작하시겠습니까?");
			String yn = br.readLine();
			
			if(yn.equals("N") || yn.equals("n")) {
				break;
			} else if(yn.equals("Y") || yn.equals("y")) {
				System.out.println("게임을 시작합니다.");
				
				//com 난수생성
				for(int i=0; i<com.length; i++) {
					int comRan = (int)(Math.random()*9)+1;
					com[i]=comRan;
					
					for(int j=0; j<com.length; j++) {
						if(com[i]==com[j]&&i!=j) {
							System.out.println("컴퓨터에게 중복된 숫자발견! 다시 난수를 생성합니다.");
							i=0;
							break;
						}
					}
				}
				for(int e : com) {
					System.out.print(e);
					System.out.print(" ");
				}
				
				//user 배열값 생성
				System.out.println("숫자입력");
				String input=br.readLine().trim();
				for(int i=0; i<input.length(); i++) {
					user[i]=(int)input.charAt(i)-48;
				}
				
				for(int usr=0; usr<user.length; usr++) {
					for(int cpt=0; cpt<com.length; cpt++) {
						if(user[usr]==com[cpt] && usr==cpt) {
							++strike;
						} else if(user[usr]==com[cpt] && usr!=cpt) {
							++ball;
						}
					}
				}
				System.out.println(strike+"스트라이크 "+ball+"볼");
				break;
				
			} else {
				continue;
			}
			
		} //while
	}
}
