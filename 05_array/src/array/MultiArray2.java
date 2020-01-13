package array;

public class MultiArray2 {
	public static void main(String[] args) {
		
		int[][] ar = new int[10][10];
		int a=1;
		
		//ют╥б
//		for(int i=0; i<ar.length ; i++) {
//			for(int j=0; j<ar[i].length; j++) {
//				ar[j][i]=a;
//				a++;
//			}
//		}
		for(int i=ar.length-1; i>=0 ; i--) {
			for(int j=ar[i].length-1; j>=0; j--) {
				ar[j][i]=a;
				a++;
				
			}
		}
		
		for(int i=0; i<ar.length ; i++) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.print(String.format("%5d", ar[i][j]));
			}
			System.out.println();
		}
		
	}

}
