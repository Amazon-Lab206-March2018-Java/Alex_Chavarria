<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"><%@include file="style.css" %></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 id= "top">Your Gold:</h3>
    <div id="score">
        <p><c:out value="${ total }"/></p>
    </div>
    <form action="/reset" method="post">
        <input type="submit" value="Reset">
    </form>
    <div id="wrapper">
        <div class="option">
            <h3>Farm:</h3>
            <h5>(earns 10 - 20 gold)</h5>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="farm"/>
                <input type="submit" value="Find Gold!"/>   
            </form>
        </div>
        <div class="option">
            <h3>Cave:</h3>
            <h5>(earns 5 - 10 gold)</h5>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="cave"/>
                <input type="submit" value="Find Gold!"/>   
            </form>
        </div>
        <div class="option">
            <h3>House:</h3>
            <h5>(earns 2 - 5 gold)</h5>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="house"/>
                <input type="submit" value="Find Gold!"/>   
            </form>
        </div>
        <div class="option">
            <h3>Casino:</h3>
            <h5>(earns/takes 0 - 50 gold)</h5>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="casino"/>
                <input type="submit" value="Find Gold!"/>   
            </form>
        </div>
        <h4>Activities:</h4>
        <div id="footer">
	        <c:forEach var="activity" items="${ activities }">
	        	<p class="<c:out value="${ activity.color }"/>"> <c:out value="${ activity.message }"/> <p/>
	        </c:forEach>
        </div>
    </div>
</body>
</html>