package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("10���� �Է� : ");
			int dec = Integer.parseInt(br.readLine());
			
			if(dec<0) {
				continue;
			} else if (dec==0) {
				break;
			} else {
				String tmp="";
				String tmp2="";
				int cnt=0;
				
				while(true) {
					int portion = dec/2;	
					int remain = dec%2;		
					
					tmp += remain;		
					dec = portion;		
					tmp2 = tmp;			
					
					if(portion == 1) {
						tmp2 += portion;
						break;		
					}
				}
		
				int length = tmp2.length();
				
				char[] bin = new char[length];
				
				for(int i=0; i<bin.length; i++) {
					bin[i]=tmp2.charAt(--length);
					
					System.out.print(bin[i]);
					++cnt;
					if(cnt%4==0) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
