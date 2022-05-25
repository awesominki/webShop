<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/19
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인성공!</h1>
<h2>db접속 후 다시 수정하기</h2>
<h2><%=request.getParameter("userid")%></h2>
<h2>${param.userid}</h2>
<h2>이메일 : ${param.user_email}</h2>
<h2>주소 : ${param.user_address}</h2>
<a href="login2.do?a=${param.userid}&b=${param.userpass}&c=${param.user_email}&d=${param.user_address}">다른페이지에 정보넘기기</a>
</body>
</html>
