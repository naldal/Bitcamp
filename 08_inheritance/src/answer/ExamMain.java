package answer;

import java.util.Scanner;

public class ExamMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("인원수 입력 : ");
		int size = sc.nextInt();
		
		Exam[] exam = new Exam[size]; //객체 배열 . 배열로 방만 잡은 것이지 클래스를 생성한것이 아님
 		for(int i=0; i<size; i++) {
 			exam[i] = new Exam(); // 클래스생성 + 생성자 호출
 			exam[i].compare();
 		}
 		
 		System.out.println("이름\t1 2 3 4 5\t점수");
 		
 		for(int i=0; i<size; i++) { 			
 			System.out.print(exam[i].getName()+"\t");
 			
 			for(int j=0; j<exam[i].getOx().length; j++) {
 				System.out.print(exam[i].getOx()[j]+" ");
 			}
 			System.out.println("\t"+exam[i].getScore());
 		} //for i
		
	}
}
