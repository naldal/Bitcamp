package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); //중복허용. 
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리"); //raw type. 1.제너릭을 설정  2.@suppressWarning
		
		Iterator it = coll.iterator();
		it.hasNext(); //현재위치에 항목 있으면 T 없으면 F
		it.next(); //현재 위치에 항목을 꺼내고 다음으로 이동
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
