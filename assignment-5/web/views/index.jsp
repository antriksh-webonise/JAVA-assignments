<%--
  Created by IntelliJ IDEA.
  User: webonise
  Date: 7/12/17
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>EMPLOYEE MANAGEMENT PORTAL LOGIN PAGE</title>
</head>
<body>
<h1>EMPLOYEE MANAGEMENT PORTAL</h1>
<form action="LoginController" method="post">
  <strong>USERNAME:</strong><br>
  <input type="text" placeholder="username" name="username">
  <br><br>
  <strong>PASSWORD:</strong><br>
  <input type="password" placeholder="password" name="password">
  <br><br>
  <input type="submit" value="Login">
</form>
</body>
</html>
