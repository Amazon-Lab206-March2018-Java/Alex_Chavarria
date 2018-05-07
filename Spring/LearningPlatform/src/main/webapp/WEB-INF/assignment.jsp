<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"><%@include file="style.css" %></style>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1 id="title">Fortran!</h1>
    <div id="links">
        <a href="/m/38/0553/0733">Set Up</a>
        <a href="/m/38/0483/0345">Forms</a>
        <a href="/m/38/0553/0342">Cards</a>
        <a href="/m/26/0553/0348">Advanced</a>
        <a href="/m/26/0483/2342">Binary</a>
    </div>
    <div id="checkbox">
	    <label><input type="checkbox" name="completed" id="completed">Assignment Completed</label>
    </div>
    <div id="comments">
        <p><c:out value="${ message }"/></p>
    </div>
</body>
</html>