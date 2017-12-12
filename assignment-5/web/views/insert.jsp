<%--
  Created by IntelliJ IDEA.
  User: webonise
  Date: 11/12/17
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Employee</title>
</head>
<body>
<form method="POST" action='EmployeeController' name="frmAddUser"><input
        type="hidden" name="action" value="insert" />
    <p><b>Add New Record</b></p>
    <table>
        <tr>
            <td>Employee ID</td>
            <td><input type="text" name="id" required /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>Contact</td>
            <td><input type="tel" name="contact" required /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email_address" /></td>
        </tr>
        <tr>
            <td>Blood Group</td>
            <td><input type="text" name="blood_group" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>
<p><a href="EmployeeController?action=listUser">View-All-Records</a></p>
</body>
</html>

</body>
</html>
