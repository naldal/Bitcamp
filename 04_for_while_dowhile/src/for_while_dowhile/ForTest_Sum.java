package for_while_dowhile;

public class ForTest_Sum {

	public static void main(String[] args) {
		int i;
		int a = 0;
		for(i=1; i<=10 ; i++) {
			
			if(i%2==1) {
				a-=i;
				System.out.print("-"+i);
			} else {
				a+=i;
				System.out.print("+"+i);
			}
		
		}//for
		System.out.print("="+a);
	}
}
