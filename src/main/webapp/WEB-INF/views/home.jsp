<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<form action="custom-logout" method="get" style="float: right;">
    <input type="submit" style="color: Red" value="Logout">
</form>

<h2 align="center">Welcome <span style="color: blue;">${username}</span>, to our Security Application</h2>
<h4 align="center">Authorities you have : ${authorities}</h4>
<hr>
<c:url var="viewurl" value="/view" />
<a href="${viewurl}" style="text-decoration: none;">view courses</a>
<br>
<c:url var="createurl" value="/create" />
<a href="${createurl}"style="text-decoration: none;">create courses</a>
<br>
<c:url var="updateurl" value="/update" />
<a href="${updateurl}"style="text-decoration: none;">update courses</a>
<br>
<c:url var="deleteurl" value="/delete" />
<a href="${deleteurl}"style="text-decoration: none;">delete courses</a>

</body>
</html>