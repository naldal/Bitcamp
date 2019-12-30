package workout;

import java.util.Scanner;

public class MemberMain_1 {
	MemberDTO ar[]=new MemberDTO[5];
	Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		MemberMain_1 mm = new MemberMain_1();
		mm.menu();
		
		
	}
	
	public void menu() {
		while(true) {
			int num;
			System.out.println("*************");
			System.out.println("  1. 가입");
			System.out.println("  2. 출력");
			System.out.println("  3. 수정");
			System.out.println("  4. 탈퇴");
			System.out.println("  5. 끝내기");
			System.out.println("*************");
			System.out.print("  번호 : ");
			num=sc.nextInt();
			if(num==5) break;
			if(num==1) insert();
			if(num==2) this.list();
			if(num==3) this.update();
			if(num==4) delete();
		}
	}
	
	public void insert() {
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) 
			break;
		}
		
		if(i==5) {
			System.out.println("5명 정원이 꽉 찼습니다.");
			return; //메소드를 벗어나라!
		}
		
		//가입
		 System.out.print("이름 입력 : ");
		 String name=sc.next();
		 System.out.print("나이 입력 : ");
		 int age=sc.nextInt();
		 System.out.print("핸드폰 입력 : ");
		 String phone=sc.next();
		 
		 System.out.print("주소 입력 : ");
		 String address=sc.next();
		 
		 ar[i] = new MemberDTO(name, age, phone, address);
		 
		 int cnt=0;
		 System.out.println("1 row created");
		 
		 for(i=0; i<ar.length; i++) {
			 if(ar[i] == null) 
				cnt++; 
		 }
		 System.out.println(cnt+"자리가 남았습니다.");
	}
	
	public void list() {
		MemberMain mm= new MemberMain();
		
		System.out.println("name\tAge\tPhone\tAddress");
		for(int i=0; i<ar.length;i++) {
			if(ar[i]!=null) {
				System.out.println(
						ar[i].getName()
						+"\t"+ar[i].getAge()
						+"\t"+ar[i].getPhone()
						+"\t"+ar[i].getAddress());
				}
			}
		}
	
	public void update() {
		System.out.println("핸드폰 번호 입력: ");
		String phone = sc.next();
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null && ar[i].getPhone().equals(phone)) { //앞에가 참조건이어야 뒤에도 찾으러옴 처음부터 f떨어지면 안됨
				System.out.println(
						ar[i].getName()
						+"\t"+ar[i].getAge()
						+"\t"+ar[i].getPhone()
						+"\t"+ar[i].getAddress());
				//------------------
				
				System.out.print("수정 할 이름 입력 : ");
				ar[i].setName(sc.next());
				System.out.print("수정 할 핸드폰 입력 : ");
				ar[i].setPhone(sc.next());
				System.out.print("수정 할 주소 입력 : ");
				ar[i].setAddress(sc.next());
				
				System.out.println("1 row updated");
				 
				System.out.println(
							ar[i].getName()
							+"\t"+ar[i].getAge()
							+"\t"+ar[i].getPhone()
							+"\t"+ar[i].getAddress());
				 System.out.println(i+" row(s) updated");
				 break;
			} //if
		} //for
		
		if(i==5) {
			System.out.println("찾고자 하는 회원이 없습니다");
		}
	}
	
	public void delete(){
		System.out.println("핸드폰 번호 입력: ");
		String phone = sc.next();
		int i;
		
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null && ar[i].getPhone().equals(phone)) {
				ar[i] = null;
				System.out.println("1 row deleted");
				break;
			}
		}
		if(i==5)
			System.out.println("찾는 회원이 없습니다");
	}
}
