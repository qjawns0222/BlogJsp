<%@page import="java.util.List"%>
<%@page import="web.unstop.board.boardVO"%>
<%@page import="web.unstop.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("id") == null) {
%>
<script type="text/javascript">
	alert("로그인 되어있지 않습니다.");
	window.location = "login.jsp"
</script>
<%
}
BoardDAO dao=BoardDAO.getInstance();
List<boardVO> list=null;

	
list=dao.selectBoardAll();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<button onClick="window.location='creBoard.jsp'">글작성</button>
		<button onclick="window.location='../login/myPage.jsp'">마이페이지</button>
	</div>
	<div class="list" >
		<table border="1">
	<tr>
		<td>작성자</td>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>조회수</td>
	</tr>
	<%
	
	for(int i=0;i<list.size();i++){
		boardVO info=list.get(i);
	%>

	<tr>
		<td><%=info.getId()%></td>
		<td><%=info.getNum()%></td>
		<td><%=info.getTitle()%></td>
		<td><%=info.getContent()%></td>
		<td><%=info.getCount()%></td>
	</tr>
	<% 
	}
	
	%>
	</table>
	
	</div>
</body>
</html>