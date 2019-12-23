package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest4 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		ArrayTest4 t4 = new ArrayTest4();	
		boolean[] ar = new boolean[5];
	
		ROOP:while(true) {
			t4.menu();
			int num = Integer.parseInt(br.readLine());
			
			switch(num) {
			case 1 : t4.input(ar); break;
			case 2 : t4.output(ar); break;
			case 3 : t4.list(ar); break;
			case 4 : System.out.println("종료합니다"); break ROOP;
			default : System.out.println();
			}
		}
	}
	
	public void menu() {
		System.out.println();
		System.out.println("***********");
		System.out.println("  1.입차");
		System.out.println("  2.출차");
		System.out.println("  3.리스트");
		System.out.println("  4.종료");
		System.out.println("***********");
		
		System.out.println("메뉴를 입력해주세요  ");
	}
	
	public void input(boolean[] ar) throws IOException {
		System.out.println("위치입력 : ");
		int in = Integer.parseInt(br.readLine());

		if(ar[in-1]==true) {
			System.out.println("이미 주차되어있습니다");
		} else {
			ar[in-1] = true;
			System.out.println();
			System.out.println((in)+" 위치에 입차");
		}
	}
	
	public void output(boolean[] ar) throws IOException {
		System.out.println("위치입력 : ");
		int in = Integer.parseInt(br.readLine());
		
		if(ar[in-1]==false) {
			System.out.println("주차되어 있지않습니다.");
		} else {
			ar[in-1] = false;
			System.out.println(in+" 위치에 출차");
		}
	}
	
	public void list(boolean[] ar) {
		for(int i=0; i<ar.length; i++) {
			System.out.println((i+1)+"위치 : "+ar[i]);
		}
	}

}
