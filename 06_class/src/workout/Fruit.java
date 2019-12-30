package workout;

public class Fruit {

	private String pum;
	private int jan;
	private int feb;
	private int mar;
	private int tot;
	private static int sumJan;
	private static int sumFeb;
	private static int sumMar;
	
	public Fruit(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	
	public void calcTot(){
		this.tot = jan+feb+mar;
		this.sumJan += jan;
		this.sumFeb += feb;
		this.sumMar += mar;
	}
	
	public void display() {
		System.out.println(pum+"\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}
	
	public static void output() {
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}
	

	
}
