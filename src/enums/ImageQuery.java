package enums;

public enum ImageQuery {
	INSERT,
	READ;
	public String toString() {
		String sql = "";
		switch(this) {
		case INSERT : 
			sql = 
			" INSERT INTO IMAGE(IMGSEQ,IMGNAME,EXTENSION, USERID) "
			+ " VALUES (IMG_SEQ.NEXTVAL,?,?,?) "
		;
		break;
		case READ :
			sql = 
				"SELECT " 
				+ " IMGSEQ, IMGNAME, EXTENSION, USERID " 
				+ " FROM IMAGE " 
				+ " WHERE USERID LIKE ?"
			;
			break;
		}
		return sql;
	}
}
