<%@page import="web.unstop.login.loginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:useBean id="info" scope="page" class="web.unstop.login.loginVO">
    <jsp:setProperty name="info" property="*"/>
    </jsp:useBean>
    <% 
    loginDAO dao=loginDAO.getinstance();
    int check=dao.creuser(info);
    
   if(check==2){
    %>
    <script type="text/javascript">
    alert("아이디 중복 실패");
    history.go(-1);
    </script>
    <%}else if(check==0){ %>
     <script type="text/javascript">
    alert("회원가입 오류");
    history.go(-1);
    </script>
      <%}else{ %>
    <meta http-equiv="Refresh" content="0;url=login.jsp"/>
     <%} %>
