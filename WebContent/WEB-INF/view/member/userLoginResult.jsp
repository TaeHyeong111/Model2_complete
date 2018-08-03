<%@page import="dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%@ page import="service.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Login Result</title>
</head>
<body>
	<%
	MemberBean m = new MemberBean();
	m.setUserId(request.getParameter("userid"));
	m.setPassword(request.getParameter("password"));
	
	if(MemberServiceImpl.getInstance().login(m)){
		%>
		<h3> 로그인 성공 
		</h3>
		<%
	} else{
		%>
		<h3> 로그인 실패</h3>
		<%		
	}
%>
</body>
</html>