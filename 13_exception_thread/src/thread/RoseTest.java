package thread;

public class RoseTest extends Thread{
	private String name;
	
	public RoseTest(String name) {
		this.name=name;
	}
	
	public void run() { //내가 호출 할 수없음
		for(int i=1; i<=5; i++) {
			System.out.println(name+"\t"+Thread.currentThread()+"\t i="+i);
		}
		System.out.println(name+"  "+"종료");
	}
	
	public static void main(String[] args) {
		RoseTest aa = new RoseTest("안락"); //스레드 생성
		RoseTest bb = new RoseTest("행복"); //스레드 생성
		RoseTest cc = new RoseTest("쾌락"); //스레드 생성
		
		aa.setName("안락");
		bb.setName("행복");
		cc.setName("쾌락");
		
		//우선순위 1~10 (가장빨리끝내고 싶은것 10) default=5
		aa.setPriority(MAX_PRIORITY);
		bb.setPriority(5);
		cc.setPriority(MIN_PRIORITY); //100%보장하지는 않는다
		
		aa.start(); //스레드 시작 - 스레드 실행(운영체제 몫)
		try {
			aa.join(); //해당 스레드가 멈출때까지 다른 스레드는 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		bb.start(); //스레드 시작 - 스레드 실행(운영체제 몫) 
		cc.start(); //스레드 시작 - 스레드 실행(운영체제 몫)
	}
}