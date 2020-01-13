package workout;

import java.text.NumberFormat; 
import java.util.Locale;

public class ChinaMoney extends Money{
	NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
	NumberFormat numberformat2 = NumberFormat.getCurrencyInstance(Locale.KOREA);
	double chinaMoney;

	@Override
	public void calcMoney(int cash) {
		chinaMoney = (double)cash * 0.006;
	}

	@Override
	public void dispMoney(int cash) {
		numberformat.setMinimumFractionDigits(0);
		numberformat2.setMinimumFractionDigits(0);
		System.out.println(numberformat2.format(cash)+"-->"+numberformat.format(chinaMoney));
	}

}
