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
			System.out.print("����(1), ����(2), ��(3) �� ��ȣ �Է� : ");
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
				strCom="����";
			} else if(comInput==2) {
				strCom="����";
			} else {
				strCom="��";
			}
			
			if(usrInput==1) {
				strUsr="����";
			} else if(usrInput==2) {
				strUsr="����";
			} else {
				strUsr="��";
			}
			
			System.out.println("�� ��: "+strUsr);
			System.out.println("��� ��: "+strCom);
			
			System.out.println("�� �ҷ�(Y/N)");
			askAgain = br.readLine();
			if(askAgain.equals("Y")) {
				
			} else if(askAgain.equals("N")) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		}
	}
}
