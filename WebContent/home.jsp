<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃을 위한 임시 홈</title>
</head>
<body>
<section>
<!-- 처음 요청이 들어오는 home.jsp에서 readIdx가 null일때만 session에 readIdx를 저장합니다. -->
<c:if test="${sessionScope.readIdx==null }"> 
	<%
		StringBuilder readIdx = new StringBuilder("/");
		session.setAttribute("readIdx", readIdx);
	%>
</c:if>
	<a href="list.do">커뮤니티 게시판</a>
	<c:if test="${sessionScope.user == null }">
		<a href="login.do">로그인</a>
	</c:if>
	<c:if test="${sessionScope.user != null }">
		<!--로그인된 상태  -->
		<br>${user.name }(${user.email }) 님 반갑습니다. <br>
		<a href = "minihome.do?u_idx=${user.idx }">미니홈페이지 들어가기</a>
		<a href="logout.do">로그아웃</a>
	</c:if>
</section>

</body>
</html>







