package workout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiArray6 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name, subject ="";
		int cnt, subjectCnt, jumsu, sum=0;
		double avg=0.0;
		
		System.out.print("인원수: ");
			cnt=Integer.parseInt(br.readLine());
			String[][] ar = new String[cnt*2][];
			
			for(int i=0; i<ar.length; i+=2) {
				System.out.print("이름입력: ");
				name = br.readLine();
				
				System.out.print("과목수 입력: ");
				subjectCnt = Integer.parseInt(br.readLine());
				ar[i] = new String[subjectCnt+3];
				ar[i+1] = new String[subjectCnt+3];
				
				ar[i][0]="이름";
				ar[i+1][0] = name;
				
				for(int j=0; j<subjectCnt; j++) {
					System.out.print("과목명 입력: ");
					subject = br.readLine();
					ar[i][j+1] = subject;
					
					ar[i][subjectCnt+1] = "총점";
					ar[i][subjectCnt+2] = "평균";
				} // for j
				
				for(int k=0; k<subjectCnt; k++) {
					System.out.print(ar[i][k+1]+" 점수 입력 : ");
					jumsu = Integer.parseInt(br.readLine());
					ar[i+1][k+1] = jumsu+"";
					
					sum+=jumsu;
						
				}
				
				ar[i+1][subjectCnt+1]=sum+"";
				
				avg = (double)sum/subjectCnt;
				sum=0;
				ar[i+1][subjectCnt+2] = String.format("%.2f",avg);
				
			}//for i
			
			for(int i=0; i<ar.length; i++) {
				for(int j=0; j<ar[i].length; j++) {
					System.out.print(ar[i][j]+"\t");
				}
				System.out.println();
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
