package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이름, 국어, 영어, 수학을 입력 받아서 총점과 평균을 구하시오.
// 총점을 calcTot()에서 구해오기
// 평균은 calcAvg()에서 구해오기
// [실행결과]
// *** 홍길동 성적표 ***
//국어	영어	수학	총점	평균	
//92	100	85

public class MethodTest3 {

	public int calcTot(int i, int j, int k) {
		return i + j + k;
	}

	/*
	public double calcAvg(int i, int j, int k) {
		return (double) (i + j + k) / 3;
	}
	*/
	
	public double calcAvg(int tot) {
		return tot/3.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("이름을 입력해주세요 : ");
		String name = br.readLine();
		System.out.println("국어 점수를 입력해주세요 : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.println("영어 점수를 입력해주세요 : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.println("수학 점수를 입력해주세요 : ");
		int math = Integer.parseInt(br.readLine());

		MethodTest3 method3 = new MethodTest3();

		int tot = method3.calcTot(kor, eng, math);
		//double avg = method3.calcAvg(kor, eng, math);
		double avg = method3.calcAvg(tot);

		System.out.println("*** " + name + "의 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor + "점\t" + eng + "점\t" + math + "점\t" + tot + "점\t" + String.format("%.2f", avg) + "점");
		
	}
}
