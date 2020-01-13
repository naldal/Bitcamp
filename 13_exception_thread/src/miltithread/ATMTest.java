package miltithread;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable {
	private static long depositeMoney = 100000; // 잔액
	private static long balance; // 찾고자 하는 금액

	public static void main(String[] args) {
		ATMTest atm = new ATMTest();	//같은 클래스 파일에서 두개의 스레드를 만들어서 충돌시킴. 따라서 함수에 synchronized 걸어도 동기화 가능
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");

		mom.start();
		son.start();
	}

	@Override
	// public synchronized void run(){ - 동기화가 된다 = 한번에 한 쓰레드밖에 통과 못시킨다는 것
	public void run() {
		synchronized (this) { // - 동기화 됨
			// synchronized (ATMTest.class) { // - 동기화 됨
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
	}

	static public void withDraw() {
		if (balance % 10000 == 0) {
			depositeMoney -= balance;
			System.out.println("잔액은 " + depositeMoney + "입니다.");
		} else {
			System.out.println("만원단위로 입력하세요");
		}
	}
}
