<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<div id="wrapper">
    <div id="header">
    <jsp:include page="../common/titleBox.jsp" />
    <jsp:include page="../common/menuBox.jsp" />
    </div>

    <div id="content">
    <form id="deleteForm" name="deleteForm">
        비밀번호 재입력 
        <input type="password" name="password" id="password" placeholder="비밀번호를  입력(8~20자)" />
        <input id="deleteFormBtn" type="button" value="제출"/>
        <input type="hidden" name="action" value="delete"/>    <!--홈페이지가려고 무브로햇는데 맞는지 모르겟음 -->
    </form>
    
    </div></div>
    <div id="footer">
        <jsp:include page="../common/footerBox.jsp" />
    </div>
    <script>
    	
        var form = document.getElementById("deleteForm"); 
        
        /* document가 가져올수 있는것은 객체만 가능하며 id를 부여한애만 객체임 */
        document.getElementById("deleteFormBtn").addEventListener('click',function(){
        	alert("${user.password}");
        	alert(form.password.value)
		if("${user.password}"===form.password.value){
			form.action ="${ctx}/member.do";
			form.method ="post";  /* get으로 하면 노출됨 */
			var node = document.createElement('input');
				node.setAttribute('type','hidden');
				node.setAttribute('name','action')
				node.setAttribute('value','delete')
				form.appendChild(node);
			form.submit();
		} else{
			alert('Wrong Password');
		}
	});
    </script>
    </body></html> 