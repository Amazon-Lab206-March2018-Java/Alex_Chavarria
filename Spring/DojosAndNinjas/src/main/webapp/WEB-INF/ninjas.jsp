<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Ninja</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninjas/new" method="POST" modelAttribute="ninja">

        <form:label path="dojo">Dojo
        <form:select path="dojo">
            <c:forEach var = "dojo" items = "${dojos}">
                <form:option value="${ dojo.id }">${ dojo.name }</form:option>
            </c:forEach>
        </form:select></form:label>

        <form:errors path="firstName"/>
        <form:label path="firstName">First Name:
        <form:input path="firstName"/></form:label>
        
        <form:errors path="lastName"/>
        <form:label path="lastName">Last Name:
        <form:input path="lastName"/></form:label>

        <form:errors path="age"/>
        <form:label path="age">Age
        <form:input path="age" type="number" min="1" max="100"/></form:label>

        <input type="submit" value="Create"/>

    </form:form>
    <a href="/dojos/new">Back to Dojo creation</a>
</body>
</html>