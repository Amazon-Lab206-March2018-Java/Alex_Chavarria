<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Pet</title>
</head>
<body>
	 <h1>Create a dog</h1>
    <form action="/Pets/ShowAnimal" method="get">
        <input type="hidden" value="dog" name="animal">
        <label> Name <input type="text" name="name"> </label>
        <label> Breed <input type="text" name="breed"> </label>
        <label> Weight <input type="text" name="weight"> </label>
        <input type="submit">
    </form>

    <h1>Create a cat</h1>
    <form action="/Pets/ShowAnimal" method="get">
        <input type="hidden" value="cat" name="animal">
        <label> Name <input type="text" name="name"> </label>
        <label> Breed <input type="text" name="breed"> </label>
        <label> Weight <input type="text" name="weight"> </label>
        <input type="submit">
    </form>
</body>
</html>