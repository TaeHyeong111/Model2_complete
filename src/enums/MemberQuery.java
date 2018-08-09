package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST,SEARCH,RETRIEVE,COUNT,
	UPDATE,
	DELETE,
	LOGIN;
	public String toString() {
		String query = "";
		switch(this) {
		case INSERT : 
			query =
			"     INSERT INTO MEMBER ("
			+     ColumnFinder.find(Domain.MEMBER)   
			+ " ) "
			+ "   VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) ";		
			break;
		case LIST:
			query = 
			"select t.* " + 
			"from " + 
			"   (select rownum seq, m.* " + 
			"   from member m " + 
			"   order by seq desc) t "+ 
			"where t.seq between ? and ? "; 
				break;
		case SEARCH : 
			query = 
			"select t.* " + 
			"from " + 
			"   (select rownum seq, m.* " + 
			"   from member m " + 
			"	WHERE %s LIKE ? " +
			"   order by seq desc) t "+ 
			"where t.seq between ? and ? "; 
				break;
		case RETRIEVE : 
			query = " SELECT "
					+ ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " LIKE ? " 
					;
			break;
		case COUNT : 
			query =
             "      SELECT COUNT(*) AS count FROM MEMBER";		
			break;
		case UPDATE : 
			query =
            " UPDATE "
			+" MEMBER SET %s = ? "
            +" WHERE USERID LIKE ? ";
			break;
		case DELETE : 
			query =
			"	DELETE FROM MEMBER "
			+ " WHERE USERID LIKE '%s'"
			+ " AND PASSWORD LIKE '%s'";
			break;		
		case LOGIN :
			query = 
			"      SELECT "
			+      ColumnFinder.find(Domain.MEMBER) 
			+ "    FROM MEMBER          "
			+ "    WHERE USERID LIKE '%s' AND PASSWORD LIKE '%s'           ";
			break;
		}
		
		
		return query;
	}
}





