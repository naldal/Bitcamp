package kr.co.admincamp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.admincamp.dto.Admin;

public class AdminDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public AdminDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	public void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	protected int getSeq() throws SQLException {
		int seq = 0;
		connect();
		String sql = "select num.nextval as seq from dual";
		System.out.println(seq);

		Statement stmt;

		stmt = jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			seq = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		return seq;
	}

	public boolean insertEmp(Admin admin) throws SQLException {
		String sql = "INSERT INTO EMP(id, name, address, email, position, salary, gender) values (?,?,?,?,?,?,?)";
		connect();

		int seq = getSeq();
		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, seq);
		pstmt.setString(2, admin.getName());
		pstmt.setString(3, admin.getAddress());
		pstmt.setString(4, admin.getEmail());
		pstmt.setString(5, admin.getPosition());
		pstmt.setString(6, admin.getSalary());
		pstmt.setString(7, admin.getGender());

		boolean rowInserted = pstmt.executeUpdate() > 0;
		pstmt.close();
		disconnect();

		return rowInserted;
	}

	public List<Admin> listAllEmp() throws SQLException {
		List<Admin> listAdmin = new ArrayList<Admin>();

		String sql = "SELECT * FROM EMP";
		connect();

		Statement stmt = jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			String position = rs.getString("position");
			String salary = rs.getString("salary");
			String gender = rs.getString("gender");

			Admin admin = new Admin(id, name, address, email, position, salary, gender);
			listAdmin.add(admin);
		}

		rs.close();
		stmt.close();
		disconnect();

		return listAdmin;

	}

	public boolean deleteEmp(Admin admin) throws SQLException {
		String sql = "DELETE FROM EMP WHERE id=?";

		connect();

		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, admin.getId());

		boolean rowDeleted = pstmt.executeUpdate() > 0;
		pstmt.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateEmp(Admin admin) throws SQLException {
		String sql = "UPDATE EMP SET name = ?, address = ?, email = ?, position = ?, salary = ?, gender = ? WHERE id = ?";
		connect();

		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, admin.getName());
		pstmt.setString(2, admin.getAddress());
		;
		pstmt.setString(3, admin.getEmail());
		pstmt.setString(4, admin.getPosition());
		pstmt.setString(5, admin.getSalary());
		pstmt.setString(6, admin.getGender());
		pstmt.setInt(7, admin.getId());

		boolean rowUpdate = pstmt.executeUpdate() > 0;

		pstmt.close();
		disconnect();
		return rowUpdate;

	}
	
	public Admin getEmpById(int id) throws SQLException {
		Admin admin = null;
		String sql = "SELECT * FROM EMP WHERE id = ?";
		
		connect();
		
		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			String position = rs.getString("position");
			String salary = rs.getString("salary");
			String gender = rs.getString("gender");
	
			admin = new Admin(id, name, address, email, position, salary, gender);
		}
		
		rs.close();
		pstmt.close();
		disconnect();
		
		return admin;
	}
	
	public Admin getEmpByName(String name) throws SQLException {
		Admin admin = null;
		String sql = "SELECT * FROM EMP WHERE name = ?";
		
		connect();
		
		PreparedStatement pstmt = jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("id");
			String address = rs.getString("address");
			String email = rs.getString("email");
			String position = rs.getString("position");
			String salary = rs.getString("salary");
			String gender = rs.getString("gender");
	
			admin = new Admin(id, name, address, email, position, salary, gender);
		}
		
		rs.close();
		pstmt.close();
		disconnect();
		
		return admin;
	}

	//TODO : add search by address, email, position, salary, gender. 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
