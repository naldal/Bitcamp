package workout;

import java.io.Serializable;

public class ScoreDTO implements Serializable, Comparable<ScoreDTO>{

	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public ScoreDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ScoreDTO(String hak, String name, int kor, int eng, int math) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
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
		return kor+eng+math;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = tot/3.0;
	}

	@Override
	public int compareTo(ScoreDTO o) {
		if(tot < o.getTot()) return -1;
		else if (tot == o.getTot()) return 0;
		else return 1;
	}
	
	
}
