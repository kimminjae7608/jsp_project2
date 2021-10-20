<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="css/minihome.css?v=3">
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
		<div class="box">
			<div class="miniprofile">	<!-- 프로필 이미지, 한줄소개 -->
				<div class="profileimage">	<!-- 프로필 이미지 삽입할 상자 -->
					<!-- <img alt="profile" src="img/프젝로고.png" style="margin: 10px; 
						width: 230px; height: 200px; border: 1px solid #f5b49c;"> -->
					<img alt="filename" src="/img/${bean.filename }" width="100%" height="100%"> 
				</div>
				<div class="shortintroduce">
					한줄 자기소개를 적을거에요! 현재 기분을 적어도 OK!
					<strong> <li>자기소개 : ${bean.introduce} </li></strong>
				</div>
			<input class="profileUpdate" type="button" value="등록 및 수정" 
					onclick="location.href='profileModify.do?idx=${user.idx }'">
			</div>
			<div class="introduce">	<!-- 상세 정보 -->
				<ul class="introduceinfo">
					<li>이름 : ${bean.name} </li>
					<li>나이 : ${bean.age} </li>
					<li>성별 : ${bean.gender}</li>
					<li>이메일 : ${bean.email} </li>
					<li>직업 : ${bean.job}</li>
					<li>취미 : ${bean.hobby}</li>
					<li>학교 : ${bean.school}</li>
					<li>MBTI : ${bean.mbti}</li>
				</ul>
			</div>
		</div>
	</div>	<!-- box end -->
</body>
</html>







