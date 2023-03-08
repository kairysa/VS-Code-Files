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
<title>View Product</title>
</head>
<body class="container bg-dark">
	<div class="row text-center p-3 text-white">
		<h1><c:out value="${oneProduct.name}"/></h1>
	</div>
	<div class="w-100 d-flex justify-content-end">
		<a href="/" class="px-3">Home</a>
	</div>
	<div class="row m-3">
		<table class="table text-white table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<td><c:out value="${oneProduct.name}"/></td>
				</tr>
				<tr>
					<th>Description</th>
					<td><c:out value="${oneProduct.description}"/></td>
				</tr>
				<tr>
					<th>Price</th>
					<td><c:out value="${oneProduct.price}"/></td>
				</tr>
			</thead>
		</table>
	</div>
	<div class="row m-3 text-white">
		<h2>Categories</h2>
		<c:forEach var="categoryInProduct" items="${oneProduct.categories}">
			<p>- <c:out value="${categoryInProduct.name}"/></p>
		</c:forEach>
		<br>
		<h4>Add Category</h4>
		<form:form action="/product/edit" method="post" modelAttribute="product">
			<form:input type="hidden" path="id" value="${oneProduct.id}"/>
			<form:input type="hidden" path="name" value="${oneProduct.name}"/>
			<form:input type="hidden" path="description" value="${oneProduct.description}"/>
			<form:input type="hidden" path="price" value="${oneProduct.price}"/>
			<form:select  class="form-select" path="categories" multiple="single">
				<c:forEach var="oneCat" items="${allCategories}">
					<form:option value="${oneCat.id}">
						<c:out value="${oneCat.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
			<input type="submit" class="btn btn-primary mt-3" value="Add">
		</form:form>
	</div>
</body>
</html>