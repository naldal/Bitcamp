package if_switch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("x�� �Է� : ");
		int x = Integer.parseInt(br.readLine());
		System.out.println("y�� �Է� : ");
		int y = Integer.parseInt(br.readLine());
		int num = 0;

		for (int i = 0; i < y; i++) {
			if (i == 0) {
				num += x;

			} else {
				num *= x;
			}
		}
		System.out.println(x + "�� " + y + "�� " + num);

	}
}

/*
 * [����2] ������ ���Ͻÿ� (x�� y�� ��) [������] x�� �Է� : 2 y�� �Է� : 5 2�� 5�� xx (2*2*2*2*2) �Ǵ�
 * x�� �Է� : 3 y�� �Է� : 4 3�� 4�� xx (3*3*3*3)
 */
