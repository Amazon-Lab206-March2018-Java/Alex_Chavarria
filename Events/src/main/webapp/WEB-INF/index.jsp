<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events Login/Reg</title>
</head>
<body>
	<h1>Welcome</h1>
	<c:if test="${logout != null}">
		<c:out value="${logout}"/>
	</c:if>
	<h1>Login</h1>
	<c:if test="${error != null}">
		<c:out value="${error}"/>
	</c:if>
	<form action="/login" method="post">
		<p>Email:<input type="text" name="username"></p>
		<p>Password:<input type="password" name="password"></p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Login">
	</form>
	
	<h1>Register</h1>
	<form:form method="POST" action="/registration" modelAttribute="new_user">
        <p>
        	<form:errors path="email"/>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
        </p>
        <p>
        	<form:errors path="firstName"/>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
        </p>
        <p>
        	<form:errors path="lastName"/>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
        	<form:errors path="location"/>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
            <form:errors path="state"/>
            <form:select path="state">
            	<form:options items="${states}"/>
            </form:select>
        </p>
        <p>
        	<form:errors path="password"/>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
        	<form:errors path="passwordConfirmation"/>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
</body>
</html>