package collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("book001", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book101", "�鼳����"); //Value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); //Key �ߺ����
	}

}
