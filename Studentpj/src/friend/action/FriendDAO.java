package friend.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FriendDAO {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection conn;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private static FriendDAO instance;
	
	public static FriendDAO getInstance() {
		if(instance==null) {
			synchronized(FriendDAO.class) {
				instance = new FriendDAO();
			}
		}
		return instance;
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
