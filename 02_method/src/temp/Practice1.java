package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice1 {
	// ����(dec)�� �Է¹޾Ƽ� 2����(binary), 8����(octor), 16����(hexa) ��ȯ�Ͻÿ�
	// IntegerŬ���� �޼ҵ带 �̿��Ͻÿ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("10������ �Է��ϼ���: ");
		System.out.println();
		int dec = Integer.parseInt(br.readLine());

		// String binary = Integer.toBinaryString(dec);
		// String octor = Integer.toOctalString(dec);
		// String hexa = Integer.toHexString(dec);
		System.out.println("2���� = " + Integer.toBinaryString(dec));
		System.out.println("8���� = " + Integer.toOctalString(dec));
		System.out.println("16���� = " + Integer.toHexString(dec));
		
	}
}
