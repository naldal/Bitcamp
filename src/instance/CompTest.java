package instance;

public class CompTest {

	public static void main(String[] args) {
		
		int a=22;
		int b= a++; 
		//a=23
		//b=22 (���������ں��� =�� ���� ��)
		System.out.println("a="+a+"\t b="+b); 
		
		int c = ++a - b--; //a=24 b=22 c=2
		//a=24 b=21 c=2
		System.out.println("a="+a+"\t b="+b+"\t c="+c);
		
		
		
		
	}
	
}
