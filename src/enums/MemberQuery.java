package enums;

public enum MemberQuery {
	LOGIN,INSERT_MEMBER,FINDBYID,COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_SOME;
	public String toString() {
		String query = "";
		switch(this) {
		case LOGIN :
			query = 
			"      SELECT MEM_ID,"
			+ "    TEAM_ID,      "
			+ "    NAME,  "
			+ "    SSN,   "
			+ "    ROLL,  "
			+ "    PASSWORD,      "
			+ "	   AGE,			"
			+ "		GENDER,		"
			+ "		SUBJECT		"
			+ "    FROM MEMBER          "
			+ "    WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s'           ";
			break;
		case INSERT_MEMBER : 
			query =
			"     INSERT INTO MEMBER "
			+ "    (MEM_ID,PASSWORD,SSN,NAME,TEAM_ID,AGE,ROLL,GENDER)   "
			+ "   VALUES ('%s','%s','%s','%s','%s','%s','%s','%s') ";		
			break;
		case FINDBYID : 
			query =
             "    SELECT MEM_ID, TEAM_ID, NAME, AGE, ROLL, PASSWORD, SSN, GENDER"
           + "    FROM MEMBER          "
           + "    WHERE MEM_ID LIKE '%s' ";		
			break;
		case COUNT_MEMBER : 
			query =
             "      SELECT COUNT(*) AS count FROM MEMBER";		
			break;
		case UPDATE_MEMBER : 
			query =
            "      UPDATE MEMBER		" 
			+"		SET PASSWORD = '%s', TEAM_ID = '%s', ROLL = '%s'	" 
           +"		WHERE MEM_ID LIKE '%s'	";		
			break;
		case DELETE_MEMBER : 
			query =
			"	DELETE FROM MEMBER "
			+ " WHERE MEM_ID LIKE '%s'"
			+ " AND PASSWORD LIKE '%s'";
			break;		
		case SELECT_ALL : 
			query =
			"	SELECT MEM_ID, TEAM_ID, NAME, AGE, ROLL, PASSWORD,SSN,GENDER FROM MEMBER "; 
			break;		
		case SELECT_SOME : 
			query =
			"	SELECT MEM_ID, "
			+ "TEAM_ID, "
			+ "NAME, "
			+ "AGE, "
			+ "ROLL, "
			+ "PASSWORD, "
			+ "SSN, "
			+ "GENDER FROM MEMBER "
			+ " WHERE %s LIKE '%s'   "; 
			break;		
		}
		
		return query;
	}
}





