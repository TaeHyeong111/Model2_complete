<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "domain.*" %>
<%@ page import = "service.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Member List</title>
</head>
<body>
	<%
		List<MemberBean> lst = MemberServiceImpl.getInstance().listMember();
%>
	<h1>  Member List</h1>
	<table border="white"> 
	<tr> 
		<th>이름 </th>
		<th>TEAM ID</th>  
		<th>ID</th> 
		<th>AGE</th> 
		<th>ROLL</th> 
		<th>SSN</th>
		<th>PASSWORD</th>

	</tr>

	<%	
		for(MemberBean m : lst){
		%> <tr> 
			<td> <%= m.getName() %> </td>
			<td> <%= m.getTeamId() %> </td>
			<td> <%= m.getUserId() %> </td>
			<td> <%= m.getAge() %> </td>
			<td> <%= m.getRoll() %> </td>
			<td> <%= m.getSsn() %> </td>
			<td> <%= m.getPassword() %> </td>
			</tr> 
			<% }  %>
			
	</table>
	
	

	
	
	
</body>

</html>