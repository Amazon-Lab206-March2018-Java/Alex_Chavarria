<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
<style type="text/css"><%@include file="style.css" %></style>
</head>
<body>
	<table>
        <thead>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach items ="${ languages }" var="language">
            	<tr>
                    <td><a href='/languages/<c:out value="${languages.indexOf(language)}"/>'><c:out value="${language.name}"/></td></a>
                    <td><c:out value="${language.creator}"/></td>
                    <td><c:out value="${language.version}"/></td>
                    <td><a href='/languages/delete/<c:out value="${languages.indexOf(language)}"/>'>Delete</a> | <a href='/languages/edit/<c:out value="${languages.indexOf(language)}"/>'>Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form:form action="/languages/new" method="POST" modelAttribute="language">

        <form:errors path="name"/>
        <form:label path="name">Name
        <form:input path="name"/></form:label>

        <form:errors path="creator"/>
        <form:label path="creator">Creator
        <form:input path="creator"/></form:label>

        <form:errors path="version"/>
        <form:label path="version">Version
        <form:input path="version"/>
        </form:label>

        <input type="submit" value="Submit"/>

    </form:form>
</body>
</html>