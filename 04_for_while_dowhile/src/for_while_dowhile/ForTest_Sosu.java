package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest_Sosu {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		int num;
		
		while(true) {
			System.out.println("���� �Է�");
			num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				break;
			}
			
			for(int i=1; i<num; i++) {
				if(num%i==0) {
					cnt++;
			}
		
			if(cnt!=2) {
				System.out.println(num+"�� �Ҽ��� �ƴϴ�");
					break;
			} else {
				System.out.println(num+"�� �Ҽ��̴�");
					break;
			}
		} //while
		System.out.println("���α׷� ����");
				
	}
}
}