package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 이름(name)과 주민번호(id)를 입력하여 성별을 출력하시오.
 * 성별을 구별하는 comp() 메소드와 나이를 계산하는 calcAge() 메소드를 작성하시오.
 * 
 * 이름 입력 : 홍길동
 * 주민번호 입력 : 001023-1234567
 * 
 * 
 * 
 * [실행결과]
 * 홍길동님은 남자이고 20살 입니다.
 */

public class MethodTest4 {
	
	public String comp(String id) {
		
		String result = id.charAt(7)=='1' || id.charAt(7)=='3' ? "남자" : "여자";
		return result;
	}
	
	public String calcAge(String tnum) {
		int num = Integer.parseInt(tnum.substring(0, 2)); 
		String age = num <= 99 && num > 19 ? "19"+num :"20"+num;
		return age;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MethodTest4 mt4 = new MethodTest4();
		
		System.out.print("이름을 입력하세요 : ");
		String name = br.readLine();
		System.out.print("주민번호를 입력하세요 : ");
		String num = br.readLine();
			
		String gender = mt4.comp(num);
		int age = Integer.parseInt(mt4.calcAge(num));
		
		int realAge = 2019-age+1;
		
		System.out.println(name + "님은 " + gender + "이고 " + realAge + "살 입니다.");
	
		
		
	}

}
