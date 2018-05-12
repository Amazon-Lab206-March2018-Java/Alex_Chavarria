<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojo Page</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>${ninjas[0].dojo.name} Ninjas</h1>
    <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items= "${ ninjas }" var= "ninja">
                <tr>
                    <td>${ ninja.firstName }</td>
                    <td>${ ninja.lastName }</td>
                    <td>${ ninja.age }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/dojos/new">Create a new Dojo</a>
    <a href="/ninjas/new">Add a new Ninja</a>
</body>
</html>