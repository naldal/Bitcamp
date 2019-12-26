package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiArray6 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int person;
		
		while(true) {
			System.out.print("인원수:");
			
		}
		
	}
}

/*
 인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
 평균은 소수이하 2째자리까지 출력 (가변길이 배열 사용)
 
 [실행결과]
 인원수:2 (cnt)
 
 이름입력: 홍길동(name)
 과목수입력:2 (subjectCnt)
 과목명입력:국어  (subject) 
 과목명 입력:영어
 국어 점수 입력:95 (jumsu)
 영어 점수 입력:100
------------------------
 이름입력: 이기자(name)
 과목수입력:3 (subjectCnt)
 과목명입력:국어  (subject) 
 과목명 입력: 영어
 과목명 입력: 과학
 국어 점수 입력:95 (jumsu)
 영어 점수 입력:100
 
... 
 -----------------
  이름  국어  영어   총점     평균
 홍길동 95 100 xxx xx.xx
 
  이름   국어 영어  과학   총점   평균
 이기자 95 100 90 xxx xx.xx
 */
