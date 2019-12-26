package workout;

public class MultiArray4_1 {
	public static void main(String[] args) {
		String[] name = {"홍길동", "코난", "또치"};
		int[][] jumsu = {{90, 80, 75, 0},
						 {93, 81, 22, 0},
						 {47, 28, 62, 0}};
		double [] avg = new double[3];
		char[] grade = new char[3];
		
		for(int i=0; i<jumsu.length; i++) {
			for(int j=0; j<jumsu[i].length-1; j++) {
				jumsu[i][3] += jumsu[i][j];
			}
			avg[i] = (double)jumsu[i][3]/3;

		}//for j
		
		for(int i=0; i<avg.length; i++) {
			if(avg[i] >= 90) grade[i] = 'A';
			else if(avg[i] >= 80) grade[i] = 'B';
			else if(avg[i] >= 70) grade[i] = 'C';
			else if(avg[i] >= 60) grade[i] = 'D';
			else grade[i] = 'F';
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
		
		for(int i=0; i<jumsu.length; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}//for j
			System.out.print(String.format("%.2f", avg[i])+"\t"+grade[i]);
			System.out.println();
		} //for i
		System.out.println("----------------------------------------------------");
	}
}
