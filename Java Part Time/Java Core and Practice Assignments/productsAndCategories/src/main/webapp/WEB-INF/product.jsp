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
<title>New Product</title>
</head>
<body class="container bg-dark">
	<div class="row text-center p-3 text-white">
		<h1>New Category</h1>
	</div>
	<div class="w-100 d-flex justify-content-end">
		<a href="/" class="px-3">Home</a>
	</div>
	<div class="row m-3">
		<form:form action="/product/new" modelAttribute="product" method="post">
			<table class="table text-white">
				<thead>
					<tr>
						<th>
							<form:label path="name">Name:</form:label> 
							<form:errors path="name" class="text-danger"/>
						</th>
						<td><form:input type="text" path="name" class="form-control"/></td>
					</tr>
					<tr>
						<th>
							<form:label path="description">Description:</form:label>
							<form:errors path="description" class="text-danger"/>
						</th>
						<td><form:input type="text" path="description" class="form-control"/></td>
					</tr>
					<tr>
						<th>
							<form:label path="price">Price:</form:label>
							<form:errors path="price" class="text-danger"/>
						</th>
						<td><form:input type="number" path="price" class="form-control" step="0.01"/></td>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td colspan="2">
							<input type="submit" class="btn btn-primary w-100" value="Submit">
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>