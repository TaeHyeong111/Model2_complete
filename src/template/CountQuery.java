package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",MemberQuery.COUNT.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String)map.get("sql"));
			System.out.println(pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
			number = Integer.parseInt(rs.getString("count"));}
			System.out.println("넘버 : "+number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
