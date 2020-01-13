package workout;

public class Practice1_1 {
	
	public static void main(String[] args) {
		int[] arr = new int[25];
		int[] count = new int[26];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*26+65);
			System.out.println(((char) arr[i] + " "));
			
			if((i+1)%10==0) {
				System.out.println();
			}
		}
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<count.length; j++) {
				if(arr[i]==j+65)
					count[j]++;
			}
		}
		
		System.out.println();
		for(int i=0; i<count.length; i++) {
			System.out.println((char)(i+'A')+"\t"+count[i]);
		}
	}

}
