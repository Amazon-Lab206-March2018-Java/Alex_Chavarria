<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>New Person</h1>
    <form:form action="/persons/new" method="POST" modelAttribute="person">

    <form:errors path="firstName"/>
    <form:label path="firstName">First Name
    <form:input path="firstName"/></form:label>

    <form:errors path="lastName"/>
    <form:label path="lastName">Last Name
    <form:input path="lastName"/></form:label>

    <input type="submit" value="Create"/>

    </form:form>
    <a href="/licenses/new">Create a new license</a>
</body>
</html>