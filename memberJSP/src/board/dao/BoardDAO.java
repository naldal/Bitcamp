package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.bean.BoardDTO;
import member.dao.MemberDAO;

public class BoardDAO {

	private static BoardDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcId = "c##java";
	private String jdbcPwd = "bit";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcId, jdbcPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getinstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	public boolean boardWrite(Map<String, String> map) {
		boolean flag=false;
		String sql = "insert into board(seq, id, name, email, subject, content, ref) values (seq_board.nextval, ?, ?, ?, ?, ?, seq_board.nextval)";
		this.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("eamil"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			flag = pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	public int getTotalBoard() {
		int totalA=0;
		String sql = "select count(*) from board";
		this.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalA = rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from" + 
				"(select rownum rn, tt.* from" +
				"(select * from board order by seq desc) tt" + 
				") where rn>=? and rn<=?";
		this.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setSubject(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));
				boardDTO.setReply(rs.getInt("reply"));				
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				
				list.add(boardDTO);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
