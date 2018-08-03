<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%@ page import="service.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
		<%
		MemberBean m = new MemberBean();
		m.setUserId(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		
		
		if (MemberServiceImpl.getInstance().login(m)){
			MemberServiceImpl.getInstance().deleteMemberInformation(m);
			%> 회원 삭제 완료 <%
		} else{
			%> 회원 삭제 정보 오류 <%
		}
		%>
</body>
</html>
