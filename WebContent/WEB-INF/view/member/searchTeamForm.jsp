<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> Search Team Form</title>
</head>	
<body>	
	<h1> Search BY TEAM ID </h1>
<form action="<%= ctx%>/member.do">
	Team 이름  : <input type="text" name="teamid">
	<input type="hidden" name="action" value="RETRIEVE"/>
	<input type="hidden" name="page" value="searchTeamResult"/>
	<input type="submit" value="전 송" />
</form>
</body>
</html>
