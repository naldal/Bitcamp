package method;
/*
입출력 스트림
      BufferedReader          InputStreamReader
메모리 <-----------------buffer<-------------------키보드
									     System.in
                                                                              키보드를 통해서 들어오는 데이터의 타입은
                                   InputStream이다.
(*참고*)
파일로 부터 들어올 때는 FileReader

JVM - main
    - 모든 클래스를 java.lang에서 찾는다
    - 그러므로 그 이외의 것을 import 해주는 것
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//뒤에서부터 , 키보드(System.in)부터 출발 ~ InputStreamReader 통로를 거쳐
		//buffer에 보관되고 이후에 BufferedReader 통로를 거쳐 메모리로 이동한다.
		System.out.print("이름을 입력해주세요 : ");
		String str = br.readLine();
		
		System.out.print("나이를 숫자만 입력해주세요 : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("시력을 실수로 입력해주세요 : ");
		double eyes = Double.parseDouble(br.readLine());
		
		System.out.println("이름 : " + str + "\t 나이 :" + age + "세\t 시력 : " + eyes);
		
		//Exception(예외처리)
		//1. 컴파일 (
		//2. 실행 (잘못 쓴 것이기 때문에 보험처리 필요 x 고쳐야함) 
	}
}
