package board.dao;

import java.io.IOException; 
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;


public class BoardDAO {
	
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static BoardDAO getInstance() {
		if(instance==null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	public BoardDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public int getTotalArticle() {	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalArticle");
		sqlSession.close();
		return totalA;
	}
	
	public List<BoardDTO> getBoardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.getBoardList", map);
		sqlSession.close();
		return list;
	}
	
	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	public void boardModify(Map<String, String> map) {		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void boardHit(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardHit", seq);
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardReply(Map<String, String> map) {
		BoardDTO pDTO = getBoard(Integer.parseInt(map.get("pseq"))); //원글
		SqlSession sqlSession = sqlSessionFactory.openSession();
		map.put("ref", pDTO.getRef()+"");
		map.put("lev", pDTO.getLev()+1+"");
		map.put("step", pDTO.getStep()+1+"");
		
		//글순서
		//update board set step=step+1 where ref = 원글 ref and step > 원글step
		sqlSession.update("boardSQL.boardReply1", pDTO);
		
		//답글쓰기
		//insert into board values
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//답글 수 
		//update board set reply = reply+1 where seq=원글번호		
		sqlSession.update("boardSQL.boardReply3", pDTO.getSeq());
		
		sqlSession.commit();
		sqlSession.close();
	}

	public void boardDelete(int seq) {	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("boardSQL.boardDelete", seq);
		
		sqlSession.commit();
		sqlSession.close();
	}
}
