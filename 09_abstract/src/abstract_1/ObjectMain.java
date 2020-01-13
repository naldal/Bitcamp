package abstract_1;

/*
 * class Object {
 * 		public boolean equals(Object ob){}	//참조값 비교
 * 		public String toString(){} //클래스 @16진수값 
 * 		public int hashCode(){} //10진수
 * }
 * 
 * class String extends Object {
 * 		public boolean equals(Object ob){}	//문자열 비교
 * 		public String toString(){} //문자열
 * 		public int hashCode(){} // 21억 까지밖에 표현못함
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
		System.out.println("객체 t = " + t); // === toString
		System.out.println("객체 t = " + t.toString());
		System.out.println("객체 t = " + t.hashCode()); // toString 16진수 값을 10진수로 바꾼것
		System.out.println();

		String str = "apple";
		System.out.println("객체 t = " + str);
		System.out.println("객체 t = " + str.toString());
		System.out.println("객체 t = " + str.hashCode());
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
