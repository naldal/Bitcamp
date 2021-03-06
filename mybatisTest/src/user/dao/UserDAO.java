package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	public static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		
		//mybatis-config.xml 파일을 읽어서 SqlSessionFactory를 생성한다.
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		if(instance==null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}	
		}
		return instance;
	}
	
	
	public void userWrite(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.userWrite", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		
		sqlSession.close();
		return list;
	}

	public UserDTO getUserId(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUserId", id);

		sqlSession.close();
		return userDTO;
	}

	public void updateUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.updateUser", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public void deleteUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.deleteUser", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<UserDTO> getUserBy(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserBy", map);
		
		sqlSession.close();
		return list;
	}


}
