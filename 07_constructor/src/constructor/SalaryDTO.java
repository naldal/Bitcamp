package constructor;

public class SalaryDTO { //Data Transfer Object

	private String name;
	private String position;
	private int basePay;
	private int benefit;
	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public int getBasePay() {
		return basePay;
	}

	public int getBenefit() {
		return benefit;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public double getTax() {
		return tax;
	}

	public double getSalary() {
		return salary;
	}

	private double taxRate;
	private double tax;
	private double salary;
	
	public SalaryDTO(String name, String position, int basePay, int benefit) {
		this.name = name;
		this.position = position;
		this.basePay = basePay;
		this.benefit = benefit;
		
		calc();
	}
	
	public void calc() {
		
		if(basePay<2000000) {
			taxRate=0.01;
		} else if(basePay<=4000000){
			taxRate=0.02;
		} else if(basePay>4000000) {
			taxRate=0.03;
		}
		
		tax = (basePay+benefit)*taxRate;
		salary = (basePay+benefit-tax);

		//System.out.println(name+"\t"+position+"\t"+basePay+"\t"+benefit+"\t"+taxRate+"\t"+tax+"\t"+salary);
	}
	
	
}

// 메모리에서 1인분을 잡아야.
