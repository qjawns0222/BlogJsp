<%@page import="web.unstop.board.boardVO"%>
<%@page import="web.unstop.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="info" class="web.unstop.board.boardVO">
    	<jsp:setProperty name="info" property="*"/>
    </jsp:useBean>

<%
request.setCharacterEncoding("utf-8");
BoardDAO dao=BoardDAO.getInstance();
int che=dao.updateBoard(info);
if(che==0){
%>
<script type="text/javascript">
    alert("글 수정 실패");
    window.location='detail.jsp?num=<%=info.getNum()%>';
    </script>
<%}else{%>
<script type="text/javascript">
    alert("글 수정 완료");
    window.location='list.jsp';
    </script>
<%}%>
