<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions Dashboard</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>Questions Dashboard</h1>
    <table>
        <thead>
            <th>Question</th>
            <th>Tags</th>
        </thead>
        <tbody>
            <c:forEach items="${ questions }" var="question">
                <tr>
                    <td>${question.question}</td>
                    <td>
                        <c:forEach items="${ tags }" var="tag">
                            ${tag.subject}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/questions/new">New Question</a>
</body>
</html>