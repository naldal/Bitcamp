package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##java", "bit");

			String sql2 = "select name, age, height, to_char(logtime, 'YYYY.MM.DD') as logtime from dbtest";
			pstmt = con.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") 
						+ "\t" + rs.getInt("age") 
						+ "\t" + rs.getDouble("height") 
						+ "\t" + rs.getString("logtime"));
			}

		} catch (Exception e) {
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
	}
}
