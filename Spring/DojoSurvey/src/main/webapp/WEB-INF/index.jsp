<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
   <form action="login" method="post">
       Your Name: <input type="text" name="name" class="info">
       <p>Dojo Location:</p>  
       <select name="location" id="location">
           <option value="San Jose">San Jose</option>     
           <option value="Arizona">Arizona</option>
           <option value="Seattle">Seattle</option>
       </select>
       Favorite Language:
       <select name="language" id="language">
           <option value="Java">Java</option>
           <option value="Python">Python</option>
           <option value="C++">C++</option>
       </select>
       Comments (Optional):
       <textarea name="comment" id="comment" cols="30" rows="10"></textarea>
       <input type="submit" value="submit">
   </form>
</div>
</body>
</html>