package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice4 {

//	���� ����
//	10~99 ������ ������ 2��(a,b) �߻��Ͽ� ���� ���ߴ� ����
//	�������� �� 5������ �����Ѵ�
//	1������ ���� 20���� ���
//	���� Ʋ���� ��ȸ�� 1�� �� �����Ѵ�
//	[������]
//			[1] 25 + 36 = 45
//			Ʋ�ȴ�
//			[1] 25 + 36 = 61
//			������
//
//			[2] 78 + 10 = 100
//			Ʋ�ȴ�
//			[2] 78 + 10 = 95
//			Ʋ�ȴ�...���� :
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
			
			++q; //���� ��ȣ
			value = a+b;
			System.out.println(value);
			
			for(int j=1; j<=3; j++) {
				System.out.print("["+q+"]"+a+"+"+b+"=");
				input = Integer.parseInt(br.readLine());
				
				if(input==value) {
					System.out.println("�����Դϴ�.");
					total+=20;
					win++;
						break;
				} else if(input!=value) {
					++lose;  //Ʋ��Ƚ�� 2�� �������
					if(lose>=2) {
						System.out.println("Ʋ�Ƚ��ϴ�. ����: "+value);
						break;
					} else {
						System.out.println("Ʋ�Ƚ��ϴ�.");
						continue;
					}
				}
			}
			if(q>4) {
				System.out.println("����� ��"+win+"������ ���־"+total+"�� �Դϴ�.");
								
				while(true) {
					System.out.println("����Ͻðڽ��ϱ�? (y/n)");
					yn = br.readLine();
					
					if(yn.equals("Y")||yn.equals("y")) {
						q=0;
						break;
					} else if (yn.equals("N")||yn.equals("n")) {
						System.out.println("�ý��� ����");
						flag=true;
						break;
					} else {
						System.out.println("�ٽ� �Է��ϼ���");
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
