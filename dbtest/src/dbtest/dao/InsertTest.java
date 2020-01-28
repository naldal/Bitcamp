package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class InsertTest {

	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Ŭ���� ���� (Ǯ ���� ��������)
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.45:1521:xe", "c##java", "bit");
			System.out.println("connection success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public void insertArticle() {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		
		System.out.print("���� �Է�");
		int age = sc.nextInt();
		
		System.out.print("Ű �Է�");
		double height = sc.nextDouble();
		
		//------------------------------------------------
		
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "insert into dbtest(name,age,height,logtime) values(?,?,?,sysdate)"; //�ڹ��ڵ�� �ڵ� Ŀ�Ե�
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);

			int su = pstmt.executeUpdate(); // ����. ������ ���ϵ�
			System.out.println(su + "���� ����������ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}

}
