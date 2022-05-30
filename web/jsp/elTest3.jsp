<%@page import="dto.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
    BoardDTO board = new BoardDTO("월요일","EL연습....", 100);
application.setAttribute("BoardDTO", board);
session.setAttribute("BoardDTO", new BoardDTO("화요일","EL연습....", 100));
request.setAttribute("BoardDTO", new BoardDTO("수요일","EL연습....", 100));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL연습</title>
</head>
<body>
<h1>EL연습</h1>
<pre>
1.EL이용읽기 : ${BoardDTO}
1.EL이용읽기 : ${applicationScope.BoardDTO}
1.EL이용읽기 : ${sessionScope.BoardDTO}
1.EL이용읽기 : ${requestScope.BoardDTO}
1.EL이용읽기 : ${pageScope.BoardDTO}
<hr>
2.ScriptLet의 Expression : <%=board %>
2.ScriptLet의 Expression : <%=application.getAttribute("BoardDTO") %>
<hr>
3.List읽기 : ${boardList }
<ul>
  <c:forEach items="${boardList }" var="b">
      <li>${b.title}.......${b.content }</li>   <%--b.getTitle(), b.getContent() 호출된다. --%>
  </c:forEach>
</ul>
</pre>
</body>
</html>


