<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>

    <h1>Welcome Page <c:out value="${currentUser.firstName}"></c:out></h1>
    <c:if test="${ currentUser.roles[0].name == 'ROLE_ADMIN' }">
    	<a href="/admin">Admin Dashboard</a>
    </c:if>
    <table>
        <tbody>
            <tr>
                <td>First Name:</td>
                <td>${ currentUser.firstName }</td>
			</tr>
			<tr>
                <td>Last Name:</td>
                <td>${ currentUser.lastName }</td>
			</tr>
			<tr>
                <td>Email:</td>
                <td>${ currentUser.email }</td>
			</tr>
			<tr>
                <td>Sign up date:</td>
                <td>${ currentUser.createdAt }</td>
            </tr>
			<tr>
                <td>Last Sign in:</td>
                <td>${ currentUser.lastLoginDate }</td>
            </tr>
        </tbody>
    </table>
</body>
</html>