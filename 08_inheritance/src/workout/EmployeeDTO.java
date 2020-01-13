package workout;

import java.util.Scanner;

public class EmployeeDTO {
	
	Scanner sc = new Scanner(System.in);
	
	private String name;  		//이름
	private String department;	//직급
	private double sal;			//월급
	private int basepay;		//기본급
	private int benefit;		//수당
	private double taxrate;		//세금

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getBasepay() {
		return basepay;
	}
	public void setBasepay(int basepay) {
		this.basepay = basepay;
	}
	public int getBenefit() {
		return benefit;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
	public double getTaxrate() {
		if(basepay<2000000) {
			taxrate = 0.01;
		} else if(basepay<4000000) {
			taxrate = 0.02;
		} else {
			taxrate = 0.03;
		}
		sal = basepay+benefit-(basepay+benefit)*taxrate;
		return taxrate;
	}
	
	public void setTaxrate(double taxrate) {
		this.taxrate = taxrate;
	}
	
	
}
