package workout;

public class Practice1 {

	public static void main(String[] args) {
		
		int[] arr = new int[50];
		int cnt=0;
		
		for(int i=1; i<=arr.length ; i++) {
			int ran = (int)(Math.random()*26)+65;
			arr[i-1]=ran;
			System.out.print((char)arr[i-1]+" ");

			if(i%10==0) {
				System.out.println();
			}
		}
		
		System.out.println();
		
		for(int i=65; i<=90; i++) {
			for(int j=0; j<arr.length; j++) {
				if(i==arr[j]) {
					cnt++;
					System.out.println((char)i+": "+cnt);
				}
			}
			cnt=0;
		}
		
		
		
	}
}
