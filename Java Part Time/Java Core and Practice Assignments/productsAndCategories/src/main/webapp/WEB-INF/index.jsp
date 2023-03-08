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
<title>Products and Categories</title>
</head>
<body class="container bg-dark">
	<div class="row text-center p-3 text-white">
		<h1>Home Page</h1>
	</div>
	<div class="w-100 d-flex justify-content-end">
		<a href="/product" class="px-3">New Product</a>
		<a href="/category" class="px-3">New Category</a>
	</div>
	<div class="row m-3">
		<div class="col">
			<table class="table text-white text-center">
				<thead>
					<tr>
						<th>Products</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneProduct" items="${products}">
						<tr>
							<td>
								<a href="/product/${oneProduct.id}">
									<c:out value="${oneProduct.name}"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col">
			<table class="table text-white text-center">
				<thead>
					<tr>
						<th>Categories</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneCategory" items="${categories}">
						<tr>
							<td>
								<a href="/category/${oneCategory.id}">
									<c:out value="${oneCategory.name}"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>