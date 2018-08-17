package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery  extends QueryTemplate {
	@Override
	void initialize() {
		if(map.get("searchOption")!=null) {
			System.out.println("이프이프이프!!");
			map.put("sql",
					String.format(MemberQuery.SEARCH.toString(), 
							map.get("searchOption")));
		}else {
			System.out.println("이니셜라이징 엘스");
			map.put("sql", 
					String.format(MemberQuery.LIST.toString()));
			System.out.println("MemberQuery.LIST : "+MemberQuery.LIST.toString());
		}
	}
	@Override
	void startPlay() {
		if(map.get("searchOption")!=null) {
			try {
				pstmt.setString(1, "%"+map.get("searchWord").toString()+"%");
				pstmt.setString(2, map.get("beginRow").toString());
				pstmt.setString(3, map.get("rowCount").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				pstmt.setString(1, (String)map.get("beginRow").toString());
				pstmt.setString(2, (String)map.get("endRow").toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	void endPlay() {
		System.out.println("엔드플레이들어옴");
		try {
			rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				list.add(mem);
				System.out.println("서치쿼리의 멤버 : "+mem);
                }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}