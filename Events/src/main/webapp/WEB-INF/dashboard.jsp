<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events Dashboard</title>
</head>
<body>
	<form action="/logout" method="post" style="float:right;">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="Logout!">
	</form>
	<h1>Welcome, <c:out value="${currentUser.firstName}"/></h1>
	<h3>Events In Your State</h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action / Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${instate}" var="event">
			<tr>
				<td><a href="/events/${event.id}">${event.name}</a></td>
				<td>${event.date}</td>
				<td>${event.location}</td>
				<td>${event.host.firstName}</td>
				<td>
					<c:if test="${event.host == currentUser}">
					<a href="/events/${event.id}/edit">Edit</a> <a href="/events/${event.id}/delete">Delete</a>
					</c:if>
					<c:if test="${(event.host != currentUser) && !event.attendees.contains(currentUser)}">
					<a href="/events/${event.id}/join/${currentUser.id}">Join</a>
					</c:if>
					<c:if test="${event.attendees.contains(currentUser)}">
					Joining <a href="/events/${event.id}/cancel">Cancel</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Events In Other States</h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${outofstate}" var="event">
			<tr>
				<td><a href="/events/${event.id}">${event.name}</a></td>
				<td>${event.date}</td>
				<td>${event.location}</td>
				<td>${event.state}</td>
				<td>${event.host.firstName}</td>
				<td>
					<c:if test="${event.host == currentUser}">
					<a href="/events/${event.id}/edit">Edit</a> <a href="/events/${event.id}/delete">Delete</a>
					</c:if>
					<c:if test="${(event.host != currentUser) && !event.attendees.contains(currentUser)}">
					<a href="/events/${event.id}/join/${currentUser.id}">Join</a>
					</c:if>
					<c:if test="${event.attendees.contains(currentUser)}">
					Joining <a href="/events/${event.id}/cancel">Cancel</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Create an Event</h3>
	<form:form action="/events/create" method="post" modelAttribute="new_event">
		<p>
			<form:errors path="name"/>
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
		</p>
		<p>
			<form:errors path="date"/>
			<form:label path="date">Date:</form:label>
			<form:input path="date" type="date"/>
		</p>
		<p>
        	<form:errors path="location"/>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
            <form:errors path="state"/>
            <form:select path="state">
            	<form:options items="${states}"/>
            </form:select>
        </p>
        <input type="submit" value="Create Event">
	</form:form>
</body>
</html>