package answer;

public class EmployeeDTO {
	private String name, position;
	private int basePay, benefit, salary;
	private double taxRate;
	
	public EmployeeDTO(String name, String position, int basePay, int benefit) {
		super();
		this.name = name;
		this.position = position;
		this.basePay = basePay;
		this.benefit = benefit;
	}
	
	public void calc() {
		if (basePay <= 2000000) {
			taxRate = 0.01;
		} else if (basePay <= 4000000) {
			taxRate = 0.02;
		} else
			taxRate = 0.03;
		salary = (int) (basePay + benefit-(basePay + benefit) * taxRate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	
	@Override
	public String toString() {
		return name + "\t"
				+ position + "\t"
				+ basePay + "\t"
				+ benefit + "\t"
				+ taxRate + "\t"
				+ salary;
	}
	
}
