package miltithread;

public class Synchronized extends Thread {

	private static int count;

	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); // 세개의 클래스 주솟값을 만들어서 충돌시킴. 
		Synchronized bb = new Synchronized();
		Synchronized cc = new Synchronized();

		aa.setName("aa");
		bb.setName("bb");
		cc.setName("cc");

		aa.start();
		bb.start();
		cc.start();
	}

	public void run() { // 동기화가 되지 않음...
		synchronized (Synchronized.class) {	// 동기화 됨!! ==> this는 주솟값을 다 다르게 잡음. 하지만 class는 객체가 아무리 많아도 똑같은 이름의 클래스를 만드므로 동기화 가능.
			// synchronized(this){ // 동기화 되지 않음
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