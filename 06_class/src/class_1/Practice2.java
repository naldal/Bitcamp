package class_1;

public class Practice2 {

	public static void main(String[] args) {
		ShapeTest sh = new ShapeTest();
		
		System.out.print("ø¯¿« ≥–¿Ã:");
		sh.setArae(3);
		System.out.println(sh.getArae());
		
		System.out.print("ªÔ∞¢«¸¿« ≥–¿Ã:");
		sh.setArae(5, 7);
		System.out.println(sh.getArae());
		
		System.out.print("ªÁ¥Ÿ∏Æ≤√¿« ≥–¿Ã:");
		sh.setArae(2,3,5);
		System.out.println(sh.getArae());
	}
}
