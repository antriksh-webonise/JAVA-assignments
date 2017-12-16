<%--
  Created by IntelliJ IDEA.
  User: webonise
  Date: 13/12/17
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employees List</title>
</head>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Contact</th><th>Email</th><th>Blood Group</th><th></tr>
    <c:forEach var="employee" items="${list}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.contact}</td>
            <td>${employee.email}</td>
            <td>${employee.bloodGroup}</td>
            <td><a href="edit/${employee.id}">Edit</a></td>
            <td><a href="delete/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="form">Add New Employee</a>

</body>
</html>
