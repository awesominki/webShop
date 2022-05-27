<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("myName", "C");
session.setAttribute("myName", "B");
application.setAttribute("myName", "A");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 문법 익히기</h1>
<pre>
1. 저장역역에 읽기(page>request>session>applicaton) : ${myName}
1. 저장역역에 읽기 : ${applicationScope.myName}
1. 저장역역에 읽기 : ${sessionScope.myName}
1. 저장역역에 읽기 : ${requestScope.myName}
1. 저장역역에 읽기 : ${pageScope.myName}
<%--
http://localhost:9090/webShop/jsp/elTest2.jsp?myName=jin&subject=aa&subject=bb
 --%>
2.param : ${param.myName}
2.param : ${paramValues.subject[0]}
2.param : ${paramValues.subject[1]}

3.pageContext : 내장객체이용시 이용 : ${pageContext.request.contextPath }
       







</pre>
</body>
</html>