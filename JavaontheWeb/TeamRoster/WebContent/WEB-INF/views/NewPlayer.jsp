<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><c:out value="${team.getTeam_name()}"/>: New Player</title>
	<style type="text/css"> <%@include file="../css/skeleton.css" %> </style>
</head>
<body>
    <h2>Add a player to team <c:out value="${team.getTeam_name()}"/></h2>
    <form action="/TeamRoster/Players" method="post">
        <label for="first_name">First Name:<input type="text" name="first_name" id="first_name"></label>
        <label for="last_name">Last Name:<input type="text" name="last_name" id="last_name"></label>
        <label for="age">Age:<input type="number" name="age" id="age" min="18" max="40"></label>
        <button type="submit">Add</button>
    </form>
</body>
</html>