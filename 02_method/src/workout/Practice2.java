package workout;

public class Practice2 {
	//�ֻ����� 2�� ������ ���� ���� ���� ���Ͻÿ�
	//�ֻ����� input()���� 1~6������ ������ �߻��Ͽ� �����Ѵ�
	//���� add()���� ���Ͽ� ���� �޴´�
	public int input() {
		int su = (int) (Math.random() * 6 + 1);
		return su;
	}

	public int add(int su1, int su2) {
		return su1 + su2;
	}

	public static void main(String[] args) {

		Practice2 p2 = new Practice2();

		int su1 = p2.input();
		System.out.println("ù��° �ֻ��� �� : " + su1);
		int su2 = p2.input();
		System.out.println("�ι�° �ֻ��� �� : " + su2);

		System.out.println("���� " + p2.add(su1, su2) + " �̴�");
	}

}
