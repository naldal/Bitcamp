package class_1;

public class Practice2 {

	public static void main(String[] args) {
		ShapeTest sh = new ShapeTest();
		
		System.out.print("���� ����:");
		sh.setArae(3);
		System.out.println(sh.getArae());
		
		System.out.print("�ﰢ���� ����:");
		sh.setArae(5, 7);
		System.out.println(sh.getArae());
		
		System.out.print("��ٸ����� ����:");
		sh.setArae(2,3,5);
		System.out.println(sh.getArae());
	}
}
