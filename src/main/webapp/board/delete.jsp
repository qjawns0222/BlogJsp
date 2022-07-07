<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String num=request.getParameter("num");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteProc.jsp">
<div>삭제</div>

<div>NUM:<input type="password" name="num"/><input type="submit" value="삭제"/></div>

</form>
</body>
</html>