<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>New License</h1>
    <form:form action="/licenses/new" method="POST" modelAttribute="license">

    <form:hidden path="number" value="${licenseNumber}"/>

    <form:label path="person">Person
    <form:select path="person">
        <c:forEach var = "person" items = "${persons}">
            <c:if test="${person.getLicense() == null}">
                <form:option value="${ person.id }">${ person.firstName } ${ person.lastName }</form:option>
			</c:if>
        </c:forEach>
    </form:select></form:label>

    <form:errors path="state"/>
    <form:label path="state">State
    <form:input path="state"/></form:label>

    <form:errors path="expiration_date"/>
    <form:label path="expiration_date">Expiration Date
    <form:input path="expiration_date" type="date"/></form:label>

    <input type="submit" value="Create"/>

    </form:form>

    <a href="/persons/new">Back to create a new usuer</a>
</body>
</html>