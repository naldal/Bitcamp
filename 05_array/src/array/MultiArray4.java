package array;

public class MultiArray4 {

	public static void main(String[] args) {
		String[] name = {"È«±æµ¿", "ÄÚ³­", "¶ÇÄ¡"};
		int[][] jumsu = {{90, 80, 65},
						 {93, 81, 22},
						 {47, 28, 62}};
		int [] avg = new int[3];
		String[] grade = new String[3];
		
		System.out.println("--------------------------------------");
		System.out.println("ÀÌ¸§ \t ±¹¾î \t ¿µ¾î \t ÃÑÁ¡ \t Æò±Õ \t ÃÑÁ¡");
		for(int i=0; i<name.length; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
				
				avg[i]+=jumsu[i][j];
			}
			avg[i]/=3;
			
			if(avg[i]>=80) {
				grade[i]="A";
			} else if(avg[i]>=50) {
				grade[i]="B";
			} else {
				grade[i]="C";
			}
			
			System.out.print(avg[i]+"\t"+grade[i]);
			System.out.println();
		}
		
	}
}
