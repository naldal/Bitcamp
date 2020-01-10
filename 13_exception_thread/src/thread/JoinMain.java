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
		System.out.println("스레드 시작");
		t.start();
		try {
			t.join(); // 스레드 홀딩
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드 종료");
		// 메인이 끝나도 스레드는 종료되지 않음. 메인이 종료되어도 백그라운드에서 스레드는 돌아간다.
	}
}

//0.5초 씩마다 (500) 1 2 3 4 5 를 출력