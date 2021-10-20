<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진 올리기</title>
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
		<form action="galleryInsert.do" method="post" enctype="multipart/form-data">	<!-- 액션부분은 비워뒀어요.. 액션은 백앤드! -->
		<div class="box">	<!-- 페이지마다 달라지는 내용 -->
			<div class="registbox">
				<input type ="hidden" name="idx" value= ${user.idx }>
				<table>
			 	<tr><th width="25%">제목</th>
			 		<td><input type="text" name="title" size="70"></td>
			 	</tr>
			 	<tr><th>사진</th>
			 		<td><input type="file" name="filename" accept="image/*" placeholder="이미지 파일을 선택하세요."></td>
			 	</tr>
			 	<tr><th>내용</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
		 		<td><textarea  rows="20" cols="80" name="gcontent" required="required">${bean.content}</textarea></td>
		 		</tr>	<!-- ${bean.content} 는 값이 있을 때 보여집니다!!!!! 전에 저장해뒀던 프로필 내용 가져오는 것! -->
			 	<tr><td colspan="2" align="center">
			 	<input type="submit" value="저장" class="btn">
			 	<input type="reset"  value="다시쓰기" class="btn">
			 	<input type="button" value="갤러리" class="btn" onclick="location.href='gallery.do?idx=${user.idx}'">
			 	</td></tr>							
			</table>
			</div>
		</div>
		</form>
	</div>
</body>
</html>