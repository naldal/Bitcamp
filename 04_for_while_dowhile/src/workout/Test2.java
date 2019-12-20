package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� ���� ���α׷�
//�߰����, �⸻���, ����Ʈ, �⼮������ �Է¹޾Ƽ� ����Ͻÿ�
//
//����1) (�߰�+�⸻)/2    ---> 60%
//          ����   	     ---> 20%
//          �⼮                ---> 20%     
//����2)  90�̻� 'A'����     		
//          80�̻� 'B'����        		  	 
//          70�̻� 'C'����        		  	 
//          60�̻� 'D'����        		  	 
//          ������ 'F'����
//����3)
//         A, B����  ---->"excellent"     
//         C, D����  ---->"good"
//         F����    ---->"poor"
//
//[������]
//�߰���縦 �Է��Ͻÿ� : 90
//�⸻��縦 �Է��Ͻÿ� : 89
//���������� �Է��Ͻÿ� : 99
//�⼮������ �Է��Ͻÿ� : 100
//
//����=93.20         <---�Ҽ����� 2°�ڸ�����
//����=A              
//��=excellent
//

public class Test2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input1, input2, input3, input4;
		double sum=0.0;
		String grade;
		String result = "";
		
		System.out.print("�߰���縦 �Է��Ͻÿ� :");
		input1 = Integer.parseInt(br.readLine());	//�߰�
		
		System.out.print("�⸻��縦 �Է��Ͻÿ� :");
		input2 = Integer.parseInt(br.readLine());	//�⸻ (�߰�+�⸻)/2 *0.6
		
		System.out.print("������縦 �Է��Ͻÿ� :");
		input3 = Integer.parseInt(br.readLine());	//����  *0.2
		
		System.out.print("�⼮��縦 �Է��Ͻÿ� :");		//�⼮ *0.2
		input4 = Integer.parseInt(br.readLine());
		
		sum += (((input1+input2)/2)*0.6)+(input3*0.2)+(input4*0.2);	//����
		
		if(sum>=90)
			grade="A";
		else if(sum>=80)
			grade="B";
		else if(sum>70)
			grade="C";
		else if(sum>60)
			grade="D";
		else 
			grade="F";		//����

		if(grade.equals("A") || grade.equals("B")) {
			result="excellent";
		} else if(grade.equals("C") || grade.equals("D")) {
			result="good";
		} else {
			result="poor";
		}
		
		System.out.println("���� ="+String.format("%.2f", sum));
		System.out.println("����="+grade);
		System.out.println("��="+result);
		
	}

}
