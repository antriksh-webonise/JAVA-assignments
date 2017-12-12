<%@ page import="main.java.employeedao.EmployeeDao" %>
<%@ page import="main.java.model.EmployeeModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: webonise
  Date: 11/12/17
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<%
    EmployeeDao dao = new EmployeeDao();
    List<EmployeeModel> employeeList = dao.getAllEmployees();
%>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact</th>
        <th>Email</th>
        <th>Blood Group</th>
    </tr>
    <tr>
        <%
            for (EmployeeModel employee : employeeList) {
        %>
        <td><%=employee.getId()%></td>
        <td><%=employee.getName()%></td>
        <td><%=employee.getContact()%></td>
        <td><%=employee.getEmail()%></td>
        <td><%=employee.getBloodGroup()%></td>
        <td><a href="EmployeeController?action=editform&id=<%=employee.getId()%>">Update</a></td>
        <td><a href="EmployeeController?action=delete&id=<%=employee.getId()%>">Delete</a></td>
    </tr>
    <%
        }
    %>
</table>
<p><a href="EmployeeController?action=insert">Add Employee</a></p>
</body>
</html>
