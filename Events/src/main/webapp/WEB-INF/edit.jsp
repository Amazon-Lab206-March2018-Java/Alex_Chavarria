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
	<h3>Edit Event</h3>
	<form:form action="/events/${event.id}/update" method="post" modelAttribute="event">
		<form:hidden path="host" value="${event.host.id}"/> 
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
        <input type="submit" value="Update Event">
	</form:form>
</body>
</html>