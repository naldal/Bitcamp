package class_1;

public class SungJukMain2 {

	public static void main(String[] args) {
		SungJuk[] ar = new SungJuk[3]; //객체배열
		
		ar[0] = new SungJuk();
		ar[1] = new SungJuk();
		ar[2] = new SungJuk();
		
		ar[0].setName("홍길동");
		ar[0].setKor(90);
		ar[0].setEng(91);
		ar[0].setMath(100);
		
		ar[1].setName("또치");
		ar[1].setKor(85);
		ar[1].setEng(78);
		ar[1].setMath(82);
		
		ar[2].setName("코난");
		ar[2].setKor(75);
		ar[2].setEng(98);
		ar[2].setMath(86);
		
		for(SungJuk sj : ar) {
			sj.calc();
			System.out.println(sj.getName()+"\t"
					   +sj.getKor()+"\t"
					   +sj.getEng()+"\t"
					   +sj.getMath()+"\t"
					   +sj.getTot()+"\t"
					   +String.format("%.2f", sj.getAvg())+"\t"
					   +sj.getGrade());
		}

	}
}
