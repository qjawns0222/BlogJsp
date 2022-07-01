<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    if(session.getAttribute("id")==null){%>
    <script type="text/javascript">
    alert("로그인 되어있지않습니다.");
    window.location="login.jsp"
    </script>
    <%	
    }
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
<input type="button" onclick="window.location='update.jsp'"  value="수정"/>
<input type="button" onclick="window.location='delete.jsp'"  value="삭제"/>
<input type="button"  onclick="window.location='logout.jsp'" value="로그아웃"/>
<input type="button"  onclick="window.location='../board/list.jsp'" value="글목록"/>
</div>
</body>
</html>