package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest {

	// ������ �̸� �Է� : ȫ , ȫ�� �� �̸��� ���̸� �ѻ� ����
	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		Connection con = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �̸��� �Է��Ͻÿ�");
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
				System.out.println("���� ����");
			else
				System.out.println("���� ����");
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
