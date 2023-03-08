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
<title>Burger List</title>
</head>
<body class="container-fluid d-flex flex-column align-items-center bg-dark text-white text-center">
	<h1 class="p-3">Burger Tracker</h1>
	<table class="table table-bordered w-75 text-white">
		<thead>
			<tr>
				<th>Burger</th>
				<th>Restaurant</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td><c:out value="${burger.burgerName}"/></td>
					<td><c:out value="${burger.restaurantName}"/></td>
					<td><c:out value="${burger.rating}"/></td>
					<td><a href="/burger/${burger.id}">edit</a>
					<form action="/burger/${burger.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" class="btn btn-link m-0 p-0" value="delete">
					</form>
						
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<h2>Add a New Burger!</h2>
	<form:form class="card bg-light m-3 p-3 text-dark w-25" action="/create" method="post" modelAttribute="burger">
	
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