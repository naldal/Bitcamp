package workout;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
	Scanner sc = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	
	private String[] calDow = {"��", "��", "ȭ", "��", "��", "��", "��"};
	private String[][] calDate = new String[6][7];
	
	private int width = calDow.length;
	private int startDay;	//���� ����
	private int lastDay;	//������ ��¥ �Ͽ���=1
	private int inputDate=1;
	int year, month;
	
	public CalendarTest() {
		System.out.println("�⵵�� �Է��Ͻÿ�.");
		this.year = sc.nextInt();
		
		System.out.println("���� �Է��Ͻÿ�.");
		this.month = sc.nextInt();
		
		if(month<1 || month>12){
            System.out.println("���� 1~12 ������ �����Դϴ�.");
        }else{
            // Calendar�� ����� ����
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month-1); //month : 0~11
            cal.set(Calendar.DATE, 1); //ó�� ���ڴ� ������ 1�� ����
            
            startDay = cal.get(Calendar.DAY_OF_WEEK); //������ġ�� �Ͽ���- 1
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            
        }
	}
	
	public void calculator() {
     // 2�� �迭�� ��¥ �Է�
        int row = 0;
        for(int i=1; inputDate<=lastDay; i++){
        	
            // ���� ������ ���������� ���� ����
            if(i<startDay) {
            	calDate[row][i-1]="";
            } else{
                // ��¥ �迭�� �Է�
                calDate[row][(i-1)%width]=Integer.toString(inputDate);
                inputDate++;
               
                // ���� ������ ���� ���� �� �ٲ�
                if(i%width==0) row++;
            }      
        }
    }
	
	public void display() {
		// "�Ͽ�ȭ�������"
        for(int i=0; i<width; i++){
            System.out.print(calDow[i]+"\t");
        }
        System.out.println();
       
        // ��¥ �迭 ���
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

