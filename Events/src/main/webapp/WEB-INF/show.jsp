<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${event.name}</h1>
	<p>Host: ${event.host.firstName} ${event.host.lastName}</p>
	<p>Date: ${event.date}</p>
	<p>Location: ${event.location} ${event.state}</p>
	<p>People attending ${event.attendees.size()}</p>
	<table>
		<thead>
			<th>Name</th>
			<th>Location</th>
		</thead>
		<tbody>
			<c:forEach items="${event.attendees}" var="guest">
				<tr>
					<td>${guest.firstName } ${guest.lastName }</td>
					<td>${guest.location }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Message Wall</h3>
	<div style="border:2px solid black; margin:5px; padding:5px;">
		<c:forEach items="${event.messages}" var="message">
			<p>${message.user.firstName } ${message.user.lastName }: ${message.comment }</p>
		</c:forEach>
	</div>
	<form action="/events/${event.id}/messages/create" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<textarea name="comment"></textarea>
		<input type="submit" value="Submit">
	</form>
</body>
</html>