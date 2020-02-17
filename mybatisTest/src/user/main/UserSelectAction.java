package user.main;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectAction implements UserAction {

	@Override
	public void execute() {
		//db
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.getUserList();

		for(UserDTO data : list) {
			System.out.println(data.getName()+"\t"+data.getId()+"\t"+data.getPwd());
		}
	}

}
