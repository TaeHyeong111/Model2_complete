package enums;

public enum MemberQuery {
	SELECT_LIST,LOGIN,INSERT_MEMBER,FINDBYID,COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_SOME;
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN :
			query = 
			"      SELECT USERID,"
			+ "    TEAMID,      "
			+ "    NAME,  "
			+ "    SSN,   "
			+ "    ROLL,  "
			+ "    PASSWORD,      "
			+ "	   AGE,			"
			+ "		GENDER,		"
			+ "		SUBJECT		"
			+ "    FROM MEMBER          "
			+ "    WHERE USERID LIKE '%s' AND PASSWORD LIKE '%s'           ";
			break;
		case INSERT_MEMBER : 
			query =
			"     INSERT INTO MEMBER "
			+ "    (USERID,PASSWORD,SSN,NAME,TEAMID,AGE,ROLL,GENDER)   "
			+ "   VALUES ('%s','%s','%s','%s','%s','%s','%s','%s') ";		
			break;
		case FINDBYID : 
			query =
             "    SELECT USERID, TEAMID, NAME, AGE, ROLL, PASSWORD, SSN, GENDER"
           + "    FROM MEMBER          "
           + "    WHERE USERID LIKE '%s' ";		
			break;
		case COUNT_MEMBER : 
			query =
             "      SELECT COUNT(*) AS count FROM MEMBER";		
			break;
		case UPDATE_MEMBER : 
			query =
            "      UPDATE MEMBER		" 
			+"		SET PASSWORD = '%s', TEAMID = '%s', ROLL = '%s'	" 
           +"		WHERE USERID LIKE '%s'	";		
			break;
		case DELETE_MEMBER : 
			query =
			"	DELETE FROM MEMBER "
			+ " WHERE USERID LIKE '%s'"
			+ " AND PASSWORD LIKE '%s'";
			break;		
		case SELECT_ALL : 
			query =
			"	SELECT USERID, TEAMID, NAME, AGE, ROLL, PASSWORD,SSN,GENDER FROM MEMBER "; 
			break;		
		case SELECT_SOME : 
			query =
			"	SELECT USERID, "
			+ "TEAMID, "
			+ "NAME, "
			+ "AGE, "
			+ "ROLL, "
			+ "PASSWORD, "
			+ "SSN, "
			+ "GENDER FROM MEMBER "
			+ " WHERE %s LIKE '%s'   "; 
			break;	
		case SELECT_LIST:
			query = 
			"select t.* " + 
			"from " + 
			"   (select rownum seq, m.* " + 
			"   from member m " + 
			"   order by seq desc) t "+ 
			"where t.seq between '%s' and '%s' "; 
			
		}
		
		
		return query;
	}
}





