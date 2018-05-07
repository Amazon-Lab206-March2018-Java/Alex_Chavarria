<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secret Code</title>
<style type="text/css"><%@include file="style.css" %></style>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <p id="error"><c:out value="${ error }"/></p>
    <p>What is the code?</p>
    <form action="/code" method="post">
        <input type="text" name="code" id="code">
        <input type="submit" value="Try Code">
    </form>
</body>
</html>