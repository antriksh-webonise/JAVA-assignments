<%@ page import="main.java.employeedao.EmployeeDao" %>
<%@ page import="main.java.model.EmployeeModel" %><%--
  Created by IntelliJ IDEA.
  User: webonise
  Date: 11/12/17
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employees</title>
</head>
<body>
<%
    EmployeeModel employee = new EmployeeModel();
%>
<%
    EmployeeDao dao = new EmployeeDao();
%>
<form method="POST" action='EmployeeController' name="frmEditUser"><input
        type="hidden" name="action" value="edit" /> <%
    String uid = request.getParameter("id");
    if (!((uid) == null)) {
        int id = Integer.parseInt(uid);
        employee = dao.getEmployeeById(id);
%>
    <table>
        <tr>
            <td>Employee ID</td>
            <td><input type="text" name="id" readonly="readonly" value="<%=employee.getId()%>"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<%=employee.getName()%>"></td>
        </tr>
        <tr>
            <td>Contact</td>
            <td><input type="tel" name="contact" value="<%=employee.getContact()%>"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email_address" value="<%=employee.getEmail()%>"></td>
        </tr>
        <tr>
            <td>Blood Group</td>
            <td><input type="text" name="blood_group" value="<%=employee.getBloodGroup()%>"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
    <%
        } else
            out.println("ID Not Found");
    %>
</form>


</body>
</html>
