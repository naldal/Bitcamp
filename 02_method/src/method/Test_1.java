package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

����(dec)�� �Է¹޾Ƽ� 2����(binary), 8����(octor), 16����(hexa) ��ȯ�Ͻÿ�
IntegerŬ���� �޼ҵ带 �̿��Ͻÿ�

[������]
10������ �Է��ϼ��� : 250

2���� = 11111010
8���� = 372
16���� = fa

 */
public class Test_1 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dec = Integer.parseInt(br.readLine());
		String a2 = Integer.toBinaryString(dec);  // 10���� -> 2����
		String a8= Integer.toOctalString(dec);    // 10���� -> 8����
		String a16 = Integer.toHexString(dec);

		System.out.println("2 ���� : " + a2);
		System.out.println("8 ���� : " + a8);
		System.out.println("16 ���� : " + a16);

	
	}
}
