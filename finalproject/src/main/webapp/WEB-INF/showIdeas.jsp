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
    <h1>${ idea.content }</h1>
    <table>
        <tbody>
            <tr>
                <td><h4>Created By:</h4></td>
                <td><h4>${ idea.ideaCreator.name }</h4></td>
            </tr>
        </tbody>
    </table>
    <h2>Users who liked the idea:</h2>
    <table>
        <thead>
            <tr>
                <th><h3>Name</h3></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ idea.liked }" var="user">
                <tr>
                    <td><h4>${ user.name }</h4></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${ currentUser == idea.ideaCreator }">
        <a href="/ideas/${idea.id}/edit"> <button>Edit</button> </a>
    </c:if>
    <a href="/ideas"><button>Back</button></a>
</body>
</html>