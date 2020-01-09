package miltithread;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable{
	private static long depositeMoney = 100000; //�ܾ�
	private static long balance; //ã���� �ϴ� �ݾ�
	
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();
		Thread mom = new Thread(atm, "����");
		Thread son = new Thread(atm, "�Ƶ�");
		
		mom.start();
		son.start();
	}

	@Override
	public synchronized void run(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Thread.currentThread().getName());
		
		try {
			System.out.println("ã���� �ϴ� �ݾ� �Է� : ");
			balance = Long.parseLong(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		withDraw();
	}
	
	static public void withDraw(){
		if(balance % 10000 == 0) {
			depositeMoney -= balance;
			System.out.println("�ܾ��� "+depositeMoney+"�Դϴ�.");
		} else {
			System.out.println("���������� �Է��ϼ���");
		}
	}
}
