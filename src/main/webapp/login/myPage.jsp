<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String id=session.getAttribute("id").toString(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>마이페이지</div>
<div><%=id %>님 로그인 하셨습니다.</div>
<div>
<input type="button"  value="수정"/>
<input type="button"  value="삭제"/>
<input type="button"  value="로그아웃"/>

</div>
</body>
</html>