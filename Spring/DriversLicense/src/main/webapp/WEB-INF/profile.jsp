<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>${ person.firstName } ${person.lastName}</h1>
    <table>
        <tbody>
            <tr>
                <td>License Number:</td>
                <td>${ license.number }</td>
            </tr>
            <tr>
                <td>License State:</td>
                <td>${ license.state }</td>
            </tr>
            <tr>
                <td>Expiration Date:</td>
                <td>${ license.expiration_date }</td>
            </tr>
        </tbody>
    </table>
    <a href="/persons/new">Create new user</a>
</body>
</html>