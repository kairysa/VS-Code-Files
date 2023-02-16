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
<title>Dojos and Ninjas - View Students</title>
</head>
<body class="container bg-dark text-white">
	<div class="row">
		<div class="col">
			<h1 class="p-3"><c:out value="${dojo.dojoName}"/> Student List</h1>
			<table class="table table-bordered text-white">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneNinja" items="${dojo.ninjas}">
						<tr>
							<td><c:out value="${oneNinja.firstName}"/></td>
							<td><c:out value="${oneNinja.lastName}"/></td>
							<td><c:out value="${oneNinja.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="/">Go back</a>
		</div>
	</div>
</body>
</html>