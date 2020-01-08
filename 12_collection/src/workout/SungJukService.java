package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukService {
	Scanner sc = new Scanner(System.in);
	ArrayList<SungJukDTO> arraylist = new ArrayList<SungJukDTO>();
	
	public void menu() {
		
		int input;
		while(true) {
			System.out.println("*************");
			System.out.println("    1.입력");
			System.out.println("    2.출력");
			System.out.println("    3.검색");
			System.out.println("    4.삭제");
			System.out.println("    5.정렬");
			System.out.println("    6.끝");
			System.out.println("*************");
			
			System.out.println("번호 선택 : ");
			input=sc.nextInt();
			if(input==6) {
				break;
			} else if (input==1) {
				insertArticle();
			} else if (input==2) {
				display();
			} else if (input==3) {
				searchArticle();
			} else if (input==4) {
				deleteArticle();
			} else if (input==5) {
				sortArticle();
			}
		}
	} //menu()
	
	public ArrayList<SungJukDTO> insertArticle(){
		System.out.println("학생번호를 입력하시오");
		int num = sc.nextInt();
		System.out.println("이름를 입력하시오");
		String name = sc.next();
		System.out.println("국어성적을 입력하시오");
		int kor = sc.nextInt();
		System.out.println("영어성적을 입력하시오");
		int eng = sc.nextInt();
		System.out.println("수학성적을 입력하시오");
		int math = sc.nextInt();
		
		SungJukDTO dto = new SungJukDTO();
		dto = new SungJukDTO(num, name, kor, eng, math);
		dto.setAvg();
		dto.setTot();
		arraylist.add(dto);
		
		return arraylist;
	} //putIn()
	
	public void display() {
		System.out.println("번호 \t 이름 \t 국어 \t 영어 \t 수학 \t 평균 \t 총점");
		for(SungJukDTO dto : arraylist) {
			System.out.println(dto.getNum()+"\t"+dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+dto.getAvg()+"\t"+dto.getTot());
		}
	}
	
	public void searchArticle() {
		System.out.println("검색 할 이름 입력 :");
		String name = sc.next();
		
		System.out.println("번호 \t 이름 \t 국어 \t 영어 \t 수학 \t 평균 \t 총점");
		for(int i=0; i<arraylist.size(); i++) {
			if(name.equals(arraylist.get(i).getName())){
				System.out.println(arraylist.get(i).getNum()+"\t"+
						arraylist.get(i).getName()+"\t"+arraylist.get(i).getKor()+
						"\t"+arraylist.get(i).getEng()+"\t"+arraylist.get(i).getMath()+
						"\t"+arraylist.get(i).getAvg()+"\t"+arraylist.get(i).getTot());
			} else {
				System.out.println("찾는 이름이 없습니다.");
			}
		}
	} //3
	
	public void deleteArticle() {
		System.out.println("삭제 할 이름 입력 :");
		String name = sc.next();
		
		for(int i=0; i<arraylist.size(); i++) {
			if(name.equals(arraylist.get(i).getName())){
				arraylist.remove(i);
				i--;
			}
		}
		System.out.println("데이터가 삭제되었습니다.");
	}//4
	
	public void sortArticle() {
		System.out.println("1. 이름으로 오름차순");
		System.out.println("2. 총점으로 오름차순");
		int input = sc.nextInt();
		if(input==2) {
			Collections.sort(arraylist);
			System.out.println("번호 \t 이름 \t 국어 \t 영어 \t 수학 \t 평균 \t 총점");
			for(SungJukDTO dto : arraylist) {
				System.out.println(dto.getNum()+"\t"+dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+dto.getAvg()+"\t"+dto.getTot());
			}
		} else if(input==1) {
			Comparator<SungJukDTO> newdto = new Comparator<SungJukDTO>() {
				
				@Override
				public int compare(SungJukDTO dto1, SungJukDTO dto2) {
					return dto1.getName().compareTo(dto2.getName());
				}
			};
			Collections.sort(arraylist, newdto);
			System.out.println("번호 \t 이름 \t 국어 \t 영어 \t 수학 \t 평균 \t 총점");
			for(SungJukDTO dto : arraylist) {
				System.out.println(dto.getNum()+"\t"+dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath()+"\t"+dto.getAvg()+"\t"+dto.getTot());
			}
		}
		
	}
}


















