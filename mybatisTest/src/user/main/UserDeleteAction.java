package user.main;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = new UserDTO();
		
		System.out.println("삭제할 아이디를 입력하세요.");
		String id = sc.next();
		userDTO = userDAO.getUserId(id);
		
		if(userDTO==null) {
			System.out.println("삭제하고자 하는 아이디가 없습니다.");
		} else {
			userDTO.setName(userDTO.getName());
			userDTO.setId(userDTO.getId());
			userDTO.setPwd(userDTO.getPwd());
			
			userDAO.deleteUser(userDTO);			
			System.out.println("삭제되었습니다.");
		}
	}
}
