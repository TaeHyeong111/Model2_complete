<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp" />
<div id="menu-box">
	<ul id="menu">
		<li><a id="moveHome" >HOME</a></li>
		<li><a id="moveAbout">ABOUT</a> </li>
		<li><a id="moveAdmin">ADMIN</a> </li>
	</ul>
</div>
<script>
document.getElementById('moveHome').addEventListener('click',
		function() {
		router.move({context : '${ctx}',
					domain : 'common'
					});
		});
document.getElementById('moveAbout').addEventListener('click',
		function() {
		router.move({context : '${ctx}',
					domain : 'member',
					action : 'move',
					page : 'mypage'});
		});
document.getElementById('moveAdmin').addEventListener('click',
		function() {
		admin.check("${ctx}")
		});
</script>