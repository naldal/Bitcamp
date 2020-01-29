package guestbook.bean;

import java.sql.*;

import guestbook.dao.GuestbookDTO;

public class GuestbookDAO {

	private static GuestbookDAO instance;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcId = "c##java";
	private String jdbcPwd = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestbookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcId, jdbcPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getSeq() {
		int seq=0;
		getConnection();
		String sql = "select seq_guestbook.nextval as seq from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seq = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return seq;
	}
	
	public static GuestbookDAO getinstance() {
		if(instance==null) {
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}
	
	public GuestbookDTO insert(GuestbookDTO guest) {
		GuestbookDTO dto = null;
		int seq = getSeq();
		getConnection();
		String sql = "insert into guestbook values(?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.setString(2, guest.getName());
			pstmt.setString(3, guest.getEamil());
			pstmt.setString(4, guest.getHomepage());
			pstmt.setString(5, guest.getSubject());
			pstmt.setString(6, guest.getContent());
			
			pstmt.executeUpdate();
			
			String sql2 = "select * from guestbook";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new GuestbookDTO(rs.getInt(1), 
						rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getString(7)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	
	
}
