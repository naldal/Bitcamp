package instance;

/*
이름이 L(name)인 사람의 기본급(basePay)이 2500000일때
3.3% 세금(tax)과 월급(salary)을 계산하시오. 데이터는 반드시 변수에 저장하기.

세금 = 기본급 * 3.3%(0.033)
월급 = 기본급-세금
<실행 결과>
*** L의 월급 ***
기본급 : 2500000원
세금   : 82500원
월급   : 2417500원
 */
public class Practice3 {

	public static void main(String[] args) {
		String name ="L";
		int basePay = 2500000;
		int tax = (int) (basePay*0.033);
		int salary = basePay-tax;
		
		System.out.println("***L의 월급***");
		System.out.println("기본금"+basePay);
		System.out.println("세금"+tax);
		System.out.println("월금"+salary);
		
		
	}
}
