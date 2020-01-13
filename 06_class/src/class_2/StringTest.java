package class_2;

public class StringTest {

	public static void main(String[] args) {
		
		String a = "apple"; //literal 생성
		String b = "apple";
		if(a==b) System.out.println("a와 b의 참조값은 같다");  //참조 값 주소비교
		else System.out.println("a와 b의 참조값은 다르다");
		if(a.equals(b)) System.out.println("a와 b의 참조값은 같다"); //값자체 비교
		else System.out.println("a와 b의 참조값은 다르다");
		System.out.println();

		//싱글톤 : 메모리에 계속 생성하는 게 아니라 하나만 생성하고 그것을 가져다가 씀 (딱 한번만 new하게끔 만들어야함)
		//싱글톤을 하려면 스테틱 영역을 사용해야함
		
		String c = new String("apple");
		String d = new String("apple");
		if(c==d) System.out.println("c와 d의 참조값은 같다");
		else System.out.println("c와 d의 참조값은 다르다");
		
		if(c.equals(d)) System.out.println("a와 b의 참조값은 같다");
		else System.out.println("a와 b의 참조값은 다르다");
		System.out.println();
		
		String e = "오늘 날짜는 "+2019+12+30;
		System.out.println("e = "+e);
		
		/*
		 * 문자열은 편집이 안되므로 메모리에 4번 생성된다
		 * JVM에 의해서 삭제시 Garbage Collector로 보낸다
		 * Garbage Collector가 실행되면 컴퓨터는 멈춘다
		 * 
		 * "오늘 날짜는 " 
		 * "오늘 날짜는 2019"
		 * "오늘 날짜는 201912"
		 * e----> "오늘 날짜는 20191230"
		 *  
		 */
		
		System.out.println("문자열 크기 = "+e.length());
		
		for(int i=0; i<e.length(); i++) {
			System.out.println(i+" : "+e.charAt(i));
		}
		
		System.out.println("부분 문자열 추출="+e.substring(7));
		System.out.println("부분 문자열 추출="+e.substring(7,11));
		
		System.out.println("대문자 변경 ="+"Hello".toUpperCase());
		System.out.println("소문자 변경 ="+"Hello".toLowerCase());
		
		System.out.println("문자열 검색="+e.indexOf("짜"));
		System.out.println("문자열 검색="+e.indexOf("날짜"));
		System.out.println("문자열 검색="+e.indexOf("개바부")); //-1
	}
}
