<%@page import="web.unstop.login.loginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:useBean id="info" scope="page" class="web.unstop.login.loginVO">
    <jsp:setProperty name="info" property="*"/>
    </jsp:useBean>
    <% 
    loginDAO dao=loginDAO.getinstance();
    int check=dao.login(info);
    
   if(check==1){
    %>
    <script type="text/javascript">
    alert("비밀번호를 확인해주세요");
    history.go(-1);
    </script>
    <%}else if(check==0){ %>
   <script type="text/javascript">
    alert("아이디와 비밀번호를 확인해주세요");
    history.go(-1);
    </script>
     <%}else{ 
     session.setAttribute("id", info.getId());
     %>
    <meta http-equiv="Refresh" content="0;url=list.jsp"/>
     <%} %>