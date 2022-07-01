<%@page import="web.unstop.login.loginVO"%>
<%@page import="web.unstop.login.loginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="info" scope="page" class="web.unstop.login.loginVO">
	<jsp:setProperty name="info" property="*" />
</jsp:useBean>
       <%
    if(session.getAttribute("id")==null){%>
    <script type="text/javascript">
    alert("로그인 되어있지않습니다.");
    window.location="login.jsp"
    </script>
    <%	
    }else{ 

    String newpass=request.getParameter("newpass");
    loginDAO dao=loginDAO.getinstance();
    int che=dao.updateUser(info, newpass);
    if(che==1){
    session.invalidate();
    %>
<script type="text/javascript">
	alert("비밀번호 성공적으로 변경하였습니다.")
	window.location = "login.jsp";
</script>
<%}else if(che==2){ %>
<script type="text/javascript">
	alert("비밀번호 틀렸습니다.")
	history.go(-1);
</script>

<% }else{ %>
<script type="text/javascript">
	alert("시스템 오류입니다")
	history.go(-1);
</script>
<%}} %>
