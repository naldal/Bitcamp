package method;

public class MethodTest {
	public static void main(String[] args) {
	int big = Math.max(25, 36);
	System.out.println("ū �� = " + big);
	
	int small = Math.min(25, 36);
	System.out.println("���� �� = " + small);
	
	double power = Math.pow(2, 5);
	System.out.println("2�� 5���� " + (int)power);
	
	//���� = ��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� ��, 0.0<= ���� <1.0
	//int a = (int)(Math.random()*100); //0~99
	//int a = (int)(Math.random()*100)+1; // 1~100
	int a = (int)(Math.random()*26)+65; // 65~99
	System.out.println(a);
	//System.out.println((char)a); //���ĺ�
	
	System.out.println('2' + '5'); //103
	System.out.println('2'- 48 + '5'- 48); //7 '0' (48) 0 (0)
	System.out.println();
	
	System.out.println("2" + "5.7"); //"25.7"
	System.out.println(Integer.parseInt("2") + Double.parseDouble("5.7"));
	}
}

//static�� new�� ���� �ٽ� ������ �ʿ䰡 ���� ������ �̹� ������� ���̴�.