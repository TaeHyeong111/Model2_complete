package enums;

public enum Term {
	WEBPATH, MAIN;
	@Override
	public String toString() {
		String res = "";
		switch (this) {
		
		case WEBPATH:
			res = "/WEB-INF/view/";
			break;
		case MAIN:
			res = "/main.jsp";
			break;
		default:
			break;
		}
		return res;
	}
}
