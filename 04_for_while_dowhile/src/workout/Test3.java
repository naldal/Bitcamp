package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//[����6]
//����5������ ����2, ����3�� if������ ó���� ���� switch�� �ٲٽÿ�

public class Test3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input1, input2, input3, input4;
		double sum=0.0;
		int toInt;
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
			case "F" : result="poor"; break;		//��
		}
		
		System.out.println("���� ="+String.format("%.2f", sum));
		System.out.println("����="+grade);
		System.out.println("��="+result);
		
	}

}


