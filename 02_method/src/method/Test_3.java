package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
�ʸ� �Է¹޾Ƽ� time()���� ��,��,�ʸ� ���Ͽ� ����Ѵ�

[������]
�ʸ� �Է��Ͻÿ� : 3850
1�ð� 4�� 10�� �Դϴ�
 */

public class Test_3 {

	public void time (int sec) {
		int hour = sec/3600;
		int minute = (sec%3600)/60;
		int second = minute%3600%60;
		System.out.println(sec + "�ʴ� " + hour + "�ð� " + minute + "�� " + second + "�� �Դϴ�.");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Test_3 t3 = new Test_3();
		
		System.out.print("�ʸ� �Է��Ͻÿ� :");
		
		int sec = Integer.parseInt(br.readLine());
		t3.time(sec);
		
	}
}
