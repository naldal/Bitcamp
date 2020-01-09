package miltithread;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable{
	private static long depositeMoney = 100000; //잔액
	private static long balance; //찾고자 하는 금액
	
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName());
		
		try {
			System.out.println("찾고자 하는 금액 입력 : ");
			balance = Long.parseLong(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		withDraw();
	}
	
	static public void withDraw(){
		if(balance % 10000 == 0) {
			depositeMoney -= balance;
			System.out.println("잔액은 "+depositeMoney+"입니다.");
		} else {
			System.out.println("만원단위로 입력하세요");
		}
	}
}
