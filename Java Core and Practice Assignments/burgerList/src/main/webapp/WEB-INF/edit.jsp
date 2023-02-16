<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger</title>
</head>
<body class="container-fluid d-flex flex-column align-items-center bg-dark text-white text-center">
	<h2>Edit Burger:</h2>
	<form:form class="card bg-light m-3 p-3 text-dark w-25" action="/edit/${burger.id}" method="post" modelAttribute="burger">
		<input type="hidden" name="_method" value="put">
		
		<form:label path="burgerName">Burger Name:</form:label>
		<form:errors path="burgerName" class="text-danger"/>
		<form:input type="text" path="burgerName" class="form-control"/>
		
		<form:label path="restaurantName" class="mt-3">Restaurant Name:</form:label>
		<form:errors path="restaurantName" class="text-danger"/>
		<form:input type="text" path="restaurantName" class="form-control"/>
		
		<form:label path="rating" class="mt-3">Rating(out of 5):</form:label>
		<form:errors path="rating" class="text-danger"/>
		<form:input type="number" path="rating" class="form-control"/>
		
		<form:label path="notes" class="mt-3">Notes:</form:label>
		<form:errors path="notes" class="text-danger"/>
		<form:textarea path="notes" class="form-control"/>
		
		<input type="submit" value="Submit Input" class="mt-3 btn btn-primary">
		
	</form:form>
</body>
</html>