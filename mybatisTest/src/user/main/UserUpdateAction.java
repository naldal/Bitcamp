package user.main;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = new UserDTO();
		
		System.out.println("수정할 아이디를 입력하세요");
		String id = sc.next(); 
		userDTO = userDAO.getUserId(id);
		
		if(userDTO==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		} else {	
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
	
			System.out.println("수정할 이름 입력");
			String name = sc.next();
			System.out.println("수정할 비밀번호 입력");
			String pwd = sc.next();
			
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			userDAO.updateUser(userDTO);
			System.out.println("수정되었습니다.");
		}
	}
}
