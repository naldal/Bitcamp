package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = (int)(Math.random()*9)+2;
		
		String[] ar= new String[size];
		
		System.out.println(ar.toString());
		System.out.println(ar.length);
		
		for(int i=0; i<ar.length ; i++) {
			System.out.println("과일명 입력 : ");
			ar[i] = br.readLine();
		}
		
		for(String str : ar) {
			System.out.println(str);
		}
	}
}
