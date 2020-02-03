package member.dao;

import java.sql.*;

import member.bean.MemberDTO;

public class MemberDAO {

	private static MemberDAO instance;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcId = "c##java";
	private String jdbcPwd = "bit";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcId, jdbcPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean loginChecking(String id, String pwd) {
		String sql = "select name from member where id = ? and pwd = ?";
		getConnection();
		boolean row11 = false;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row11 = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return row11;
	}

	public boolean insert(String name, String id, String password, String gender, String email1, String email2,
			String tel1, String tel2, String tel3, String zipcode, String addr1, String addr2) {
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";
		this.getConnection();
		boolean row = false;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, gender);
			pstmt.setString(5, email1);
			pstmt.setString(6, email2);
			pstmt.setString(7, tel1);
			pstmt.setString(8, tel2);
			pstmt.setString(9, tel3);
			pstmt.setString(10, zipcode);
			pstmt.setString(11, addr1);
			pstmt.setString(12, addr2);

			row = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;

	}

	public boolean checkId(String id) {
		String sql = "select * from member where id = ?";
		this.getConnection();
		boolean row = false;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public static MemberDAO getinstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = " select * from member where id=?";

		this.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exist;
	}

	public int write(MemberDTO memeberDTO) {
		getConnection();

		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int su = 0;
		
		String name = memeberDTO.getName();
		String id = memeberDTO.getId();
		String pwd = memeberDTO.getPwd();
		String gender = memeberDTO.getGender();
		String email1 = memeberDTO.getEmail1();
		String email2 = memeberDTO.getEmail2();
		String tel1 = memeberDTO.getTel1();
		String tel2 = memeberDTO.getTel2();
		String tel3 = memeberDTO.getTel3();
		String zipcode = memeberDTO.getZipcode();
		String addr1 = memeberDTO.getAddr1();
		String addr2 = memeberDTO.getAddr2();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,  id);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.setString(5, email1);
			pstmt.setString(6, email2);
			pstmt.setString(7, tel1);
			pstmt.setString(8, tel2);
			pstmt.setString(9, tel3);
			pstmt.setString(10, zipcode);
			pstmt.setString(11, addr1);
			pstmt.setString(12, addr2);
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}
}
