package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {

	public InsertTest() {
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:xe", "c##java", "bit");
			System.out.println("connection success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public void InsertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int age = scan.nextInt();
		System.out.print("Ű �Է� : ");
		double height = scan.nextDouble();
		
		
		//======================================
		Connection conn = this.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into dbtest(name,age,height,logtime) values(?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql); // ���̵� ����
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);

			int su = pstmt.executeUpdate();// ���� - ������ ����

			System.out.println(su + "���� ����������ϴ�.");

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
		InsertTest it = new InsertTest();
		it.InsertArticle();
	}
}
