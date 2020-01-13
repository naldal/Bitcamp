package method;

public class Boxing {

	public static void main(String[] args) {
		int a= 25;
		double b = (double)a/3;
		
		int c=5;
		Integer d = c;	//오토박싱 AutoBoxing 기본형 -> 객체형으로 
		//Integer d = new Integer(c); jdk 1.5 이전버전
		
		Integer e=5;
		int f=e; //unAutoBoxing
		//int f = e.intValue(); JDK 1.5 이전버전
		
		
	}
}
