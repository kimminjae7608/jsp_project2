<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day 10 로그인</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Bangers&display=swap');
div { /* 로그인 창*/
	border: 2px dotted #f5b49c; 
	width: 200px;
	height: 325px;
	background-color: ivory;
	padding: 50px;  /*안쪽여백*/
	margin: 100px auto; /*바깥쪽여백*/
}
form{
	width: 200px;
	height: 320px;
}
input{ 	padding: 7px; /*입력창 전체*/
		margin: 15px auto; 
	}
input[type=text],input[type=password]{ /*아이디,비번 입력창*/
	border-radius: 4px; border: 2px solid #ccc;
}
input[type=submit], input[type=button] {/*아이디,비번 입력창*/
	padding: 7px 15px;
	margin: 7px 10px;
	background: #99CEB5; 
	color: white;
	border: none;
	cursor: pointer;
	width:35%;
}
input[type=submit]:hover{ /*로그인버튼*/
	background:#F59B7A;
}
input[type=button]:hover{/*홈버튼*/
	background:#F59B7A;
}

img{
	opacity: 65%; /*투명도*/
}
a{
	text-decoration: none; /*계정(아이디,비번)찾기 링크*/
	color: tomato;
}
hr{
	border: 1px dotted #f5b49c;
}
a{
  color:w#F59B7A;
}
a>mark{
	background-color: #fdbba3;
	opacity: 50%;

}

</style>
</head>
<body style="text-align:center;">
<div>
	
	<form action="loginAction.do" method="post">	   
		<img src="image/프젝로고.png" width=100%>
		<input type="text" name="email" placeholder="아이디(이메일) 입력하세요.">
		<input type="password" name="password" placeholder="비밀번호 입력하세요.">
		<input type="submit" value="Login">
		<input type="button" value="JOIN" onclick="location.href='member.do'">
		<hr>													
		<a href="lostPW.do">비번을 잊으셨나요?click!</a>
		<!--여기에 아이디/비번찾기 링크 삽입-->
	</form>

</div>
</body>
</html>






















