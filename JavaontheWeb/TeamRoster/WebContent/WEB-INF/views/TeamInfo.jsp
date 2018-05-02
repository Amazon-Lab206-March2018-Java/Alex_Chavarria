<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Team</title>
	<style type="text/css"> <%@include file="../css/skeleton.css" %> </style>
</head>
<body>
    <h3><c:out value="${ currentTeam.team_name }"/></h3> 
    <a href="/TeamRoster/Players?id=<c:out value="${ teams.indexOf(currentTeam) }"/>">New <c:out value="${ currentTeam.team_name }"/></a>
    <table>
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <c:forEach var="player" items="${players}">
                <tr>
                    <td><c:out value="${player.getFirst_name()}"/></td>
                    <td><c:out value="${player.getLast_name()}"/></td>
                    <td><c:out value="${player.getAge()}"/></td>
                    <td><a href="/TeamRoster/DeletePlayer?id=<c:out value="${ players.indexOf(player) }"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>