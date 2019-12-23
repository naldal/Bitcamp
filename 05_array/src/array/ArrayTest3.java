package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	int max,min,sum=0;
	
	public static void main(String[] args) throws IOException {
		
		ArrayTest3 t3 = new ArrayTest3();
		
		System.out.print("배열 크기 :");
		int input = Integer.parseInt(br.readLine());
		arr = new int[input];
		
		t3.input();
		t3.big();
		t3.small();
		t3.output();
		
		
	}
	
	public int input() throws IOException {
		sum = 0;
		for(int i=0; i<arr.length ; i++) {
			System.out.print("arr["+i+"] : ");
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		return sum;
	}
	
	public int big() {
		max=arr[0];
		for(int i=0; i<arr.length ; i++) {
			if(max<arr[i])
				max=arr[i];
		}
		return max;
	}
	
	public int small() {
		min=arr[0];
		for(int i=0; i<arr.length ; i++) {
			if(min>arr[i])
				min=arr[i];
		}
		return min;
	}
	
	public void output() {
		System.out.println();
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
	}

}
