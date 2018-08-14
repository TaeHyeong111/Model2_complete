<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<h1>Login</h1>
	<form id="userLoginForm" name="userLoginForm">
		User ID : <input type="text" name="userid" /> <br>
		 Password : <input	type="text" name="password" /> 
		 <input id="loginFormBtn" type="button" value="submit" />  
		 <input type="hidden" name="action"	value="login" />
		  <input type="hidden" name="page" value="retrieve" />
	</form>

	<script>
	document.getElementById('loginFormBtn')
    .addEventListener('click',function(){ //클릭 했을때 일어나는 행동 // String, Object
	var x = service.nullChecker(
			[document.userLoginForm.userid.value,
			document.userLoginForm.password.value]);
    if(x.checker){
    var form = document.getElementById('userLoginForm');
    form.action = "${ctx}/member.do"
    form.method = "post";
    form.submit();
    }else{
    	alert(x.text);
    }	
    });
    </script>
</body>
</html>
