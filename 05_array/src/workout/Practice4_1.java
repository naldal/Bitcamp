package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4_1 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] com = new int[3];
		int[] user = new int[3];
		int strike, ball;
		String yn;
		String inputStr;
		
		do {
			System.out.println("������ �����Ͻðڽ��ϱ�?(Y/N) : ");
			yn=br.readLine();
		}while(!yn.equals("Y")&&!yn.equals("y")&&!yn.equals("N")&&!yn.equals("n"));

		if(yn.equals("Y")||yn.equals("y")) {
			System.out.println();
			System.out.println("������ �����մϴ�.");
			
			//�����߻�
			for(int i=0; i<com.length; i++) {
				com[i] = (int)(Math.random()*9)+1;
				
				//�ߺ�üũ
				for(int j=0; j<i; j++) {
					if(com[i]==com[j]) {
						i--;
						break;
					}
				}
			}
			System.out.println("0"+com[0]+"1"+com[1]+"2"+com[2]);
			
			
			//�Է�
			while(true) {
				System.out.println("���� �Է� : ");
				inputStr = br.readLine();
				
				for(int i=0; i<user.length; i++) {
					user[i] = inputStr.charAt(i)-48;
				}
				
				//��
				strike=ball=0;
				for(int i=0; i<com.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[i]==user[i]) {
							if(i==j)
								strike++;
							else
								ball++;
						}
					}
				}
				System.out.println(strike+"��Ʈ����ũ  "+ball+"��");
				if(strike==3)
					break;
			}//while
		}
	}
}

