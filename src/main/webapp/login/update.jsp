<%@page import="web.unstop.login.loginVO"%>
<%@page import="web.unstop.login.loginDAO"%>
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
    
    String id=session.getAttribute("id").toString();
    loginDAO dao=loginDAO.getinstance();
    loginVO info=dao.selectpass(id);
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateProc.jsp" method="post">
<div>이름:<input type="text" name="id" value="<%=id%>"></div>
<div>비밀번호:<input type="password" name="pass" value="<%=info.getPass()%>"></div>
<div>새비밀번호:<input type="password" name="newpass" ></div>
<div><input type="submit" value="수정"></div>
</form>
</body>
<%} %>
</html>