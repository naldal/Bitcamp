package collection;

import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<String,String>();
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); //Value 중복허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); //Key 중복허용
		
		//System.out.println(map.get("book101")); //최근 처리된 V출력
		
		//코드입력 : book501
		System.out.print("코드입력 : ");
		String val = sc.next();
		
		//if(map.get(key)==null) 도 가능
		if(!map.containsKey(val)) {
			System.out.println("없는 Key값입니다");
		} else {
			System.out.println(map.get(val));
		}
	}
}
