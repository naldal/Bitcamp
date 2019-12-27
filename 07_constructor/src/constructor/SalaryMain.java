package constructor;

import java.text.DecimalFormat;

public class SalaryMain {

	public static void main(String[] args) {
		SalaryDTO[] dto = new SalaryDTO[3];
		
		System.out.println("이름\t직급\t기본급\t수당\t세율\t세금\t월급");
		dto[0] = new SalaryDTO("홍길동", "부장", 5000000, 200000);
		dto[1] = new SalaryDTO("유재석", "과장", 3500000, 150000);
		dto[2] = new SalaryDTO("박명수", "사원", 1000000, 100000);
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		for(SalaryDTO dtodata : dto) {
			System.out.println(dtodata.getName()+"\t"+dtodata.getPosition()+"\t"+dtodata.getBasePay()
			+"\t"+dtodata.getBenefit()+"\t"+dtodata.getTaxRate()+"\t"+dtodata.getTax()+"\t"+df.format(dtodata.getSalary()));
		}
	}
}
