package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.INSERT.toString());
	}

	@Override
	void startPlay() {
		try {
			System.out.println("여기는 스타트플레이");
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			mem = (MemberBean) map.get("insert");
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getTeamId());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getRoll());
			pstmt.setString(5, mem.getPassword());
			pstmt.setString(6, mem.getSsn());
			pstmt.setString(7, mem.getSubject());
			pstmt.setString(8, mem.getGender());
			pstmt.setString(9, mem.getAge());
			System.out.println("스타트플레이 맴 : "+mem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
