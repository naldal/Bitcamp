package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGame {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int usrNum;
		int computRan = (int)(Math.random()*100)+1;
		int cnt=0;
		
		while(true) {
			System.out.print("�����Է� : ");
			usrNum = Integer.parseInt(br.readLine());
			cnt++;
			if(usrNum > computRan) {
				System.out.println(usrNum+"���� �۽��ϴ�.");
			} else if (usrNum < computRan) {
				System.out.println(usrNum+"���� Ů�ϴ�.");
			} else {
				System.out.println("������"+cnt+"���� ���߼̽��ϴ�.");
				break;
			}
		}
	}
}
