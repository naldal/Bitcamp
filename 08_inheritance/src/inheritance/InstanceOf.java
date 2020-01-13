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

		// BBB bb2 = (BBB) aa; //순수하게 AAA클래스를 가지고 있음
		if (aa instanceof BBB)
			System.out.println("true");
		else
			System.out.println("false");

		BBB bb3 = (BBB) aa2; // 자식클래스인 BBB를 가지고 있음
		if (aa2 instanceof BBB)
			System.out.println("true");
		else
			System.out.println("false");
	}
}
