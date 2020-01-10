package abstract_1;

/*
 * class Object {
 * 		public boolean equals(Object ob){}	//������ ��
 * 		public String toString(){} //Ŭ���� @16������ 
 * 		public int hashCode(){} //10����
 * }
 * 
 * class String extends Object {
 * 		public boolean equals(Object ob){}	//���ڿ� ��
 * 		public String toString(){} //���ڿ�
 * 		public int hashCode(){} // 21�� �����ۿ� ǥ������
 * }
 * 
 * 
 */
class Test extends Object {

	@Override
	public String toString() {
		return getClass() + "@dddd";
	}
}

//-------------------------
public class ObjectMain /* extends Object */ {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("��ü t = " + t); // === toString
		System.out.println("��ü t = " + t.toString());
		System.out.println("��ü t = " + t.hashCode()); // toString 16���� ���� 10������ �ٲ۰�
		System.out.println();

		String str = "apple";
		System.out.println("��ü t = " + str);
		System.out.println("��ü t = " + str.toString());
		System.out.println("��ü t = " + str.hashCode());
		System.out.println();

		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa == bb));
		System.out.println("aa.equals(bb) : " + aa.equals(bb));
		System.out.println();

		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc == dd));
		System.out.println("cc.equals(dd) : " + cc.equals(dd));
		System.out.println();

		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff));
		System.out.println("cc.equals(dd) : " + ee.equals(ff));
		System.out.println();
	}

}
