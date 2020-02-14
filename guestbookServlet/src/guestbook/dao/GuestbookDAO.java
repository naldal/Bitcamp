package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
	private static GuestbookDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static GuestbookDAO getInstance() {
		if (instance == null) {
			synchronized (GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}

	public GuestbookDAO() {
		try {
			Class.forName(driver);
//			System.out.println("driver 설정 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("conn 연결 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public int getSeq() {
//		int seq = 0;
//		getConnection();
//		String sql = "select seq_guestbook.nextval from dual";
//		System.out.println("seq완료");
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			rs.next();
//			seq = rs.getInt(1);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return seq;
//	}

	public void write(GuestbookDTO guestbookDTO) {
//		int su=0;
		String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
		getConnection();
//		System.out.println("write완료");
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, guestbookDTO.getSeq());
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getSubject());
			pstmt.setString(5, guestbookDTO.getContent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		return su;
	}

	public List<GuestbookDTO> getGuestbookList(int startNum, int endNum) {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		getConnection();
		String sql = "select * from" 
				+ "(select rownum rn, tt.* from"  
				+ "(select seq, name, email, homepage, subject, content"
				+ ", to_char(logtime, 'YYYY.MM.DD') as logtime "
				+ "from guestbook order by seq desc)tt" 
				+ ")where rn>=? and rn<=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setSubject(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getString("logtime"));

				list.add(guestbookDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public int getTotalArticle() {
		int totalA =0;
		getConnection();
		String sql = "select count(*) from guestbook";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			totalA = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
}
