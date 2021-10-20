<%@page import="com.jcpdev.dto.TotalProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정</title>
<link rel="stylesheet" href="css/updateview.css?v=3">
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
	<div class="pagebox">
		<div class="nav">	<!-- 그 메뉴바... 일걸요..? -->
			<ul class="navlist">
				<li><a href="home.do?idx=${user.idx }">홈</a></li>
				<li><a href="profileMain.do?idx=${user.idx }">프로필</a></li>
				<li><a href="mate.jsp">친구추가</a></li>
				<li><a href="freeboard">게시판</a></li>
				<li><a href="gallery.do?idx=${user.idx }">갤러리</a></li>
				<li><a href="guestbook.jsp">방명록</a></li>
			</ul>
		</div>
		<form action="profileUpdate.do" method="post" enctype="multipart/form-data">	
		<div class="box">	<!-- 페이지마다 달라지는 내용 -->
			<div class="updatebox">
				<input type ="hidden" name="idx" value= ${user.idx }>
				<table>
			 	<tr><th width="25%">이름</th>
			 		<td>${bean.name}</td>
			 	</tr>
			    <tr><th>나이</th>
			 		<td>${bean.age}</td>
			 	</tr>
			 	<tr><th>성별</th>
			 		<td><input type="radio" value="M" name="gender" checked>남자
						<input type="radio" value="F" name="gender">여자
			 	</tr> 
			 	<tr><th>이메일</th>
			 		<td>${bean.email}</td>
			 	</tr>
			 	<tr><th>생일</th>
					<td>${user.birth}</td>
			 	</tr>
			 	<tr><th>취미</th>
			 		<td><input type="text" name="hobby" size="70" value="${bean.hobby}"></td>
			 	</tr>
			 	<tr><th>학교</th>
			 		<td><input type="text" name="school" size="70" value="${bean.school}"></td>
			 	</tr>
			 	<tr><th>직업</th>
			 		<td><input type="text" name="job" size="70" value="${bean.job}"></td>
			 	</tr>
			 	<tr><th>MBTI</th>
			 		<td><input type="radio" value="ISTJ" name="mbti" checked>ISTJ
						<input type="radio" value="ISFJ" name="mbti">ISFJ
						<input type="radio" value="INFJ" name="mbti">INFJ
						<input type="radio" value="INTJ" name="mbti">INTJ
						<input type="radio" value="ISTP" name="mbti">ISTP
						<input type="radio" value="ISFP" name="mbti">ISFP
						<input type="radio" value="INFP" name="mbti">INFP
						<input type="radio" value="INTP" name="mbti">INTP<br>
						<input type="radio" value="ESTP" name="mbti">ESTP
						<input type="radio" value="ESFP" name="mbti">ESFP
						<input type="radio" value="ENFP" name="mbti">ENFP
						<input type="radio" value="ENTP" name="mbti">ENTP
						<input type="radio" value="ESTJ" name="mbti">ESTJ
						<input type="radio" value="ESFJ" name="mbti">ESFJ
						<input type="radio" value="ENFJ" name="mbti">ENFJ
						<input type="radio" value="ENTJ" name="mbti">ENTJ
			 	</tr>
			 	<tr><th>프로필 사진</th>
			 		<td><input type="file" name="filename" accept="image/*" placeholder="이미지 파일을 선택하세요."></td>
			 	</tr>
			 	<tr><th>자기소개</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
		 		<td><textarea  rows="10" cols="80" name="introduce" required="required">${bean.introduce}</textarea></td>
		 		</tr>	<!-- ${bean.introduce} 는 값이 있을 때 보여집니다!!!!! 전에 저장해뒀던 프로필 내용 가져오는 것! -->
			 	<tr><td colspan="2" align="center">
			 	<input type="submit" value="수정" class="btn">
			 	<input type="reset"  value="다시쓰기" class="btn">
			 	<input type="button" value="프로필" class="btn" onclick="location.href='profileMain.do?idx=${user.idx}'">
			 	</td></tr>
			 </table>
			</div>
		</div>	<!-- box end -->
		</form>
	</div>	<!-- pagebox end -->
</body>
</html>