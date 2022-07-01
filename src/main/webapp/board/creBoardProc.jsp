<%@page import="web.unstop.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="info" class="web.unstop.board.boardVO">
    <jsp:setProperty name="info" property ="*"/>
    </jsp:useBean>
    <%
    String id=session.getAttribute("id").toString();
    info.setId(id);
    BoardDAO dao=BoardDAO.getInstance();
    int re=dao.creBoard(info);
    if(re!=-1){
    %>
    <script type="text/javascript">
    alert("글 작성 완료");
    window.location='list.jsp';
    </script>
    <%}else{ %>
       <script type="text/javascript">
    alert("글 작성 실패");
    history.go(-1);
    </script>
    <%} %>
