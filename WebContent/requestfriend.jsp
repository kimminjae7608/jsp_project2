<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${user.name }님 ${v_name }에게 친구신청하시겠습니까?
	별칭을 입력해주세요.
	신청하기		취소
	<form action="requestmateaction.do" method="post">
	<input type="text" name="nickname" placeholder="별칭을 입력해주세요.">
	<input type="hidden" name ="u_idx" value ="${u_idx }"> 
	<input type="hidden" name ="v_idx" value ="${v_idx }"> 
	<input type ="submit" value="신청하기">
	<input type ="button" value="취소" onclick="location.href='mateAction.do'">
	</form>
	

</body>
</html>