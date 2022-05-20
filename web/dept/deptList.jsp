<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/20
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, td{
            border:1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>부서목록</h1>
<table>
    <tr>
        <td>부서번호</td>
        <td>부서이름</td>
        <td>매니저</td>
        <td>지역번호</td>
    </tr>
    <c:forEach items="${deptlist}" var="dept">
        <tr>
            <td><a href="../html/dept.do?dept_id=${dept.department_id}">${dept.department_id}</td>
            <td>${dept.department_name}</td>
            <td>${dept.manager_id}</td>
            <td>${dept.location_id}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
