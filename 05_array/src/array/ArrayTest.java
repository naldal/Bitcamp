package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar = new int[5];
		ar[0]=25;
		ar[1]=36;
		ar[2]=47;
		ar[3]=55;
		ar[4]=60;
		
		for(int e : ar) {	//ar의 크기만큼 반복
			System.out.println(e);
		}
		
//		System.out.println("배열명 ar="+ar);
//		System.out.println("배열명 ar="+ar.toString());
//		System.out.println(ar.length);
		
//		for(int i=0; i<ar.length ; i++) {
//			System.out.println(ar[i]);
//		}
//		System.out.println();
//		for(int i=ar.length-1; i>=0 ; i--) {
//			System.out.println(ar[i]);
//		}
		
//		for(int i=0 ; i<ar.length ; i++) {
//			if(ar[i]%2!=0) {
//				System.out.println(ar[i]);
//			}
//		}
	}
}
