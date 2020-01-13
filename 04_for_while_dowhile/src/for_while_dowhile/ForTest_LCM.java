package for_while_dowhile;

public class ForTest_LCM {
	
	public static void main(String[] args) {
		
		int ran, tmp, tmpSum=0, tmpCnt=0;
		int row=0;
		
		for(int i=1; i<=100; i++) {
			ran=(int)(Math.random()*500)+1;
			
			if(ran%6==0) {
				tmp=ran;
				System.out.print(String.format("%5d",tmp));
				row++;
				
				if(row%7==0)
					System.out.println();
				
				tmpSum+=tmp;
				tmpCnt++;
			}
		} //for
		
		System.out.println();
		System.out.println("2와 3의 공배수 개수 ="+tmpCnt);
		System.out.println("2와 3의 공배수 합 ="+tmpSum);
	}

}
