package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;

public class PstmtQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", String.format(
				" SELECT "
				+ ColumnFinder.find(Domain.MEMBER)
				+ " FROM %s "
				+ " WHERE %s "
				+ " LIKE ? ",
				map.get("table"),
				map.get("column"))); 
	}
	@Override
	void startPlay() {
		System.out.println("======================1");
		System.out.println(map.get("sql"));
		//System.out.println("나아는 베엘류"+map.get("value"));
		//System.out.println("나는맵맵"+map);
		try {
			pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement(
								(String)map.get("sql"));
			pstmt.setString(1,
					"%"+map.get("value").toString()+"%");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			System.out.println("--ENDPLAY");
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while (rs.next()) {
				member = new MemberBean();
				member.setUserId(rs.getString("USERID"));
				member.setTeamId(rs.getString("TEAMID"));
				member.setName(rs.getString("NAME"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setSsn(rs.getString("SSN"));
				member.setGender(rs.getString("GENDER"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
