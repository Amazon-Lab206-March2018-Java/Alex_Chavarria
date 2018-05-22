<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ideas Login/Registration Page</title>
<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
</head>
<body>
	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <div id="register">
        <h1>Register!</h1>
        
        <form:form method="POST" action="/registration" modelAttribute="user">
            <p>
                <form:label path="email">Email:</form:label>
                <form:errors path="email"/>
                <form:input path="email"/>
            </p>
            <p>
                <form:label path="name">Name:</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="password">Password:</form:label>
                <form:errors path="password"/>
                <form:password path="password"/>
            </p>
            <p>
                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                <form:errors path="passwordConfirmation"/>
                <form:password path="passwordConfirmation"/>
            </p>
            <input type="submit" value="Register!"/>
        </form:form>
    </div>
    <div id="login">
        <h1>Login</h1>
        
        <c:if test="${errorMessage != null}">
            <c:out value="${errorMessage}"></c:out>
        </c:if>
        
        <form method="POST" action="/login">
            <p>
                <label for="username">Email</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Login!"/>
        </form>
    </div>
</body>
</html>