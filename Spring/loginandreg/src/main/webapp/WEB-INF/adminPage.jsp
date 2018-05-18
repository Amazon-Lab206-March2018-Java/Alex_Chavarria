<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	   
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out></h1>
    <table>
        <thead>
        	<tr>
	            <th>Name</th>
	            <th>Email</th>
	            <th>Action</th>
	        </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>
                    <c:choose>                    
	                    <c:when test="${user.roles[0].name == 'ROLE_ADMIN'}">
	                    	admin
	                    </c:when>
	                    <c:otherwise>
	                        <a href="/delete/${user.id}">Delete</a>
	                        <a href="/makeAdmin/${user.id}">make-admin</a>
	                    </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    <a href="/">Back to dashboard</a>
</body>
</html>