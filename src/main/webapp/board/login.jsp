<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if(session.getAttribute("id")!=null){%>
    <script type="text/javascript">
    alert("로그인 되어있습니다.");
    window.location="list.jsp"
    </script>
    <%	
    }
    %>
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
<input type="button" value="회원가입" onclick="window.location='../login/creUser.jsp'"/>
<input type="button"  onclick="window.location='../login/login.jsp'" value="마이페이지"/>
</form>
</body>
</html>