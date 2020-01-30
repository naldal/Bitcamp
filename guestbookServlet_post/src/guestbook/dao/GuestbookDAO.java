package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.dto.GuestbookDTO;

//오라클과 연결하는 객체
public class GuestbookDAO {
	
	private static GuestbookDAO instance;
	private GuestbookDTO guestdto;
	
	private String url;
	private String id;
	private String password;
	
	private String driver = "oracle:jdbc:driver:OracleDriver";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GuestbookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static GuestbookDAO getinstance() {
		if(instance==null) {
			instance = new GuestbookDAO();
		} else {
			return instance;
		}
		return instance;
	}
	
	public boolean insert() {
		String sql = "insert into guestbook1 values(seq_guestbook1.nextval, "
				+ "?, ?, ?, ?, ?, sysdate";
		getConnection();
		
		boolean row=false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestdto.getName());
			pstmt.setString(2, guestdto.getEmail());
			pstmt.setString(3, guestdto.getHomepage());
			pstmt.setString(4, guestdto.getSubject());
			pstmt.setString(5, guestdto.getContent());
			
			row = pstmt.executeUpdate()>0;
			if(!row)
				System.out.println("insert error!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public List<GuestbookDTO> listing(int startNum, int endNum) {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		String sql = "select * from"
				+ "(select rownum rn, tt.* from"
				+ "(select seq, name, email, homepage, subject, content"
				+ "logtime(sysdate, 'YYYY.MM.DD') as logtime"
				+ "from guestbook1 order by seq desc) tt"
				+ "where rn>=? and rn<=?";
		getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestbookDTO guestdto = new GuestbookDTO();
				guestdto.setSeq(rs.getInt("seq"));
				guestdto.setName(rs.getString("name"));
				guestdto.setEmail(rs.getString("email"));
				guestdto.setHomepage(rs.getString("homepage"));
				guestdto.setContent(rs.getString("content"));
				guestdto.setLogtime (rs.getString("logdate"));
				
				list.add(guestdto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getTotalArticle() {
		int totalA=0;
		String sql = "select count(*) from guestbook";
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalA = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}
	

}
