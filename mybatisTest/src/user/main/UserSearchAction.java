package user.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		/*
		 * 1. 이름검색 2. 아이디검색 만약에 1번이면 찾고자 하는 이름 입력 : 홍 .. user Mapper에서 <select id=
		 * getUserId> 하나만 사용하기
		 */
		Scanner sc = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();

		System.out.println("1. 이름검색");
		System.out.println("2. 아이디 검색");
		int num = sc.nextInt();
		String value = null;
		String columnName = null;
		
		if (num == 1) {
			System.out.println("이름검색");
			value = sc.next();
			columnName = "name";
		
		} else if (num == 2) {
			System.out.println("아이디검색");
			value = sc.next();
			columnName = "id";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		List<UserDTO> list = userDAO.getUserBy(map);
		
		for(UserDTO userDTO: list) {
			System.out.println(userDTO.getName() +"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		}
		

	}

}
