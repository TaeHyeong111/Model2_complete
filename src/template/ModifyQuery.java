package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class ModifyQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.UPDATE.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, ((MemberBean) map.get("modify")).getPassword());
			pstmt.setString(2, ((MemberBean) map.get("modify")).getSubject());
			pstmt.setString(3, ((MemberBean) map.get("modify")).getRoll());
			pstmt.setString(4, ((MemberBean) map.get("modify")).getUserId());
			
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
