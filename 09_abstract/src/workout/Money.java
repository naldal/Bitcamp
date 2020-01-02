package workout;

import java.util.Scanner;

public abstract class Money {
	Scanner sc = new Scanner(System.in);
	
	public abstract void calcMoney(int cash);
	public abstract void dispMoney(int cash);
}
