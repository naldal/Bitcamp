package thread;

class JoinTest implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest();
		Thread t = new Thread(jt);
		System.out.println("������ ����");
		t.start();
		try {
			t.join(); // ������ Ȧ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������ ����");
		// ������ ������ ������� ������� ����. ������ ����Ǿ ��׶��忡�� ������� ���ư���.
	}
}

//0.5�� ������ (500) 1 2 3 4 5 �� ���