<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/20
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>특정 게시글 조회</h1>
<form action="boardDetail.do" method="post">
    게시글번호 : <input type="number" name="boardid" value="100">
    <input type="submit" value="게시글조회">
</form>
</body>
</html>
