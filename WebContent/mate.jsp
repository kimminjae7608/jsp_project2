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

	<h4>${user.name }</h4>
	<br><br>
	<ul>
		<li>
			친구 목록 
		</li>
	<c:forEach var="mate" items="${matelist }">
		<li>${mate.nickName }  <a href ="deletefriend.do?u_idx=${user.idx }&v_idx=${mate.v_idx }"> 친구삭제</a></li>
	</c:forEach>
	
	</ul>
	
	<ul>
		<li>
			me to you
		</li>
	<c:forEach var="mate" items="${addmate }">
		<li>${mate.name} </li>
	</c:forEach>
	
	</ul>
	
	<ul>
		<li>
			you to me
		</li>
	<c:forEach var="mate" items="${waitingmate }">
		<li>  ${mate.name} <a href ="newfriend.do?u_idx=${user.idx }&v_idx=${mate.idx }"> 친구수락</a> </li>
	</c:forEach>
	
	</ul>
	
	<ul>
		<li>
			추천친구 
		</li>
	<c:forEach var="mate" items="${randommate }">
		<li> ${mate.name} <a href ="requestfriendaction.do?u_idx=${user.idx }&v_idx=${mate.idx }"> 친구 신청하기 </a></li>
	</c:forEach>
	
	</ul>
	

</body>
</html>