package method;

public class MethodTest {
	public static void main(String[] args) {
	int big = Math.max(25, 36);
	System.out.println("큰 값 = " + big);
	
	int small = Math.min(25, 36);
	System.out.println("작은 값 = " + small);
	
	double power = Math.pow(2, 5);
	System.out.println("2의 5승은 " + (int)power);
	
	//난수 = 컴퓨터가 불규칙하게 발생하는 수, 0.0<= 난수 <1.0
	//int a = (int)(Math.random()*100); //0~99
	//int a = (int)(Math.random()*100)+1; // 1~100
	int a = (int)(Math.random()*26)+65; // 65~99
	System.out.println(a);
	//System.out.println((char)a); //알파벳
	
	System.out.println('2' + '5'); //103
	System.out.println('2'- 48 + '5'- 48); //7 '0' (48) 0 (0)
	System.out.println();
	
	System.out.println("2" + "5.7"); //"25.7"
	System.out.println(Integer.parseInt("2") + Double.parseDouble("5.7"));
	}
}

//static은 new를 통해 다시 생성할 필요가 없이 기존에 이미 만들어진 것이다.