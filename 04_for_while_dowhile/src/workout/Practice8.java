package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice8 {
	static int total;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Practice8 t5 = new Practice8();
		int input;
		int thorwAway = 0;
		
		while(true) {
			System.out.println("***********");
			System.out.println("  1.����");
			System.out.println("  2.���");
			System.out.println("  3.�ܰ�");
			System.out.println("  4.����");
			System.out.println("***********");
			
			System.out.println("��ȣ����");
			input = Integer.parseInt(br.readLine());
			
			if(input==1) {
				System.out.print("���ݾ� :");
				input = Integer.parseInt(br.readLine());
				
				if(input%10000==0) {
					int resultOne = t5.input(input);
					System.out.println("����� �ܾ��� "+resultOne+"�� �Դϴ�");
				} else {
					System.out.println("���������� �Է��ϼ���");
					continue;
				}
			} else if(input==2) {
				System.out.print("��ݾ� :");
				input = Integer.parseInt(br.readLine());
				thorwAway = t5.output(input);
				if(thorwAway>0) {
					System.out.println("����� �ܾ���"+thorwAway+"�Դϴ�");
				} else {
					System.out.println("�ܾ��� �����մϴ�");
				}
			} else if(input==3) {
				System.out.println("����� �ܾ��� "+total+"�Դϴ�");
			} else {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
		}
	} //main
	
	public int input(int money) {
		total += money;
		return total;
	}
	
	public int output(int money) {
		total -= money;
		return total;
	}

}
