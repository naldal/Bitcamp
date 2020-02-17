package user.main;

import java.util.List;
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
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = UserDAO.getInstance();

		System.out.println("1. 이름검색");
		System.out.println("2. 아이디 검색");
		int num = sc.nextInt();
		String str;
		if (num == 1) {
			System.out.println("이름검색");
			str = sc.next();
			userDTO.setName(str);
			List<UserDTO> list = userDAO.getUserBy(userDTO);

			if (list == null) {
				System.out.println("찾고자 하는 이름이 없습니다.");
			} else {
				for (UserDTO data : list) {
					System.out.println(data.getName() + "\t" + data.getId() + "\t" + data.getPwd());
				}
			}
		} else if (num == 2) {
			System.out.println("아이디검색");
			str = sc.next();
			userDTO.setId(str);
			List<UserDTO> list = userDAO.getUserBy(userDTO);
			
			if (list == null) {
				System.out.println("찾고자 하는 아이디가 없습니다.");
			} else {
				for (UserDTO data : list) {
					System.out.println(data.getName() + "\t" + data.getId() + "\t" + data.getPwd());
				}
			}
		}

	}

}
