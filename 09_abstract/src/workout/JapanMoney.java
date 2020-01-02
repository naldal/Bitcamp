package workout;

import java.text.NumberFormat;
import java.util.Locale;

public class JapanMoney extends Money{
	NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
	NumberFormat numberformat2 = NumberFormat.getCurrencyInstance(Locale.KOREA);
	double japanMoney;
	
	@Override
	public void calcMoney(int cash) {
		japanMoney = (double)cash * 0.094;
	}

	@Override
	public void dispMoney(int cash) {
		numberformat.setMaximumFractionDigits(2);
		numberformat.setMinimumFractionDigits(0);
		numberformat2.setMaximumFractionDigits(2);
		numberformat2.setMinimumFractionDigits(0);
		System.out.println(numberformat2.format(cash)+"-->"+numberformat.format(japanMoney));
	}

}
