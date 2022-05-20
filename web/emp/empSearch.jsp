<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/20
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>특정 직원을 조회</h1>
<form action="empDetail.do" method="post">
    직원번호 : <input type="number" name="empid" value="100">
    <input type="submit" value="직원조회">
</form>
</body>
</html>
