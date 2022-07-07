<%@page import="web.unstop.board.BoardDAO"%>
<%@page import="web.unstop.board.boardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num=Integer.parseInt(request.getParameter("num"));
BoardDAO dao=BoardDAO.getInstance();
boardVO che=dao.selectBoard(num);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post"  action="update.jsp">
<input type="hidden" value="<%=che.getNum()%>" name="num">
<div>제목:<%=che.getTitle()%></div>
<div>내용: <%=che.getContent()%></div>
<input value="수정" type="submit">
<input value="삭제" onclick="javascript:window.location='delete.jsp?num=<%=che.getNum()%>'" type="button">
</form>
</body>
</html>