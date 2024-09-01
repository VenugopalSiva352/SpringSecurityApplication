<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<h2 align="center">Admin Registration Form</h2>
<hr>
<form:form action="processAdminRegistration" modelAttribute="user" method="POST">
            <table align="center">
                <tr>
                    <td><form:label path="username">UserName</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:password path="password"/></td>
                </tr>
                <tr>
                	<td><form:label path="email">Email ID</form:label></td>
                    <td><form:input path="email"/></td>  
                <tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
</form:form>
</body>
</html>