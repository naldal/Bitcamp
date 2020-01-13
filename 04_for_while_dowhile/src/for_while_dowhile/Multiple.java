package for_while_dowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		
		while(true) {
			System.out.print("숫자입력 : ");
			int n = Integer.parseInt(br.readLine());
			int sev=0;
			if(n<0) {
				continue;
			} else if (n>0) {
//				while(sev<7) {
//					sev++;
//					System.out.print(n*sev+" ");
//				}
				for(int i=n; ; ) {
					for(int j=1 ; j<=7; j++) {
						cnt++;
						System.out.print(i*j+" ");
					}
					if(cnt==7) {
						break;
					}
				}
				System.out.println();
			} else {
				break;
			}
		}
	}
}
