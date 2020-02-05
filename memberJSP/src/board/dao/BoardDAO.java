package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public boolean saveBoard(BoardDTO boardDTO) {
		boolean flag=false;
		String sql = "insert into board(seq, id, name, email, subject, content, ref) values (seq_board.nextval, ?, ?, ?, ?, ?, seq_board.nextval)";
		this.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2,  boardDTO.getName());
			pstmt.setString(3,  boardDTO.getEmail());
			pstmt.setString(4,  boardDTO.getSubject());
			pstmt.setString(5,  boardDTO.getContent());
			
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
	
}
