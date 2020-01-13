package class_1;

public class SungJuk {

	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;

	
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public void calc() {
		tot=kor+eng+math;
		avg=(double)tot/3;
		if(this.avg>=90)
			this.grade = 'A';
		else if(this.avg>=80)
			this.grade = 'B';
		else if(this.avg>=70)
			this.grade = 'C';
		
	}
	
}
