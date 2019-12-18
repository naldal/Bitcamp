package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * �̸�(name)�� �ֹι�ȣ(id)�� �Է��Ͽ� ������ ����Ͻÿ�.
 * ������ �����ϴ� comp() �޼ҵ�� ���̸� ����ϴ� calcAge() �޼ҵ带 �ۼ��Ͻÿ�.
 * 
 * �̸� �Է� : ȫ�浿
 * �ֹι�ȣ �Է� : 001023-1234567
 * 
 * 
 * 
 * [������]
 * ȫ�浿���� �����̰� 20�� �Դϴ�.
 */

public class MethodTest4 {
	
	public String comp(String id) {
		
		String result = id.charAt(7)=='1' || id.charAt(7)=='3' ? "����" : "����";
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
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = br.readLine();
		System.out.print("�ֹι�ȣ�� �Է��ϼ��� : ");
		String num = br.readLine();
			
		String gender = mt4.comp(num);
		int age = Integer.parseInt(mt4.calcAge(num));
		
		int realAge = 2019-age+1;
		
		System.out.println(name + "���� " + gender + "�̰� " + realAge + "�� �Դϴ�.");
	
		
		
	}

}
