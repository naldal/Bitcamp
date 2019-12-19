package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String askAgain;
		String strUsr;
		String strCom;
		
		while(true) {
			System.out.print("가위(1), 바위(2), 보(3) 중 번호 입력 : ");
			int usrInput = Integer.parseInt(br.readLine());
			int comInput = (int)(Math.random()*3)+1;
			
			if(comInput-usrInput==0) {
				System.out.println("You Draw!");
			} else if(comInput-usrInput==-1 || comInput-usrInput==2) {
				System.out.println("You Win!");
			} else if(comInput-usrInput==1 || comInput-usrInput==-2) {
				System.out.println("You Lose!");
			}
			
			if(comInput==1) {
				strCom="가위";
			} else if(comInput==2) {
				strCom="바위";
			} else {
				strCom="보";
			}
			
			if(usrInput==1) {
				strUsr="가위";
			} else if(usrInput==2) {
				strUsr="바위";
			} else {
				strUsr="보";
			}
			
			System.out.println("내 값: "+strUsr);
			System.out.println("상대 값: "+strCom);
			
			System.out.println("또 할래(Y/N)");
			askAgain = br.readLine();
			if(askAgain.equals("Y")) {
				
			} else if(askAgain.equals("N")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	}
}
