package answer;

import java.util.Scanner;

public class ExamMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ο��� �Է� : ");
		int size = sc.nextInt();
		
		Exam[] exam = new Exam[size]; //��ü �迭 . �迭�� �游 ���� ������ Ŭ������ �����Ѱ��� �ƴ�
 		for(int i=0; i<size; i++) {
 			exam[i] = new Exam(); // Ŭ�������� + ������ ȣ��
 			exam[i].compare();
 		}
 		
 		System.out.println("�̸�\t1 2 3 4 5\t����");
 		
 		for(int i=0; i<size; i++) { 			
 			System.out.print(exam[i].getName()+"\t");
 			
 			for(int j=0; j<exam[i].getOx().length; j++) {
 				System.out.print(exam[i].getOx()[j]+" ");
 			}
 			System.out.println("\t"+exam[i].getScore());
 		} //for i
		
	}
}
