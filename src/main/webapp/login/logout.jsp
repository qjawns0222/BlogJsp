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
session.invalidate();
%>
<script type="text/javascript">
    alert("로그아웃 성공하였습니다.");
    window.location="login.jsp"
 </script>
 <%}%>