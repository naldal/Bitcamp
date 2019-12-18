package method;
/*
����� ��Ʈ��
      BufferedReader          InputStreamReader
�޸� <-----------------buffer<-------------------Ű����
									     System.in
                                                                              Ű���带 ���ؼ� ������ �������� Ÿ����
                                   InputStream�̴�.
(*����*)
���Ϸ� ���� ���� ���� FileReader

JVM - main
    - ��� Ŭ������ java.lang���� ã�´�
    - �׷��Ƿ� �� �̿��� ���� import ���ִ� ��
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�ڿ������� , Ű����(System.in)���� ��� ~ InputStreamReader ��θ� ����
		//buffer�� �����ǰ� ���Ŀ� BufferedReader ��θ� ���� �޸𸮷� �̵��Ѵ�.
		System.out.print("�̸��� �Է����ּ��� : ");
		String str = br.readLine();
		
		System.out.print("���̸� ���ڸ� �Է����ּ��� : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("�÷��� �Ǽ��� �Է����ּ��� : ");
		double eyes = Double.parseDouble(br.readLine());
		
		System.out.println("�̸� : " + str + "\t ���� :" + age + "��\t �÷� : " + eyes);
		
		//Exception(����ó��)
		//1. ������ (
		//2. ���� (�߸� �� ���̱� ������ ����ó�� �ʿ� x ���ľ���) 
	}
}
