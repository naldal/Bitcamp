package collection;

import java.util.*;

public class MapTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<String,String>();
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); //Value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); //Key �ߺ����
		
		//System.out.println(map.get("book101")); //�ֱ� ó���� V���
		
		//�ڵ��Է� : book501
		System.out.print("�ڵ��Է� : ");
		String val = sc.next();
		
		//if(map.get(key)==null) �� ����
		if(!map.containsKey(val)) {
			System.out.println("���� Key���Դϴ�");
		} else {
			System.out.println(map.get(val));
		}
	}
}
