package answer;

import java.io.Serializable;

public class ScoreDTO implements Serializable{
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public ScoreDTO(String hak, String name, int kor, int eng, int math) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}

	public void calc() {
		tot = kor+eng+math;
		avg = (double)tot/3;
	}
	
	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
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

	public String toString() {
		return String.format("%6s %6s %5d %5d %5d %5d %9.2f", hak, name, kor, eng, math, tot, avg);
	}

}
