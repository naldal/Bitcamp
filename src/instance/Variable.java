package instance;

public class Variable {

	public static void main(String[] args) {
		boolean a = true;
		System.out.println("a="+a);
		
		char b;
		b = 'A';
		System.out.println("b="+b);
		
		char c;
		//c=65536; - error;
		c=65;
		System.out.println("c="+c);
		
		int d= 65;
		System.out.println("d="+d);
		
		int e= 'A';
		System.out.println("e="+e);
		
		long f= 25L;
		System.out.println("f="+f);
		
		float g= 43.8f;
		System.out.println(g);
		
		double h = 43.8;
		System.out.println(h);
		
	}
}
