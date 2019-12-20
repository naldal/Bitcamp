package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[문제6]
//문제5번에서 조건2, 조건3의 if문으로 처리한 것을 switch로 바꾸시오

public class Test3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input1, input2, input3, input4;
		double sum=0.0;
		int toInt;
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
		toInt = (int)sum;
		
		switch(toInt/10) {
		case 9 : grade="A"; break;
		case 8 : grade="B"; break;
		case 7 : grade="C"; break;
		case 6 : grade="D"; break;
		default : grade="F";
		}
		
		switch(grade) {
			case "A" : 
			case "B" : result="excellent"; break;
			case "C" : 
			case "D" : result="good"; break;
			case "F" : result="poor"; break;		//평가
		}
		
		System.out.println("성적 ="+String.format("%.2f", sum));
		System.out.println("학점="+grade);
		System.out.println("평가="+result);
		
	}

}


