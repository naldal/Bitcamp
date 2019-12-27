package workout;

import java.util.Scanner;

public class MemberMain {
	static Scanner sc = new Scanner(System.in);
	static MemberDTO[] dto = new MemberDTO[5];
	static int cnt=1;
	
	public static void main(String[] args) {
		MemberMain mm = new MemberMain();
		int inputInt;
		
		while(true) {
			System.out.println("***********");
			System.out.println("  1. 가입");
			System.out.println("  2. 출력");
			System.out.println("  3. 수정");
			System.out.println("  4. 탈퇴");
			System.out.println("  5. 끝내기");
			System.out.println("***********");
			System.out.print("번호 : ");
			inputInt = sc.nextInt();
			
			if(inputInt==5) {
				break;
			} else if(inputInt==1) {
				mm.insert();
			} else if(inputInt==2) {
				mm.list();
			} else if(inputInt==3) {
				mm.update();
			} else if(inputInt==4) {
				mm.delete();
			}
		}
	}//main
	
	public void insert() {
		System.out.print("이름 입력: ");
		String tmpName = sc.next();
		System.out.print("나이 입력: ");
		int tmpAge = sc.nextInt();
		System.out.print("핸드폰 입력: ");
		String tmpPhone = sc.next();
		System.out.print("주소 입력: ");
		String tmpAddress = sc.next();
		
		MemberDTO dtoInsert = new MemberDTO(tmpName, tmpAge, tmpPhone, tmpAddress);
		
		PHONE: for(int i=cnt-1; i<cnt; i++) {
				if(cnt>5) {
					System.out.println("5명의 정원이 꽉 찼습니다...");
					continue;
				} else {
					for(int j=0; j<i; j++) {
						if(dto[j].getPhone().equals(tmpPhone)){
							System.out.println("이미 해당 번호가 있습니다.");
							break PHONE;
						}
					}
				}
			dto[i] = dtoInsert;
			System.out.println("1 row created");
			System.out.println(dto.length-cnt+"자리 남았습니다");
			cnt++;
			break;
		}
	}
	
	
	public void list() { //전체회원
		System.out.println("이름\t나이\t핸드폰\t주소");
		for(int i=0; i<cnt-1; i++) {
			System.out.print(dto[i].getName()+"\t"+dto[i].getAge()
					+"\t"+dto[i].getPhone()+"\t"+dto[i].getAddress());
			System.out.println();
		}
		System.out.println();
	}
	
	public MemberDTO update() {
		System.out.println("핸드폰 번호 입력 :");
		String tmpUpdate = sc.next();
		int i;
		//MemberDTO dtoUpdate = new MemberDTO();
		
		for(i=0; i<cnt-1; i++) {
			if(dto[i].getPhone().equals(tmpUpdate)) {
				System.out.println(dto[i].getName()+"\t"+
						dto[i].getAge()+"\t"+
						dto[i].getPhone()+"\t"+
						dto[i].getAddress());
				
				System.out.println("수정 할 이름 입력 : ");
				tmpUpdate = sc.next();
				dto[i].setName(tmpUpdate);
				
				System.out.println("수정 할 핸드폰 입력");
				tmpUpdate = sc.next();
				dto[i].setPhone(tmpUpdate);
				
				System.out.println("수정 할 주소 입력");
				tmpUpdate = sc.next();
				dto[i].setAddress(tmpUpdate);
				
			} else {
				System.out.println("찾는 회원이 없습니다.");
			}
		}
		return dto[i];
	}
	
	public void delete() {
		System.out.println("핸드폰 번호 입력 :");
		String tmpDelete = sc.next();
		int i;
		for(i=0; i<cnt; i++) {
			if(dto[i].getPhone().equals(tmpDelete)) {
				dto[i]=dto[i+1];
				cnt--;
				System.out.println("탈퇴되셨습니다.");
			} else {
				System.out.println("찾는 회원이 없다");
			}
		}
	}
}
