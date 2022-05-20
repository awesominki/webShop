<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>

<body>
<h1>jsp, servlet 학습하기</h1>
<h2>get요청 1</h2>
<a href="FirstServlet">FirsetServlet 요청</a>
<h2>get요청 2</h2>
<form action="FirstServlet" method="get">
  <input type="submit" value="firstservlet 요청(get)">
</form>
<h2>get요청 3</h2>
<button id="btn1">get요청</button>
<h2>post요청 1</h2>
<form action="FirstServlet" method="post">
  <input type="submit" value="firstservlet post">
</form>

<hr>
<ul>
  <li><a href="emp/emplist.do">모든 직원조회</a></li>
  <li><a href="dept/deptlist.do">모든 부서조회</a></li>
  <li><a href="board/boardlist.do">모든 게시판조회</a></li>
</ul>

<script>
  btn1.onclick = function () {
    location.href = "FirstServlet";
  }
</script>
</body>

</html>