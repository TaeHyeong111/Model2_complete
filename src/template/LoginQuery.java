package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.LOGIN.toString()));
	}
	//ddd v
	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			mem = (MemberBean) map.get("mem");
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	void endPlay() {
		try {
			rs = pstmt.executeQuery(); //쿼리실행, 반환값이 resultset
			while(rs.next()) {
				o = (MemberBean)map.get("mem");
				((MemberBean)o).setUserId(rs.getString("MEMID"));
				((MemberBean)o).setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
