package workout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice3 {
	//input() -난수발생 중복된 숫자가 나오면 다시 발생
	//output() -  난수가 몇개나왔는지 출력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Practice3 p3 = new Practice3();
		int[] arr = new int[6];
		
		System.out.println("현금 입력: ");
		int money = Integer.parseInt(br.readLine());

	
		for(int i=1; i<=money/1000; i++) {
			p3.input(arr);
			//Arrays.sort(arr);
			p3.sort(arr);
			p3.output(arr);
			if(i%5==0)	System.out.println();
		}
	}
	
	public void sort(int[] arr) {
		int tmp;
		//Selection Sort
		for(int i=0; i<arr.length-1; i++) {
			for(int j=1+i; j<arr.length; j++) {
				if(arr[i]<arr[j]) { //
					tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
	}

	public void input(int[] arr) {

		for(int i=0; i<arr.length ; i++) {
			int random = (int)(Math.random()*45)+1;
			arr[i] = random;
  
			for(int j=0; j<i; j++) {
				if(arr[j]==arr[i]) {
					i--;
					break;
				}
			}
		}
	}
	
	public void output(int[] arr) {
		for(int e : arr)
			System.out.print(String.format("%5d",e));
		System.out.println();
		
	}

}
