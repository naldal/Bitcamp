package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �̸�, ����, ����, ������ �Է� �޾Ƽ� ������ ����� ���Ͻÿ�.
// ������ calcTot()���� ���ؿ���
// ����� calcAvg()���� ���ؿ���
// [������]
// *** ȫ�浿 ����ǥ ***
//����	����	����	����	���	
//92	100	85

public class MethodTest3 {

	public int calcTot(int i, int j, int k) {
		return i + j + k;
	}

	/*
	public double calcAvg(int i, int j, int k) {
		return (double) (i + j + k) / 3;
	}
	*/
	
	public double calcAvg(int tot) {
		return tot/3.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�̸��� �Է����ּ��� : ");
		String name = br.readLine();
		System.out.println("���� ������ �Է����ּ��� : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("���� ������ �Է����ּ��� : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("���� ������ �Է����ּ��� : ");
		int math = Integer.parseInt(br.readLine());

		MethodTest3 method3 = new MethodTest3();

		int tot = method3.calcTot(kor, eng, math);
		//double avg = method3.calcAvg(kor, eng, math);
		double avg = method3.calcAvg(tot);

		System.out.println("*** " + name + "�� ����ǥ ***");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(kor + "��\t" + eng + "��\t" + math + "��\t" + tot + "��\t" + String.format("%.2f", avg) + "��");
		
	}
}
