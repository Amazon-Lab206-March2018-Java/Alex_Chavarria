<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"><%@include file="skeleton.css" %></style>
<title>Add Song</title>
</head>
<body>
    <a href="/dashboard">Dashboard</a>
    <form:form action="/songs/create" method="POST" modelAttribute="song">

    <form:errors path="title"/>
    <form:label path="title">Title
    <form:input path="title"/></form:label>

    <form:errors path="artist"/>
    <form:label path="artist">Artist
    <form:input path="artist"/></form:label>

    <form:errors path="rating"/>
    <form:label path="rating">Rating(1-10)
    <form:input type="number" min="1" max="10" path="rating"/>
    </form:label>

    <input type="submit" value="Add Song"/>

</form:form>
</body>
</html>