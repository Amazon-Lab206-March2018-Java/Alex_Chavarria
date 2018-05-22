<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ideas</title>
<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
</head>
<body>
    <h1>Edit ${ idea.content }</h1>
    <form:form method="post" action="/ideas/${ idea.id }/edit" modelAttribute="idea">
    <p>
        <form:label path="content">Content:</form:label>
        <form:errors path="content"/>
        <form:input type="text" path="content"/>
    </p>
    <input type="submit" value="Update">
    </form:form>
    <a href="/ideas/${ idea.id }/delete"><button>Delete</button></a>
</body>
</html>