package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이"); //중복허용 안됨, 순서없음 ,, 장점: 똑같은 데이터가 있어도 메모리에 한번밖에 안잡힘
		set.add("기린");
		set.add("코끼리");
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
