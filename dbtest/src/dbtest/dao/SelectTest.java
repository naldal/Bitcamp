package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##java", "bit");
			System.out.println("Connection success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void selectArticle() {
		 
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//String sql = "select * from dbtest";
		String sql = "select name, age, height, to_char(logtime, 'YYYY.MM.DD') as logtime from dbtest";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t" // rs.getString(1);
						+ rs.getInt("age") + "\t" // rs.getInt(2);
						+ rs.getDouble("height") + "\t" // rs.getDouble(3);
						+ rs.getString("logtime"));  //rs.getString(4);
				
				//rs.next() -> 현재 위치에 레코드 유무 (true/false)
				//알려준 뒤 다음으로 이동.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e ){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new SelectTest().selectArticle();
	}
}
