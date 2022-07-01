<%@page import="web.unstop.login.loginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("id") == null) {
%>
<script type="text/javascript">
	alert("로그인 되어있지않습니다.");
	window.location = "login.jsp"
</script>
<%
}else{
String id = session.getAttribute("id").toString();
String pass = request.getParameter("pass");
loginDAO dao = loginDAO.getinstance();
int che = dao.deleteUser(id, pass);
if (che == 1) {
session.invalidate();
%>
<script type="text/javascript">
	alert("삭제성공");
	window.location = "login.jsp"
</script>
<%
} else if (che == 0) {
%>
<script type="text/javascript">
	alert("비밀번호 틀림");
	history.go(-1);
</script>
<%
} else {
%>
<script type="text/javascript">
	alert("시스템 오류");
	history.go(-1);
</script>
<%
}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>