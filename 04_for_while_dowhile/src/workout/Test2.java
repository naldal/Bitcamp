package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 성적 관리 프로그램
//중간고사, 기말고사, 레포트, 출석점수를 입력받아서 계산하시오
//
//조건1) (중간+기말)/2    ---> 60%
//          과제   	     ---> 20%
//          출석                ---> 20%     
//조건2)  90이상 'A'학점     		
//          80이상 'B'학점        		  	 
//          70이상 'C'학점        		  	 
//          60이상 'D'학점        		  	 
//          나머지 'F'학점
//조건3)
//         A, B학점  ---->"excellent"     
//         C, D학점  ---->"good"
//         F학점    ---->"poor"
//
//[실행결과]
//중간고사를 입력하시오 : 90
//기말고사를 입력하시오 : 89
//과제점수를 입력하시오 : 99
//출석점수를 입력하시오 : 100
//
//성적=93.20         <---소수이하 2째자리까지
//학점=A              
//평가=excellent
//

public class Test2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input1, input2, input3, input4;
		double sum=0.0;
		String grade;
		String result = "";
		
		System.out.print("중간고사를 입력하시오 :");
		input1 = Integer.parseInt(br.readLine());	//중간
		
		System.out.print("기말고사를 입력하시오 :");
		input2 = Integer.parseInt(br.readLine());	//기말 (중간+기말)/2 *0.6
		
		System.out.print("과제고사를 입력하시오 :");
		input3 = Integer.parseInt(br.readLine());	//과제  *0.2
		
		System.out.print("출석고사를 입력하시오 :");		//출석 *0.2
		input4 = Integer.parseInt(br.readLine());
		
		sum += (((input1+input2)/2)*0.6)+(input3*0.2)+(input4*0.2);	//성적
		
		if(sum>=90)
			grade="A";
		else if(sum>=80)
			grade="B";
		else if(sum>70)
			grade="C";
		else if(sum>60)
			grade="D";
		else 
			grade="F";		//학점

		if(grade.equals("A") || grade.equals("B")) {
			result="excellent";
		} else if(grade.equals("C") || grade.equals("D")) {
			result="good";
		} else {
			result="poor";
		}
		
		System.out.println("성적 ="+String.format("%.2f", sum));
		System.out.println("학점="+grade);
		System.out.println("평가="+result);
		
	}

}
