<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title> Search BY ID</title>
</head>

<body>
	<h1> Search BY ID </h1>
	<form action="<%= ctx%>/member.do">
		User ID <input type="text" name="uid" />
		<input type="submit" value="전송" />
		<input type="hidden" name="action" value="SEARCH" />
		<input type="hidden" name="page" value="searchIDResult" />
	</form>
</body>
</html>
