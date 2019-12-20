package workout;

public class Practice7 {
	public static void main(String[] args) {
		
		int i, j, k=0;
		int cnt=3;
		
		for (i = 2; i < 10; i += cnt) {
			for (j = 1; j < 10; j++) {
//				if(i>7) {
//					cnt=2;
//				}
				for (k=i; k < i+cnt; k++) {
					System.out.print(k+"*"+j+"="+(k*j)+"\t");
				}
				System.out.println();
				
				}
			System.out.println();
		}
	}
}
