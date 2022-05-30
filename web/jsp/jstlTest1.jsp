<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습</h1>
<pre>
1. set (setAttribute) :
    <c:set var="myName"  value="jin" scope="page" />
    <c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

    <%-- pageCotext.setAttrubute("myName", "jin") --%>
2.get (getAttrubute) : ${myName}
   컨텍스트패스 : ${path }
</pre>
</body>
</html>