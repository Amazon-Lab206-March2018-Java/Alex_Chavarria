<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Profile</title>
<style type="text/css"><%@include file="skeleton.css" %></style>
</head>
<body>
    <h1>${ question.question }</h1>
    <h3>Tags: 
        <c:forEach items="${ question.tags }" var="tag">
            ${tag.subject}
        </c:forEach>
    </h3>
    <table>
        <thead>
            <th>Answers</th>
        </thead>
        <tbody>
            <c:forEach items="${ answers }" var="answer">
                ${answer.answer}
            </c:forEach>
        </tbody>
    </table>
    <div id="newQuestion">
        <h3>Add your answer:</h3>
        <form:form action="/questions/${ question.id }/answer" method="POST" modelAttribute="answer">

            <form:errors path="answer"/>
            <form:label path="answer">Answer:
            <form:textarea path="answer"/></form:label>
        
            <input type="submit" value="Answer it!">

        </form:form>
    </div>
</body>
</html>