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
			System.out.println("\t관리");
			System.out.println("*****************");
			System.out.println("  1. 입력 ");
			System.out.println("  2. 검색 ");
			System.out.println("  3. 삭제 ");
			System.out.println("  4. 종료 ");
			System.out.println("*****************");
			System.out.print("  번호 선택 : ");
			int num = scan.nextInt();

			if (num == 1) {
				insertArticle();
			} else if (num == 2) {
				selectArticle();
			} else if (num == 3) {
				deleteArticle();
			} else if (num == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		} // while
	}

	public void insertArticle() {
		String name = null;
		String value = null;
		int code = 0;

		while (true) {
			System.out.println("*****************");
			System.out.println("  1. 학생 ");
			System.out.println("  2. 교수 ");
			System.out.println("  3. 관리자 ");
			System.out.println("  4. 이전메뉴 ");
			System.out.println("*****************");
			System.out.print("  번호 선택 : ");
			int num = scan.nextInt();

			if (num == 4) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}

			System.out.print("이름 입력 : ");
			name = scan.next();
			code = num;

			if (num == 1) {
				System.out.print("학번 입력 : ");
				value = scan.next();
			} else if (num == 2) {
				System.out.print("과목 입력 : ");
				value = scan.next();
			} else if (num == 3) {
				System.out.print("부서 입력 : ");
				value = scan.next();
			} else {
				System.out.println("잘못된 번호입니다.");
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
					System.out.println(su + "개가 만들어졌습니다.");
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
			System.out.println("  1. 이름 검색 ");
			System.out.println("  2. 전체 검색 ");
			System.out.println("  3. 이전메뉴 ");
			System.out.println("*****************");
			System.out.print("  번호 선택 : ");
			int num = scan.nextInt();

			if (num == 3)
				break;

			if (num == 1) {
				System.out.print("검색할 이름 입력 : ");
				name = scan.next();
				sql = "select name, value, code from student where name like ?";
			} else if (num == 2) {
				sql = "select * from student";
			} else {
				System.out.println("잘못된 번호입니다.");
			}

			// DB
			conn = this.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				if (num == 1)
					pstmt.setString(1, "%" + name + "%");
				rs = pstmt.executeQuery();

				while (rs.next()) { // rs.next() => 현재 위치에서 레코드 유/무 파악 후 다음으로 이동
					if (rs.getInt("code") == 1) {
						System.out.println("이름 = " + rs.getString("name") + "\t" + "학번 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 2) {
						System.out.println("이름 = " + rs.getString("name") + "\t" + "과목 = " + rs.getString("value"));
					} else if (rs.getInt("code") == 3) {
						System.out.println("이름 = " + rs.getString("name") + "\t" + "부서 = " + rs.getString("value"));
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
		System.out.print("삭제를 원하는 이름 입력 : ");
		String name = scan.next();

		conn = this.getConnection();

		String sql = "delete student where name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			int su = pstmt.executeUpdate();
			System.out.println(su + "개가 삭제됐습니다.");
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