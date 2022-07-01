<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%
    if(session.getAttribute("id")==null){%>
    <script type="text/javascript">
    alert("로그인 되어있지않습니다.");
    window.location="login.jsp"
    </script>
    <%	
    }else{ 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteProc.jsp" method="post">
<div>비밀번호:<input name="pass" type="password"/></div>
<div><input type="submit" value="삭제"></div>
</form>
<%} %>
</body>
</html>