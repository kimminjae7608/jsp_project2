<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>갤러리</title>
<link rel="stylesheet" href="css/view.css?v=3">
</head>
<body>
<div class="button">
		<div class="loginout">
			<c:if test="${sessionScope.user == null}">
				<b><a href="login.do">로그인</a></b>
			</c:if>
			<c:if test="${sessionScope.user != null}">
				${user.name}(${user.email}) 님 &nbsp;
				<b><a href="logout.do">로그아웃</a></b>
			</c:if>
		</div>
</div>
	<div class="pagebox">	<!-- 일단 만든.. ul 태그..~ -->
		<div class="nav">
			<ul class="navlist">
				<li><a href="home.do?idx=${user.idx }">홈</a></li>
				<li><a href="profileMain.do?idx=${user.idx }">프로필</a></li>
				<li><a href="mate.jsp">친구추가</a></li>
				<li><a href="freeboard">게시판</a></li>
				<li><a href="gallery.do?idx=${user.idx }">갤러리</a></li>
				<li><a href="guestbook.jsp">방명록</a></li>
			</ul>
		</div>
	<div class="box">	<!-- 페이지마다 달라지는 내용 -->
		<div class="gallery">
		<li> ${user.name }님의 사진첩을 꾸며보세요. </li>
		<input class="upbtn" type="button" value="사진 올리기" onclick="location.href='galleryRegist.do?idx=${user.idx}'">
		<hr>
		<c:forEach var="vo" items="${glist}">	
			<ul class="main">
			<li>
				<ul class="row">
					<li>제목</li>	
					<li>${vo.title}</li>
				</ul>
			</li>
			<li>
				<ul class="row">
					<li>작성날짜</li>
					<li><fmt:formatDate value="${vo.gdate}" type="both"/></li>
					<li>조회수</li>
					<li>${gcount}</li>
					<!-- pattern="yyyy-MM-dd HH:mm", type = date, time, both -->
				</ul>
			</li>
			<li><hr></li>
			<li id="content">
				<ul>
					<li>사진!!!</li>	
					<del><img alt="gallery" src="/img/${vo.filename }" width="50%" height="30%"> </del>			
					<li>
						<pre>${vo.gcontent}</pre>
					</li>	
				</ul>
				
			</li>
		</ul>
			<input class="btn" type="button" value="수정" 
			onclick="location.href='galleryUpdate.do?idx=${vo.idx}'"><!--갤러리테이블 자체의 idx  -->
			<input class="btn" type="button" value="삭제" onclick="location.href='delete.do?idx=${vo.idx}'">
			<hr>
		</c:forEach>
		</div>
	</div>
</div>	<!-- pagebox end -->
</body>
</html>