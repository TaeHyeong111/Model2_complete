package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pool.DBConstant;

//Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user1", "user1"); 
//Statement stmt = conn.createStatement();

public class TestDAO {
	private static TestDAO intance = new TestDAO();
	public static TestDAO getIntance() {return intance;}
	private TestDAO() {}
	public List<String> ls = null;
	
	public List<String> list() {
		ls =  new ArrayList<>();
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = 
					DriverManager.getConnection(
							DBConstant.CONNECTION_URL, 
							DBConstant.USERNAME,
							DBConstant.PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = String.format(
					"	SELECT AGE,SSN "
					+ "	FROM MEMBER	"
					);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ls.add(rs.getString("AGE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
