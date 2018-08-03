<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />
	<title>Admin Login</title>
	<link rel="stylesheet" href="../../css/style.css">
</head>
<body id="login_box" >
	<h1>Admin Login</h1>
	<form action="../mypage/mypage.jsp" id="login_style">
	Admin ID :<br>
	<input type="text" name="admin_id" value="Mickey"> <br>	
	Password :<br>
	<input type="text" name="password" value="mouse">
	<br><br>
	<input type="submit" value="login">
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="admin_login" />
	</form>
</body>
</html>