<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.*" %>
<%@ page import="domain.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Update result</title>
</head>
<body>
<%
	MemberBean m = new MemberBean();
	m.setUserId(request.getParameter("userid"));
	m.setPassword(request.getParameter("password"));
	
	if (MemberServiceImpl.getInstance().login(m)){
		m.setPassword(request.getParameter("newpassword"));
		MemberServiceImpl.getInstance().updateMemberInformation(m);
		%> 비밀번호 변경 완료 <%
	} else{
		%> 비밀번호 오류 <%
	}
	
%>
</body>
</html>