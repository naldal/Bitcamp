package imageboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private DataSource ds;
	
	public static ImageboardDAO getInstance() {
		if(instance==null) {
			synchronized (ImageboardDAO.class) {
				instance = new ImageboardDAO();
			}
		}
		return instance;
	}
	
	public ImageboardDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean imageboardWrite(ImageboardDTO imageboardDTO) {
		boolean flag=false;
		String sql = "insert into imageboard values(seq_imageboard.nextval, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imageboardDTO.getImageid());
			pstmt.setString(2, imageboardDTO.getImagename());
			pstmt.setInt(3, imageboardDTO.getImageprice());
			pstmt.setInt(4, imageboardDTO.getImageqty());
			pstmt.setString(5, imageboardDTO.getImagecontent());
			pstmt.setString(6, imageboardDTO.getImage1());
			
			flag = pstmt.executeUpdate()>0;
			
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
		
		return flag;
	}
	
}
