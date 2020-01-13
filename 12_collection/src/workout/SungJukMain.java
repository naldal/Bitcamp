package workout;

public class SungJukMain {

	public static void main(String[] args) {
		SungJukService service = new SungJukService();
		service.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
