package workout;

import java.util.Scanner;

public class ExamMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		Exam[] ex;
		
		System.out.println("인원수 입력 : ");
		num=sc.nextInt();
		ex = new Exam[num];
		
		for(int i=0; i<ex.length; i++) {
			ex[i] = new Exam();
			System.out.print(ex[i].getName()+"\t");
			ex[i].getOx();
			System.out.print("\t"+ex[i].getScore());
			System.out.println();
		}
		
		
	}

}
