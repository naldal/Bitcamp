package workout;

import java.text.NumberFormat;
import java.util.Locale;

public class USMoney extends Money{
	NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.US);
	
	double usMoney;

	@Override
	public void calcMoney(int cash) {
		usMoney = (double)cash * 0.00086;
	}

	@Override
	public void dispMoney(int cash) {
		System.out.println(usMoney);
		numberformat.setMaximumFractionDigits(2);
		System.out.println(cash+"-->"+numberformat.format(usMoney));
	}

}
