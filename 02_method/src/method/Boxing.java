package method;

public class Boxing {

	public static void main(String[] args) {
		int a= 25;
		double b = (double)a/3;
		
		int c=5;
		Integer d = c;	//����ڽ� AutoBoxing �⺻�� -> ��ü������ 
		//Integer d = new Integer(c); jdk 1.5 ��������
		
		Integer e=5;
		int f=e; //unAutoBoxing
		//int f = e.intValue(); JDK 1.5 ��������
		
		
	}
}
