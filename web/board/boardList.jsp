<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/20
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
<h1>게시판 목록</h1>
<table>
    <tr>
        <td>번호</td>
        <td>제목</td>
        <td>내용</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>수정일</td>
    </tr>
    <c:forEach items="${boardDatas}" var="board">
        <tr>
            <td><a href="boardDetail.do?boardid=${board.bno}">${board.bno}</td>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>${board.writer}</td>
            <td>${board.regdate}</td>
            <td>${board.updatedate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
