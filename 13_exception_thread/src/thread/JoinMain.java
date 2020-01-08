package thread;

class JoinTest implements Runnable{
	public JoinTest() {
	
	}

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
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

//-------------------

public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest();
		jt.run();
		
	}
}

//0.5초 씩마다 (500) 1 2 3 4 5 를 출력