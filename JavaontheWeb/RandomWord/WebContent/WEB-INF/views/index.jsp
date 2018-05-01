<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h4>You have generated a word <c:out value="${ count }" /> times</h4>
    <div id="word">
        <c:out value="${ word }"/>
    </div>
    <form action="/RandomWord/Random" method="get">
        <button type="submit">Generate</button>
    </form>
    <h4>The last time you generated a word was:</h4>
    <div id="date">
        <c:out value="${ time }"/>
    </div>
</body>
</html>