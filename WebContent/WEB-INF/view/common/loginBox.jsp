<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="moveLoginForm"> LOGIN </a> &nbsp;&nbsp;&nbsp;	<!--  ""를 하는 이유는 js에서는 attribute 속성값을 준다 -->
	<a id="moveJoinForm">JOIN</a>
</div>


 <!-- 이거짤라다가 app.js에 common.main에 넣어야함 -->
<script>
	document.getElementById('moveLoginForm').addEventListener('click',
			function() {
				router.move({ctx : '${ctx}',
							domain : 'member',
							action : 'move',
							page : 'login'});
			});
	document.getElementById('moveJoinForm').addEventListener('click',
			function() {
				router.move({ctx : '${ctx}',
							domain : 'member',
							action : 'move', 
							page : 'add'});
			});
</script>
