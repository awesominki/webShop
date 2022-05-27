<%@ page import="dto.BoardVO" %><%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/27
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JavaBeans Test</h1>
<%
    //1. 자바 코드로 파라미터 받아서 객체생성
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    String writer = request.getParameter("writer");
    int i_writer = Integer.parseInt("writer");
    BoardVO board = new BoardVO();
    board.setTitle(title);
    board.setContent(content);
    board.setWriter(i_writer);
%>
<%=board.getTitle()%> <br>
<%=board.getContent()%> <br>
<%=board.getWriter()%> <br>
<hr>
<h2>2.Action Tag 사용하기 jsp:useBean 이용</h2>
<jsp:useBean id="board2" class="dto.BoardVO"></jsp:useBean>
<jsp:setProperty name="board2" property="title" value="${param.title}"/>
<jsp:setProperty name="board2" property="content" value="${param.content}"/>
<jsp:setProperty name="board2" property="writer" value="${param.writer}"/>
<hr>
<h2>Action Tag사용해서 읽기</h2>
<jsp:getProperty name="board2" property="title"/> <br>
<jsp:getProperty name="board2" property="content"/> <br>
<jsp:getProperty name="board2" property="writer"/> <br>
</body>
</html>
