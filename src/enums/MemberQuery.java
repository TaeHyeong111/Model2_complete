package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST,SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,
	LOGIN, 
	IMAGE;
	public String toString() {
		String sql = "";
		switch(this) {
		case INSERT : 
			sql =
			"INSERT INTO MEMBER("
			+ "USERID,"
			+ "TEAMID,"
			+ "NAME,"
			+ "ROLL,"
			+ "PASSWORD,"
			+ "SSN,"
			+ "SUBJECT,"
			+ "GENDER,"
			+ "AGE) " 
			+ "VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ) ";		
			break;
		case LIST:
			sql = 
			"select t.* " + 
			"from " + 
			"   (select rownum seq, m.* " + 
			"   from member m " + 
			"   order by seq desc) t "+ 
			"where t.seq between ? and ? "; 
				break;
		case SEARCH : 
			sql = 
			"select t.* " + 
			"from " + 
			"   (select rownum seq, m.* " + 
			"   from member m " + 
			"	WHERE %s LIKE ? " +
			"   order by seq desc) t "+ 
			"where t.seq between ? and ? "; 
				break;
		case RETRIEVE : 
			sql =
            "select * " 
            + " FROM MEMBER " 
            + " WHERE USERID " 
            + " LIKE ? ";
			break;
		case COUNT : 
			sql =
             "      SELECT COUNT(*) AS count FROM MEMBER";		
			break;
		case UPDATE : 
			sql =
            "UPDATE MEMBER " + 
            "SET PASSWORD = ? ," + 
            "SUBJECT = ? ," + 
            "ROLL = ? " + 
            "WHERE USERID LIKE ? ";
			break;
		case DELETE : 
			sql =
			"	DELETE FROM MEMBER "
			+ " WHERE USERID LIKE ? "
			+ " AND PASSWORD LIKE ? ";
			break;		
		case LOGIN :
			sql = 
			"      SELECT "
			+      "*" 
			+ "    FROM MEMBER          "
			+ "    WHERE USERID LIKE ? AND PASSWORD LIKE ?           ";
			break;
		}
		return sql;
	}
}





