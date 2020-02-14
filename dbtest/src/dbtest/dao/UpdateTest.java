package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//������ �̸� �Է� : 
//ȫ�� �� �̸��� ���̸� 1�� ����

public class UpdateTest {

	public UpdateTest() {
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
			System.out.println("connection success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void UpdateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �̸� �Է� : ");
		String name = scan.next();

		// ================================

		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
//		String sql = "update dbtest set age = age+1 where name like '%"+name+"%'"; - O
//		String sql = "update dbtest set age = age+1 where name like '%?%'"; - X
		String sql = "update dbtest set age = age+1 where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");

			int su = pstmt.executeUpdate();

			System.out.println(su + "���� �����ƽ��ϴ�.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		UpdateTest ut = new UpdateTest();
//		ut.UpdateArticle();
		new UpdateTest().UpdateArticle();
	}
}
