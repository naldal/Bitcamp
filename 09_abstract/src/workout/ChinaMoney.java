package workout;

import java.text.NumberFormat;
import java.util.Locale;

public class ChinaMoney extends Money{
	NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.JAPAN);
	double chinaMoney;

	@Override
	public void calcMoney(int cash) {
		chinaMoney = cash * 0.006;
	}

	@Override
	public void dispMoney(int cash) {
		System.out.println(chinaMoney);
		numberformat.setMaximumFractionDigits(2);
		System.out.println(cash+"-->"+numberformat.format(chinaMoney));
	}

}
