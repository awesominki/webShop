<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/26
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //내장객체가 제공된다 : application, session, request
%>
<h1>scopeTest.jsp페이지.....Servlet Scope를 test한다.</h1>
<h2>ScriptLet문법</h2>
<p>application영역의 접근 : <%=application.getAttribute("appVar") %></p>
<p>session영역의 접근 : <%=session.getAttribute("sessionVar")%></p>
<p>request영역의 접근 : <%=request.getAttribute("requestVar")%></p>
<hr>
<h2>EL(Expression Language)문법</h2>
<p>application영역의 접근 : ${appVar}</p>
<p>session영역의 접근 : ${sessionVar}</p>
<p>request영역의 접근 : ${requestVar}</p>
</body>
</html>
