<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>${ product.name }</h1>
    <div id="cat">
        <h3>Categories:</h3>
        <ul>
            <c:forEach var = "category" items= "${ product.categories }">
                <li>${ category.name }</li>
            </c:forEach>
        </ul>
    </div>
    <div id="choice">
        <form action="/products/add/${ product.id }" method="post">
            <select name="category" id="category">
                <c:forEach var = "category" items= "${ categories }">
                    <c:if test="${!product.getCategories().contains(category)}">
                        <option value="${category.id}">${ category.name }</option>        
                    </c:if>
                </c:forEach>
            </select>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>