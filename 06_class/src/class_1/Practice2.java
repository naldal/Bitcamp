package class_1;

class ShapeTest {

	public static final double PI = 3.141592; //»ó¼öÈ­
	
	public double area(int a) {
		return PI*a*a;
	}
	public double area(int a, int b) {
		return a*b/2.0;
	}
	public double area(int a, int b, int c) {
		return (a+b)*c/2.0;
	}
}

public class Practice2 {

	public static void main(String[] args) {
		ShapeTest sh = new ShapeTest();
		
		System.out.print("¿øÀÇ ³ĞÀÌ:");

		System.out.println(sh.area(3));
		
		System.out.print("»ï°¢ÇüÀÇ ³ĞÀÌ:");

		System.out.println(sh.area(5,7));
		
		System.out.print("»ç´Ù¸®²ÃÀÇ ³ĞÀÌ:");

		System.out.println(sh.area(2,3,5));
	}
}
