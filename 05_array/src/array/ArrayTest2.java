package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = (int)(Math.random()*4)+2;
		
		String[] ar= new String[size];
		
		System.out.println(ar.toString());
		System.out.println(ar.length);
		
		for(int i=0; i<ar.length ; i++) {
			System.out.print("���ϸ� �Է� : ");
			ar[i] = br.readLine();
		}
			
		for(String data : ar) {
			System.out.print(data);
			System.out.println("ù��° ���� ="+data.charAt(0));
			System.out.println("���ڿ����� ="+data.length());
			System.out.println();
		}
	}
}
