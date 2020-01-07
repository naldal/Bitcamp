package collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("book001", "백설공주");
		map.put("book201", "인어공주");
		map.put("book101", "백설공주"); //Value 중복허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); //Key 중복허용
	}

}
