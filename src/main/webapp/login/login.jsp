<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="loginProc.jsp">
<div>
아이디:<input name="id" type="text" >
</div>
<div>
비밀번호:<input name="pass" type="password" >
</div>
<input value="로그인" type="submit"/>
<input value="초기화" type="reset"/>
<input type="button" value="회원가입" onclick="window.location='creUser.jsp'"/>
</form>
</body>
</html>