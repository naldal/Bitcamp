package member.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.bean.ZipcodeDTO;
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

	public String loginChecking(String id, String pwd) {
		String sql = "select name from member where id = ? and pwd = ?";
		getConnection();
		String row11 = "";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				row11 = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			row11 = null;
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

	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();

		String sql = "select * from newzipcode where sido like ? and nvl(sigungu, '0') like ? and roadname like ?";
		this.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + sido + "%");
			pstmt.setString(2, "%" + sigungu + "%");
			pstmt.setString(3, "%" + roadname + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));
				zipcodeDTO.setSigungu(rs.getString("sigungu") == null ? "" : rs.getString("sigungu"));
				zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));
				zipcodeDTO.setRi(rs.getString("ri") == null ? "" : rs.getString("ri"));
				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname") == null ? "" : rs.getString("buildingname"));

				list.add(zipcodeDTO);
			}
			System.out.println("list add 완료");

		} catch (SQLException e) {
			e.printStackTrace();
			list = null; // 오류시 반드시 list를 null로 초기화시키자.
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemberDTO findInfo(String id) {
		this.getConnection();
		String sql = "select * from member where id = ?";
		MemberDTO memberdto = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberdto.setName(rs.getString("name"));
				memberdto.setId(rs.getString("id"));
				memberdto.setPassword(rs.getString("pwd"));
				memberdto.setGender(rs.getString("gender"));
				memberdto.setEmail1(rs.getString("email1"));
				memberdto.setEmail2(rs.getString("email2"));
				memberdto.setTel1(rs.getString("tel1"));
				memberdto.setTel2(rs.getString("tel2"));
				memberdto.setTel3(rs.getString("tel3"));
				memberdto.setZipcode(rs.getString("zipcode"));
				memberdto.setAddr1(rs.getString("addr1"));
				memberdto.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberdto=null;
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return memberdto;
	}

	public boolean checkId(String id) {
		String sql = "select * from member where id = ?";
		this.getConnection();
		boolean row = false;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				row = true;
			}

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
		String pwd = memeberDTO.getPassword();
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
			pstmt.setString(2, id);
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
	
	public int update(MemberDTO memeberDTO) {
		getConnection();

		String sql = "update member set name = ?,"
				+ "pwd = ? ,"
				+ "gender = ? ,"
				+ "email1 = ? ,"
				+ "email2 = ? ,"
				+ "tel1 = ? ,"
				+ "tel2 = ? ,"
				+ "tel3 = ? ,"
				+ "zipcode = ? ,"
				+ "addr1 = ? ,"
				+ "addr2 =  ?"
				+ "where id = ?";

		int su = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memeberDTO.getName());
			pstmt.setString(2, memeberDTO.getPassword());
			pstmt.setString(3, memeberDTO.getGender());
			pstmt.setString(4, memeberDTO.getEmail1());
			pstmt.setString(5, memeberDTO.getEmail2());
			pstmt.setString(6, memeberDTO.getTel1());
			pstmt.setString(7, memeberDTO.getTel2());
			pstmt.setString(8, memeberDTO.getTel3());
			pstmt.setString(9, memeberDTO.getZipcode());
			pstmt.setString(10, memeberDTO.getAddr1());
			pstmt.setString(11, memeberDTO.getAddr2());
			pstmt.setString(12, memeberDTO.getId());
			
			su = pstmt.executeUpdate();
			System.out.println("su : "+su);
		} catch (Exception e1) {
			e1.printStackTrace();
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
