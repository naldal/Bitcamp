package for_while_dowhile;

public class ForTest_Sum_Mul {

	public static void main(String[] args) {
		int sum=1;
		for(int i=1; i<=10; i++) {
			sum*=i;
			System.out.println(i+"\t"+sum);
		}
	}
}
