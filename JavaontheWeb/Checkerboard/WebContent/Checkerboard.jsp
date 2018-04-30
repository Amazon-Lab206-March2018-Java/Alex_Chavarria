<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkerboard</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<% int height = 2;
	   int width = 2;
   	%>
   	<% if (request.getParameter("height") != null && request.getParameter("width") != null) { %>
	   	<%
	   		height = Integer.parseInt(request.getParameter("height"));
	   		width = Integer.parseInt(request.getParameter("width"));  	
	   	%>
		<% for(int i = 0; i < height; i++) { %>
			<div class="line">
	  		<% for(int j = 0; j < width; j++) { %>
			  			<% if (i%2 == 0) { %>
					  			<% if (j%2 == 0) { %>
					        		<div class="pink"></div>
					        	<% } else { %>
					        		<div class="purple"></div>
				        		<% } %>
			        	<% } else { %>
			        		<% if (j%2 == 0) { %>
			        			<div class="purple"></div>
			        		<% } else { %>
			        			<div class="pink"></div>
			        		<% } %>
			        	<% } %>
	    	<% } %>
	    	</div>
	    <% } %>
	<% } else { %>
	<h1>Please enter a height and width in the address bar!</h1>
	<% } %>
</body>
</html>