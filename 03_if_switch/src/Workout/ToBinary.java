package Workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToBinary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ToBinary tb = new ToBinary();
		
		System.out.println("2진수입력");
		int inputValue = Integer.parseInt(br.readLine());
		
		String tmp = tb.toB(inputValue);
		int len = tmp.length();
		String fin = "";
		
		for(int i=len-1 ; i>=0 ; i--) {
			char ftmp = tmp.charAt(i);
			String a = Character.toString(ftmp);
			fin += a;
		}
		
		System.out.println(fin);
		
	}
	
	public String toB(int second) {
		String tmp="";
		String tmp2="";
		
		while(true) {
			int portion = second/2;
			int remain = second%2;
			
			tmp += remain;
			second = portion;
			tmp2 = tmp;
			
			if(portion == 1) {
				tmp2 += portion;
				break;
			}
		}
		return tmp2;
	}
	
}
