<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2 align="center">Login</h2>
<hr>
<c:choose>
    <c:when test="${param.error != null}">
        <p align="center" style="color: red"> <i>Username or Password is wrong</i></p>
        <p align="center" style="color: red"> <i>Please enter the correct details</i></p>
    </c:when>
    <c:when test="${param.logout != null}">
       <p align="center" style="color: green;"> <i>You are successfully logged out</i></p>
       <p align="center" style="color: green;"> <i>Please login again</i></p>
    </c:when>
</c:choose>


    <div align="center">
	<form  action="processLogin" method="post">
	User Name: <input type="text" name="username">
	<br>
	<br>
	Password : <input type="password" name="password">
	<br>
	<br>
	<input type="submit" value="Submit">
	</form>
	</div> 
</body>
</html>