package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		Collection coll = new ArrayList();
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); //�ߺ����. 
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���"); //raw type. 1.���ʸ��� ����  2.@suppressWarning
		
		Iterator it = coll.iterator();
		it.hasNext(); //������ġ�� �׸� ������ T ������ F
		it.next(); //���� ��ġ�� �׸��� ������ �������� �̵�
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
