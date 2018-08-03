<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "service.*" %>
<%@ page import = "domain.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> Search ID Result</title>
</head>
<body>
	<% 
	MemberBean m = MemberServiceImpl.getInstance().findById(request.getParameter("uid"));
	%>
	<table border="white">
		<tr> 
			<th>이름 </th>
			<th>TEAM ID</th>  
			<th>ID</th> 
			<th>AGE</th> 
			<th>ROLL</th> 
			<th>SSN</th>
		</tr>
		<tr> 
			<td> <%= m.getName() %> </td>
			<td> <%= m.getTeamId() %> </td>
			<td> <%= m.getUserId() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
		</tr> 
	</table>
</body>
</html>
