package abstract_1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {

	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat();
		
		//3�ڸ����� , ��� �Ҽ����� 3°�ڸ�
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##��");
		//��ȿ���ڰ� �ƴ� ���� ǥ������ �ʴ´�
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00��");
		//0�� ������ ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); //�޼ҵ带 �̿��� ����(�̱���)
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		nf4.setMaximumFractionDigits(2);
		nf4.setMinimumFractionDigits(2);
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); //�޼ҵ带 �̿��� ����(�̱���)
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.ITALY);
		nf5.setMaximumFractionDigits(0);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}
}
