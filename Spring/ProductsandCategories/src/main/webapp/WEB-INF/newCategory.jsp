<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Category</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>New Category</h1>
    <form:form action="/categories/new" method="POST" modelAttribute="category">

        <form:errors path="name"/>
        <form:label path="name">Name:
        <form:input path="name"/></form:label>

        <input type="submit" value="Create"/>

    </form:form>
    <a href="/products/new">Create a new product instead</a>
</body>
</html>