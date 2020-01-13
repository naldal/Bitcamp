package inheritance;

//class EnumColor{
//	static final String RED = "빨강";
//	static final String GREEN = "초록";
//	static final String BLUE = "파랑";
//	static final String MAGENTA = "보라";
//}
enum EnumColor { // 상수 열거형
	RED, GREEN, BLUE, MAGENTA; // 이러한 것들을 상수로 취급하겠다는 것, 기본적으로 0을 가지고 있음
}

//------------------------------
public class EnumMain {
	String colorName;
	EnumColor color;

	public static void main(String[] args) {
		System.out.println(EnumColor.RED); // 결과 = RED
		System.out.println();

		EnumMain em = new EnumMain();
		em.colorName = "빨강";
		em.color = EnumColor.RED;
		System.out.println(em.colorName + "\t" + em.color);

		em.colorName = "보라";
		EnumColor enm = EnumColor.MAGENTA;
		System.out.println(em.colorName + "\t" + enm);

		System.out.println();

		for (EnumColor data : EnumColor.values()) {
			System.out.println(data + "\t" + data.ordinal() + "\t" + data.valueOf(data + ""));
		}
	}
}
