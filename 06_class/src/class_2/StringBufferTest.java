package class_2;

import java.util.Scanner;

public class StringBufferTest {
	private int dan;
	
	//기본생성자 {
	// 원하는 단을 입력 :
	//}
	
	StringBufferTest(){
		Scanner sc = new Scanner(System.in);
		dan=sc.nextInt();
	}

	public void output() {
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<10 ; i++) {
		// System.out.println(dan+"*"+i+"="+(dan*i));
			
			sb.append(dan);
			sb.append("*");
			sb.append(i);
			sb.append("=");
			sb.append(dan*i);
			
			System.out.println(sb.toString()); 	//현재의 값에 계속 추가가 되서 진행됨
			sb.delete(0, sb.length()); //start~ end-1 까지 꺼내옴
			}//for
		}
	
	public static void main(String[] args) {
//		StringBufferTest sbt = new StringBufferTest();
//		sbt.output();

		new StringBufferTest().output();
	}
}
