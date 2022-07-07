<%@page import="web.unstop.board.boardVO"%>
<%@page import="web.unstop.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:useBean id="info" class="web.unstop.board.boardVO">
    	<jsp:setProperty name="info" property="*"/>
    </jsp:useBean>
    <%
    int num=Integer.parseInt(request.getParameter("num"));
    BoardDAO dao=BoardDAO.getInstance();
    int che=dao.deleteBoard(info);
    if(che==0){
    	%>
    	<script type="text/javascript">
    	    alert("글 삭제 실패");
    	    window.location='delete.jsp?num=<%=info.getNum()%>';
    	    </script>
    	<%}else{%>
    	<script type="text/javascript">
    	    alert("글 삭제 완료");
    	    window.location='list.jsp';
    	    </script>
    	<%}%>
