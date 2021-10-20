<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="guestbooksave.do" method="post">
	<input type ="hidden" name ="u_idx" value="${u_idx }">
	<input type ="hidden" name ="v_idx" value="${v_idx }">
	<input type ="hidden" name ="u_name" value="${u_name}">
	
		방명록남기기<textarea name="content"></textarea>
	<input type="submit" value="저장" class="btn" >
 	<input type="reset"  value="다시쓰기" class="btn">
	</form>


</body>
</html>