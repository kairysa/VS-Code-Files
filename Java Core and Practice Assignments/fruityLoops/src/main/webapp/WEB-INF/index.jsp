<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fruity Loops</title>
</head>
<body>
	<div class="container-fluid d-flex flex-column w-50 text-center">
		<h1 class="p-3 text-pink">Fruit Store</h1>
		<div class="p-3 pink">
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneFruit" items="${fruits}">
						<tr>
							<td><c:out value="${oneFruit.name}"/></td>
							<td><c:out value="${oneFruit.price}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>