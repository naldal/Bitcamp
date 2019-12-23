package workout;

public class Practice3 {
	//input() -난수발생 중복된 숫자가 나오면 다시 발생
	//output() -  난수가 몇개나왔는지 출력
	public static void main(String[] args) {
	
		Practice3 p3 = new Practice3();
		int[] arr = new int[6];
		
		p3.input(arr);
		p3.output(arr);

	}
	
	public void input(int[] arr) {

		for(int i=0; i<arr.length ; i++) {
			int random = (int)(Math.random()*45)+1;
			arr[i] = random;
			
			for(int j=0; j<i; j++) {
				if(arr[j]==arr[i]) {
					i--;
					break;
				}
			}
		}
	}
	
	public void output(int[] arr) {
		for(int e : arr)
			System.out.println(e);
	}

}
