package miltithread;

public class Synchronized extends Thread {

	private static int count;

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // ������ Ŭ���� �ּڰ��� ���� �浹��Ŵ. 
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");

		aa.start();
		bb.start();
		cc.start();
	}

	public void run() { // ����ȭ�� ���� ����...
		synchronized (Synchronized.class) {	// ����ȭ ��!! ==> this�� �ּڰ��� �� �ٸ��� ����. ������ class�� ��ü�� �ƹ��� ���Ƶ� �Ȱ��� �̸��� Ŭ������ ����Ƿ� ����ȭ ����.
			// synchronized(this){ // ����ȭ ���� ����
			for (int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : " + count);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} // for
		}
	}
}