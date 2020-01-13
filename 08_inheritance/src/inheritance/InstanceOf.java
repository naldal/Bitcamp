package inheritance;

class AAA {
}

class BBB extends AAA {
}

//-----
public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA();
		BBB bb = new BBB();
		AAA aa2 = new BBB();
		AAA aa3 = aa;

		if (bb instanceof AAA) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		AAA aa4 = bb;
		if (bb instanceof AAA) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		// BBB bb2 = (BBB) aa; //�����ϰ� AAAŬ������ ������ ����
		if (aa instanceof BBB)
			System.out.println("true");
		else
			System.out.println("false");

		BBB bb3 = (BBB) aa2; // �ڽ�Ŭ������ BBB�� ������ ����
		if (aa2 instanceof BBB)
			System.out.println("true");
		else
			System.out.println("false");
	}
}
