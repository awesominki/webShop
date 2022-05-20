<%--
  Created by IntelliJ IDEA.
  User: jeonmingi
  Date: 2022/05/20
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>직원의 상세내역</h1>
직원번호 : ${emp.employee_id} <br>
firstname : ${emp.first_name} <br>
lastname : ${emp.last_name} <br>
email : ${emp.email} <br>
phone : ${emp.phone_number} <br>
commission : ${emp.commission_pct} <br>
manager_id : ${emp.manager_id} <br>
department_id : ${emp.department_id} <br>
job_id : ${emp.job_id} <br>
hire_date : ${emp.hire_date} <br>
salary : ${emp.salary} <br>
</body>
</html>
