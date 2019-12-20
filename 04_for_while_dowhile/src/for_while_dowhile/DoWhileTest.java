package for_while_dowhile;

public class DoWhileTest {

	public static void main(String[] args) {
//		int a=0;
//		do {
//			a++;
//			System.out.println(a);
//			
//		}while(a<10);
		
		char ch = 'A';
		int cnt=0;
		do {
			System.out.print(ch);
			ch++;
			cnt++;
			if(cnt%7==0) {
				System.out.println();
			}
		}while(ch<='Z');
	}
}
