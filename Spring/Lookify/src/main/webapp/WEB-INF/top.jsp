<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css"><%@include file="skeleton.css" %></style>
<title>Top 10</title>
</head>
<body>
    <p>Top Ten Songs:</p>
    <a href="/dashboard">Dashboard</a>
    <div id="top_ten">
        <c:forEach var="song" items= "${ songs }">
            <p>
                <c:out value="${song.rating}"/> -
                <a href='/songs/<c:out value="${song.id}"/>'><c:out value="${song.title}"/></a> - 
                <c:out value="${song.artist}"/>
            </p>
        </c:forEach>
    </div>
</body>
</html>