<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp"/>
<body>
<div id="wrapper">
    <div id="header">
     <jsp:include page="common/titleBox.jsp"/>
      <jsp:include page="common/loginBox.jsp"/>
       <jsp:include page="common/menuBox.jsp"/>
    </div> <!-- header end -->
    <div id="content">
    <jsp:include page="common/contentBox.jsp"/>
    </div> <!-- content end -->
    <div id = "footer">
    <jsp:include page="common/footerBox.jsp"/>
    </div>
</div>
</body>
</html>


<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%! 
	int count = 0;
%>
	<meta charset="UTF-8" />
	<title>HELLO</title>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	현재 회원수 : <Mark>20명</Mark>
	<table class="width-full margin-auto height-1500">
	<tr>
		<th class="width-full height-500" colspan="2">
		<img id="width_height-full" class="margin-auto" src="img/home/main2.JPG" alt="">
		</th>
	</tr>
	<tr>
		<td class= "height-1000 width-60pt">
		<img class="width-full margin-auto height-full" src="img/home/mainbody.JPG" alt="">  </td>	
		<td> 
			<ul>
				<li> <a href="${ctx }/member.do?action=move&page=joinForm">  회원가입  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=userLoginForm"> 유저로그인  </a> </li>
				<li> <a href="${ctx }/admin.do?action=move&page=adminLogin">  관리자로그인  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=deleteForm">  유저삭제  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=updateForm">  정보수정  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=memberlist">  멤버리스트  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=searchTeamForm"> 팀이름찾기  </a> </li>
				<li> <a href="${ctx }/member.do?action=move&page=searchIDForm">  아이디찾기  </a> </li>

			</ul>
		</td>
	</tr>
	<tr class="height-500">			
		<td colspan="2">
		<div>
		<img class="width-full margin-auto height-full" src="img/home/bottom.JPG" alt="">
		</div>
		</td>
	</tr>
	</table>
		
</body>
</html> --%>