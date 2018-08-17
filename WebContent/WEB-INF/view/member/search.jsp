<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	<div id = "content-box">
	<!-- table>tr*2>td*6 --> 
	<div id="searchBox">
	<form id="seachForm" name="seachForm">
	<input id="searchBtn" type="button" value="제출"/>
	<input id="searchWord" name="searchWord" type="text"  placeholder="검색어 입력"/>
	<select name="searchOption" id="searchOption">
		  <option value="userid">아이디</option>
		  <option value="name">이름</option>
		  <option value="teamid">팀명</option>
		  </select>
	</form>
	</div>
	<table id ="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 할</th>
			<th>팀 명</th>
		</tr>
		<c:forEach 	items="${list}" var="user">   <!-- for(Member m : arr){} -->
		<tr>
			<td>${user.userId}</td>
			<td><a class="username" id="${user.userId}" >${user.name}</a></td>
			<td>${user.age}</td>
			<td>${user.gender}</td>
			<td>${user.roll}</td>
			<td>${user.teamId}</td>
		</tr><!-- admin.do로 넘기고 멤버서비스임플점해서 끌어옴 / 이름을 눌럿더니 아이디가 나옴-->
		</c:forEach>
		<tr>
		<td colspan="6">
				전체회원수 : ${count}
				<ul class="pageBox" >
					<c:if test="${page.existPrev}">
						<li id="${page.prevBlock}" class="pageNumber">◀PREV</li>
					</c:if>
					<c:forEach begin="${page.beginPage}" 
						end="${page.endPage}" 
						step="1" varStatus="i">
						<li>
							<a id="${i.index}" class="pageNumber">
								${i.index}
							</a>
						</li>
					</c:forEach>
					<c:if test="${page.existNext}">
						<li id="${page.nextBlock}" class="pageNumber">NEXT▶</li>
					</c:if>
			</ul>
			
			
		 </td>
		</tr>
	</table>
	
</div>
<script>
    admin.main('${ctx}');
</script>
<!-- 
/* 콜백함수의 디스는 맨앞에있는녀석이다 */
디클러레이션 이파이
실행(익스큐션) 콜백함수 
리턴은 제이슨
제이슨안에 잇는애가 클로저  
값이 여러개지만 하나로 만드는게 스칼라방식으로 만든것임
즉 이파이패턴은 스칼라로 만든방식중 하나임
보안이 안걸려져잇으면 겟방식으로 보냄
갯방식이면 로케이션밖에 없음
포스트로 보내는방식은 form 태그 method="post" .submit밖에 없음
  d
form태그로는 post방식
get방식은 location.href=""로 보내야함
여기서 post와 get은 method=""를 의미함 . 
속도저하, 보안

리턴타입이 스칼라냐 백터냐
스칼라는 단수 백터는 복수

나를 다시호출하는것 재규호출 
현재의 내가 미래의 나를 호출하는 구조

attribute
class - document.querySelecter에서 호출시키려고 -> Array
id - document.getElementById value 꺼내기 -> object
Value - document.getElementById.value -> object (자바스크립트에서 가져오는거)
name - request.getParameter() dom객체 호출 -> Value (자바에서 가져오는방법)


-->
<%-- <c:forEach begin="1" end="${count %5 == 0 ? count/5 : count/5+1 }" step="1" var="i">
			<span>${i}</span>
			</c:forEach> --%>