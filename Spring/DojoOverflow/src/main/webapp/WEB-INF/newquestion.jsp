<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>What is your question?</h1>
    <form:form action="/questions/new" method="POST" modelAttribute="q">

    <form:errors path="question"/>
    <form:label path="question">Question:
    <form:textarea path="question"/></form:label>

    <form:errors path="tags"/>
    <form:label path="tags">Tags:
    <form:input path="tags"/></form:label>

    <input type="submit" value="Submit">

    </form:form>
</body>
</html>