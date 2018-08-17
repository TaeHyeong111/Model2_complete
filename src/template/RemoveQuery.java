package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, ((MemberBean) map.get("delete")).getUserId());
			pstmt.setString(2, ((MemberBean) map.get("delete")).getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
