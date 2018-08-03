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
        <table id="mypage-table">  
        <tr>
            <th  rowspan='3'>사진 </th> 
            <th>아이디</th>
            <th colspan='2'>${user.userId} </th>
        </tr>
        <tr>
            <th>이름</th>
            <th colspan='2'>${user.name}</th>
        </tr>
        <tr>
            <th>비밀번호</th>
            <th colspan='2'>************</th>
        </tr>
        <tr>
            <th>나이</th>
            <th>${user.age}</th>
            <th>팀명</th>
            <th>${user.teamId}</th>
        </tr>
        <tr>
            <th>성별</th>
            <th>${user.gender}</th>
            <th>역할</th>
            <th>${user.roll}</th>
        </tr>
    </table>
   
    </div></div>
    <div id="footer">
        <jsp:include page="../common/footerBox.jsp" />
    </div>
    
</body></html>