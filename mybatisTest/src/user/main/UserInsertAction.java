package user.main;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	
	@Override
	public void execute() {
		//데이터	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름입력");
		String name = sc.next();
		System.out.println("아이디입력");
		String id = sc.next();
		System.out.println("비밀번호입력");
		String pwd = sc.next();
		
		UserDTO userDTO = new UserDTO();

		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//db
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.userWrite(userDTO);
		
		//응답
		System.out.println("데이터 저장완료");

	}

}
