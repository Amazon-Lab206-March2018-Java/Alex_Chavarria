<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Team</title>
	<style type="text/css"> <%@include file="../css/skeleton.css" %> </style>
</head>
<body>
    <h3>Create a new Team</h3>
    <form action="/TeamRoster/Teams" method="post">
        Team Name:<input type="text" name="team_name" id="team_name">
        <input type="submit" value="Create">
    </form>
</body>
</html>