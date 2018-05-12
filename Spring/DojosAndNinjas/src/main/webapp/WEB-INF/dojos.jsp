<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Dojo</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>New Dojo</h1>
    <form:form action="/dojos/new" method="POST" modelAttribute="dojo">
        
        <form:errors path="name"/>
        <form:label path="name">Name:
        <form:input path="name"/></form:label>

        <input type="submit" value="Create">

    </form:form>

    <h5>Already have a dojo?</h5>
    <a href="/ninjas/new">Add a Ninja to an existing Dojo instead!</a>
</body>
</html>