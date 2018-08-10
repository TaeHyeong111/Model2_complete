package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch((String)map.get("flag")) {
		case "insert" : 
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "list":
			map.put("sql",MemberQuery.LIST.toString()); 
			break;
		case "count" : 
			map.put("sql", MemberQuery.COUNT.toString());
			break;
		}
		
	}
	@Override
	void startPlay() {
		switch((String)map.get("flag")) {
		case "list" : 
			try {
				pstmt = DatabaseFactory
							.createDatabase2(map)
							.getConnection()
							.prepareStatement(
									(String)map.get("sql"));
				pstmt.setString(1, map.get("beginRow").toString());
				pstmt.setString(2, map.get("endRow").toString());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "count" :
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
	}

	@Override
	void endPlay() {
		switch((String)map.get("flag")) {
		case "list" : 
			System.out.println("리스트진입");
			try {
				System.out.println("--ENDPLAY");
				ResultSet rs = pstmt.executeQuery();
				MemberBean member = null;
				while (rs.next()) {
					member = new MemberBean();
					member.setUserId(rs.getString("USERID"));
					member.setSsn(rs.getString("SSN"));
					member.setName(rs.getString("NAME"));
					member.setRoll(rs.getString("ROLL"));
					member.setTeamId(rs.getString("TEAMID"));
					member.setPassword(rs.getString("PASSWORD"));
					member.setAge(rs.getString("AGE"));
					member.setSubject(rs.getString("SUBJECT"));
					member.setGender(rs.getString("GENDER"));
					list.add(member);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		case "count" :
			try {
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(rs.getInt("COUNT"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}
}
