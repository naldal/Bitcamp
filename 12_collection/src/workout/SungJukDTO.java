package workout;

import java.text.DecimalFormat;

public class SungJukDTO implements Comparable<SungJukDTO> {

	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private double tot;
	
	public SungJukDTO(int num, String name, int kor, int eng, int math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public SungJukDTO() {
		// TODO Auto-generated constructor stub
	}
	//

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = (double)(kor+eng+math)/3;
	}

	public double getTot() {
		return tot;
	}

	public void setTot() {
		this.tot = kor+eng+math;
	}
	
	@Override
	public String toString() {
		return num+"\t"
				+name+"\t"
				+kor+"\t"
				+eng+"\t"
				+math+"\t"
				+new DecimalFormat("#.##").format(avg)+"\t"
				+tot;
	}
	
	@Override
	public int compareTo(SungJukDTO dto) {
//		if(tot > dto.getTot()) {
//			return -1; 
//		} else if(tot == dto.getTot()) {
//			return 0;
//		} else {
//			return 1;
//		}
		return tot>dto.tot?-1:1;
		
		// return name.compare(dto.getName()); 이름으로 비교는 훨씬 쉽다.
	}
	
	
	
	
}
