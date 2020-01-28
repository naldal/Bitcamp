package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	// 수정할 이름 입력 : 홍 , 홍이 들어간 이름의 나이를 한살 증가
	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Connection con = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("수정할 이름을 입력하시오");
		String cha1 = sc.next();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##java", "bit");
			String sql = "update dbtest set age=age+1 where name like ?";
			System.out.println(sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + cha1 + "%");
			int row = pstmt.executeUpdate();
			if (row > 0)
				System.out.println("삽입 성공");
			else
				System.out.println("삽입 실패");
			pstmt.close();

			String sql2 = "select * from dbtest";
			pstmt = con.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getString(1) + "\t" + rs.getInt(2) + "\t" + rs.getDouble(3) + "\t" + rs.getDate(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
