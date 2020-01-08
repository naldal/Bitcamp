package collection;

import java.util.Iterator;
import java.util.Vector;



public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		System.out.println("벡터 크기 = "+v.size());
		System.out.println("벡터 용량 = "+v.capacity()); //기본용량 10개, 10개씩 증가
		System.out.println();
		
		System.out.println("항목추가");
		for(int i=1; i<=10; i++) {
			v.add(i+"");
		}
		
		System.out.println("벡터 크기 = "+v.size());
		System.out.println("벡터 용량 = "+v.capacity());
		System.out.println();
		
		v.addElement(5+"");//중복허용
		System.out.println("벡터 크기 = "+v.size());
		System.out.println("벡터 용량 = "+v.capacity());
		System.out.println();
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+" ");
		}
		System.out.println();
		
		
		//v.remove("5");
		//뒤에있는 5제거 하려면 '인덱스'제공
		v.remove(10);
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5,2); //기본용량 5개, 2개씩 증가
	}
}
