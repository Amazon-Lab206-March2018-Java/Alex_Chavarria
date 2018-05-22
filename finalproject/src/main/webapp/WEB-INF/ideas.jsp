<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ideas</title>
<style type="text/css"><%@include file="/WEB-INF/css/skeleton.css" %></style>
<style type="text/css"><%@include file="/WEB-INF/css/style.css" %></style>
</head>
<body>
	<h1 id="welcome">Welcome, <c:out value="${currentUser.name}"/></h1>
	    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <h3>Ideas</h3>
    <table>
        <thead>
            <tr>
                <th>Idea</th>
                <th>Created By:</th>
                <th>Likes</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ ideas }" var="idea">
                <tr>
                    <td><a href="/ideas/${ idea.id }">${ idea.content }</a></td>
                    <td>${ idea.ideaCreator.name }</td>
                    <td>${ idea.liked.size() }</td>
                    <td>
	                    <c:choose>                    
		                    <c:when test="${idea.liked.contains(currentUser)}">
		                    	<a href="/ideas/${idea.id}/unlike">Unlike</a>
		                    </c:when>
		                    <c:otherwise>
		                        <a href="/ideas/${idea.id}/like">Like</a>
		                    </c:otherwise>
	                    </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/ideas/new">
    	<button>Create an idea</button>
    </a>
</body>
</html>