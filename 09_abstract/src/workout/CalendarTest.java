package workout;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	
	private String[] calDow = {"일", "월", "화", "수", "목", "금", "토"};
	private String[][] calDate = new String[6][7];
	
	private int width = calDow.length;
	private int startDay;	//시작 요일
	private int lastDay;	//마지막 날짜 일요일=1
	private int inputDate=1;
	int year, month;
	
	public CalendarTest() {
		System.out.println("년도를 입력하시오.");
		this.year = sc.nextInt();
		
		System.out.println("월을 입력하시오.");
		this.month = sc.nextInt();
		
		if(month<1 || month>12){
            System.out.println("월은 1~12 사이의 숫자입니다.");
        }else{
            // Calendar에 년월일 셋팅
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month-1); //month : 0~11
            cal.set(Calendar.DATE, 1); //처음 숫자는 무조건 1로 시작
            
            startDay = cal.get(Calendar.DAY_OF_WEEK); //시작위치값 일요일- 1
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            
        }
	}
	
	public void calculator() {
     // 2차 배열에 날짜 입력
        int row = 0;
        for(int i=1; inputDate<=lastDay; i++){
        	
            // 시작 요일이 오기전에는 공백 대입
            if(i<startDay) {
            	calDate[row][i-1]="";
            } else{
                // 날짜 배열에 입력
                calDate[row][(i-1)%width]=Integer.toString(inputDate);
                inputDate++;
               
                // 가로 마지막 열에 오면 행 바꿈
                if(i%width==0) row++;
            }      
        }
    }
	
	public void display() {
		// "일월화수목금토"
        for(int i=0; i<width; i++){
            System.out.print(calDow[i]+"\t");
        }
        System.out.println();
       
        // 날짜 배열 출력
        int row=0;
        for(int j=1 ; j<lastDay+startDay; j++){
           
            System.out.print(calDate[row][(j-1)%width]+"\t");
           
            if((j-1)%width==width-1){
                System.out.println();
                row++;
            }
        }
	}
}

