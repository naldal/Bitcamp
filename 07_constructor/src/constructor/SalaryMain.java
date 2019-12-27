package constructor;

import java.text.DecimalFormat;

public class SalaryMain {

	public static void main(String[] args) {
		SalaryDTO[] dto = new SalaryDTO[3];
		
		System.out.println("�̸�\t����\t�⺻��\t����\t����\t����\t����");
		dto[0] = new SalaryDTO("ȫ�浿", "����", 5000000, 200000);
		dto[1] = new SalaryDTO("���缮", "����", 3500000, 150000);
		dto[2] = new SalaryDTO("�ڸ��", "���", 1000000, 100000);
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		for(SalaryDTO dtodata : dto) {
			System.out.println(dtodata.getName()+"\t"+dtodata.getPosition()+"\t"+dtodata.getBasePay()
			+"\t"+dtodata.getBenefit()+"\t"+dtodata.getTaxRate()+"\t"+dtodata.getTax()+"\t"+df.format(dtodata.getSalary()));
		}
	}
}
