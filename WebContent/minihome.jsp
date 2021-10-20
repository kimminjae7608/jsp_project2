<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	하루 방문수 : ${homeuser.todayCount }	
	총 방문수 : ${homeuser.totalCount }	
	
	<ul>
	<%-- <li> 사용자 이름 : ${user.name }</li> --%>
	<!-- 사용자 이름 session에서 가져오는 거라서 수정이 안됨! -->
	<li> 사용자 이름 : ${name }</li>
	<li> 타이틀 : ${homeuser.title }</li>
	</ul>
	<br>
	<ul>
	<li> 친구목록수 : ${count}</li>
	
	<c:forEach var="mate" items="${ mlist }">
		<li>
			${ mate.nickName}<a href ="minihome.do?u_idx=${mate.v_idx }">
			미니홈페이지들어가기 </a> 	
		</li>
			<!-- guestbook.do?u_idx=${user.idx }&v_idx=${mate.v_idx } -->
		
			
	</c:forEach>
	
	
	</ul>
	<br><br><br>	
	${readIdx }
	<br>
	${user.idx} 
	<br>
	${ homeuser.u_idx }
	<br>
	<c:if test="${user.idx == homeuser.u_idx }">
		<a href ="mateAction.do?u_idx=${user.idx }"> 친구 목록으로 가기</a>
		<a href ="guestbook.do?u_idx=${user.idx }">내 방명록 보기</a>
		<a href ="profileMain.do?idx=${user.idx }">프로필</a>
	</c:if>
	
	
	<c:if test="${user.idx != homeuser.u_idx }">
		<span><a href ="guestbookadd.do?u_idx=${user.idx }&v_idx=${homeuser.u_idx }">방명록남기기</a></span> 
	
	</c:if>
	
</body>
</html>