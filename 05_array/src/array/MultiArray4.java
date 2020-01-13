package array;

public class MultiArray4 {

	public static void main(String[] args) {
		String[] name = {"ȫ�浿", "�ڳ�", "��ġ"};
		int[][] jumsu = {{90, 80, 75},
						 {93, 81, 22},
						 {47, 28, 62}};
		double [] avg = new double[3];
		String[] grade = new String[3];
		
		System.out.println("----------------------------------------------");
		System.out.println("�̸� \t ���� \t ���� \t ���� \t ��� \t ����");
		System.out.println("----------------------------------------------");
		for(int i=0; i<name.length; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
				
				avg[i]+=jumsu[i][j];
			}
			avg[i]/=3.0;
			
			if(avg[i]>=80) {
				grade[i]="A";
			} else if(avg[i]>=50) {
				grade[i]="B";
			} else {
				grade[i]="C";
			}
			
			System.out.print(String.format("%.1f",avg[i])+"\t"+grade[i]);
			System.out.println();
			
		}
		System.out.println("----------------------------------------------");
		
	}
}
