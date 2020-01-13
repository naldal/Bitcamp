package workout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Practice_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {

			System.out.println("����(1), ����(2), ��(3) �� ��ȣ�� �Է��ϼ��� : ");
			int me = Integer.parseInt(br.readLine());
			int computer = (int) (Math.random() * 3) + 1;

			if (me == 1) {
				if (computer == 2) {
					System.out.println("��ǻ�� : ����\t�� : ����");
					System.out.println("You Lose!!");
				} else if (computer == 3) {
					System.out.println("��ǻ�� : ���ڱ�\t�� : ����");
					System.out.println("You Win!!");
				} else {
					System.out.println("��ǻ�� : ����\t�� : ����");
					System.out.println("You Draw!!");
				}
			} else if (me == 2) {
				if (computer == 1) {
					System.out.println("��ǻ�� : ����\t�� : ����");
					System.out.println("You Win!!");
				} else if (computer == 2) {
					System.out.println("��ǻ�� : ����\t�� : ����");
					System.out.println("You Draw!!");
				} else {
					System.out.println("��ǻ�� : ���ڱ�\t�� : ����");
					System.out.println("You Lose!!");
				}
			} else if (me == 3) {
				if (computer == 1) {
					System.out.println("��ǻ�� : ����\t�� : ���ڱ�");
					System.out.println("You Lose!!");
				} else if (computer == 2) {
					System.out.println("��ǻ�� : ����\t�� : ���ڱ�");
					System.out.println("You Win!!");
				} else {
					System.out.println("��ǻ�� : ���ڱ�\t�� : ���ڱ�");
					System.out.println("You Draw!!");
				}
			} else {
				System.out.println("�߸��� ���Դϴ�.");
			}
			System.out.println("�� �ҷ�?(Y/N)");
			String again = br.readLine();
			if (again.equals("N")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;

			}
		}
	}
}

//����������
/*
 * [������] ����(1), ����(2), ��(3) �� ��ȣ �Է� : 3(user) ��ǻ�� : ���� �� : ���ڱ� You Win!! ����(1),
 * ����(2), ��(3) �� ��ȣ �Է� : 3(user) ��ǻ�� : ���� �� : ���ڱ� You Lose!! ����(1), ����(2), ��(3)
 * �� ��ȣ �Է� : 3(user) ��ǻ�� : ���� �� : ���� You Draw!!
 */