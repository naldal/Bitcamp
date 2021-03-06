package imageboard.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO<K> {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static ImageboardDAO getInstance() {
		if(instance==null) {
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void imageboardWrite(ImageboardDTO imageboardDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(imageboardDTO.getImage1());
		sqlSession.insert("imageboardSQL.imageboardWrite", imageboardDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ImageboardDTO> imageboardList(Map<String, Integer> map) {
		List<ImageboardDTO> list;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList("imageboardSQL.imageboardList", map);
		
		sqlSession.close();
		return list;
	}

	public ImageboardDTO imageboardView(int seq) {
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		imageboardDTO = sqlSession.selectOne("imageboardSQL.imageboardView", seq);
		
		return imageboardDTO;
	}

	public void imageboardDelete(String[] seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		for(int i=0; i<seq.length; i++) {
//			sqlSession.delete("imageboardSQL.imageboardDelete", Integer.parseInt(seq[i]));
//		}
		Map<String, String[]> map = new HashMap<>();
		map.put("array", seq);
		sqlSession.delete("imageboardSQL.imageboardDelete2", map);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public int getImageboardTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("imageboardSQL.getImageboardTotalA");
		sqlSession.close();
		return totalA;
	}
	
}
