package workout;

public class Practice7 {
	public static void main(String[] args) {
		
		int i, j, k=0;
		
		for (i = 2; i <= 8; i += 3) {
			for (j = 1; j < 10; j++) {
				for (k=i; k<i+2; k++) {
					if(i!=10) System.out.print(k+"*"+j+"="+(k*j)+"\t");
				}
				System.out.println();
				
				}
			System.out.println();
		}
	}
}
