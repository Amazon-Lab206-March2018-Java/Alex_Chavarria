<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Great Number Game</title>
	<style>
		*{
			text-align: center;
		}
		div{
			display: inline-block;
			background-color: red;
			max-width: 120px;
			margin-bottom: 10px;
		}
		.won{
			background-color: green;
		}
	</style>
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
	<h3>I am thinking of a number between 1 and 100</h3>
	<h3>Take a guess!</h3>
	<div class=" <c:out value="${won}"/> ">
		<p><c:out value="${result}"/></p>
		<form action="/GreatNumberGame/PlayAgain" method="post" style=" display:<c:out value="${show}"/> ">
			<button type="submit">Play Again?</button>
		</form>
	</div>
	<form action="/GreatNumberGame/NumberController" method="post">
		<label for="guess"><input type="text" name="guess" id="guess" required></label>
		<button type="submit">Submit</button>
	</form>
</body>
</html>