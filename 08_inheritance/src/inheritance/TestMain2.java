package inheritance;

class AA {
	public int a = 3;

	public void disp() {
		a += 5;
		System.out.println("AA : " + a + " ");
	}
}
//----

class BB extends AA {
	public int a = 8;

	public void disp() {
		this.a += 5;
		System.out.println("BB : " + a + " ");
	}
}

public class TestMain2 {
	public static void main(String[] args) {
		BB bb = new BB();
		bb.disp();
		System.out.println(bb.a);
		System.out.println();

		AA aa = new BB(); // �θ� = �ڽ�
		aa.disp(); // BB : 13(a)
		System.out.println(aa.a); // ������ �������̵尡 ����, 3

		BB bb2 = (BB) aa; // �ٿ� ĳ����
		System.out.println(bb2.a);

	}
}
