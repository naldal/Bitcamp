package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userName = "c##java";
	private String password = "bit";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	public Student() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void menu() {
		while (true) {
			System.out.println("*****************");
			System.out.println("\t����");
			System.out.println("*****************");
			System.out.println("  1. �Է� ");
			System.out.println("  2. �˻� ");
			System.out.println("  3. ���� ");
			System.out.println("  4. ���� ");
			System.out.println("*****************");
			System.out.print("  ��ȣ ���� : ");
			int num = scan.nextInt();

			if (num == 1) {
				insertArticle();
			} else if (num == 2) {
				selectArticle();
			} else if (num == 3) {
				deleteArticle();
			} else if (num == 4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
		} // while
	}

	public void insertArticle() {
		String name = null;
		String value = null;
		int code = 0;

		while (true) {
			System.out.println("*****************");
			System.out.println("  1. �л� ");
			System.out.println("  2. ���� ");
			System.out.println("  3. ������ ");
			System.out.println("  4. �����޴� ");
			System.out.println("*****************");
			System.out.print("  ��ȣ ���� : ");
			int num = scan.nextInt();

			if (num == 4) {
				System.out.println("���� �޴��� ���ư��ϴ�.");
				break;
			}

			System.out.print("�̸� �Է� : ");
			name = scan.next();
			code = num;

			if (num == 1) {
				System.out.print("�й� �Է� : ");
				value = scan.next();
			} else if (num == 2) {
				System.out.print("���� �Է� : ");
				value = scan.next();
			} else if (num == 3) {
				System.out.print("�μ� �Է� : ");
				value = scan.next();
			} else {
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}

			// DB
			conn = this.getConnection();
			String sql = "insert into student(name, value, code) values(?, ?, ?)";

			if (code != 0) {
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, value);
					pstmt.setInt(3, code);

					int su = pstmt.executeUpdate();
					System.out.println(su + "���� ����������ϴ�.");
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
			}
		} // while
	}

	public void selectArticle() {
		String sql = null;
		String name = null;

		while (true) {
			System.out.println("*****************");
			System.out.println("  1. �̸� �˻� ");
			System.out.println("  2. ��ü �˻� ");
			System.out.println("  3. �����޴� ");
			System.out.println("*****************");
			System.out.print("  ��ȣ ���� : ");
			int num = scan.nextInt();

			if (num == 3)
				break;

			if (num == 1) {
				System.out.print("�˻��� �̸� �Է� : ");
				name = scan.next();
				sql = "select name, value, code from student where name like ?";
			} else if (num == 2) {
				sql = "select * from student";
			} else {
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}

			// DB
			conn = this.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if (num == 1)
					pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery();

				while (rs.next()) { // rs.next() => ���� ��ġ���� ���ڵ� ��/�� �ľ� �� �������� �̵�
					if (rs.getInt("code") == 1) {
						System.out.println("�̸� = " + rs.getString("name") + "\t" + "�й� = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.println("�̸� = " + rs.getString("name") + "\t" + "���� = " + rs.getString("value"));
					} else if (rs.getInt("code") == 3) {
						System.out.println("�̸� = " + rs.getString("name") + "\t" + "�μ� = " + rs.getString("value"));
					}
				} // while

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
		}//while
	}

	public void deleteArticle() {
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		String name = scan.next();

		conn = this.getConnection();

		String sql = "delete student where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "���� �����ƽ��ϴ�.");
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
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
	}
}