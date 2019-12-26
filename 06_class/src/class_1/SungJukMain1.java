package class_1;

public class SungJukMain1 {

	public static void main(String[] args) {
		SungJuk aa = new SungJuk();
		
		aa.setName("È«±æµ¿");
		aa.setKor(90);
		aa.setEng(91);
		aa.setMath(100);
		aa.calc();
		
		System.out.println(aa.getName()+"\t"
						   +aa.getKor()+"\t"
						   +aa.getEng()+"\t"
						   +aa.getMath()+"\t"
						   +aa.getTot()+"\t"
						   +String.format("%.2f", aa.getAvg())+"\t"
						   +aa.getGrade());
		
		//---------------------------------------
		
		SungJuk bb = new SungJuk();
		
		bb.setName("È«±æµ¿");
		bb.setKor(85);
		bb.setEng(78);
		bb.setMath(82);
		bb.calc();
		
		System.out.println(bb.getName()+"\t"
						   +bb.getKor()+"\t"
						   +bb.getEng()+"\t"
						   +bb.getMath()+"\t"
						   +bb.getTot()+"\t"
						   +String.format("%.2f", bb.getAvg())+"\t"
						   +bb.getGrade());
		
		//-----------------------------------------
		
		SungJuk cc = new SungJuk();
		
		cc.setName("ÄÚ³­");
		cc.setKor(75);
		cc.setEng(98);
		cc.setMath(86);
		cc.calc();
		
		System.out.println(cc.getName()+"\t"
						   +cc.getKor()+"\t"
						   +cc.getEng()+"\t"
						   +cc.getMath()+"\t"
						   +cc.getTot()+"\t"
						   +String.format("%.2f", cc.getAvg())+"\t"
						   +cc.getGrade());
		
		
	}
}
