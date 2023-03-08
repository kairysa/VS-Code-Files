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
<title>View Expense</title>
</head>
<body class="container-fluid d-flex flex-column align-items-center bg-dark text-white text-center">
	<h2>Expense Details:</h2>
	<table class="table table-bordered w-50 text-white p-3 m-3">
		<tbody>
			<tr>
				<th class="col-4">Expense Name</th>
				<td><c:out value="${expense.expenseName}"/></td>
			</tr>
			<tr>
				<th class="col-4">Vendor</th>
				<td><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<th class="col-4">Amount</th>
				<td><c:out value="${expense.amount}"/></td>
			</tr>
			<tr>
				<th class="col-4">Description</th>
				<td><c:out value="${expense.description}"/></td>
			</tr>
		</tbody>
	</table>
	<br>
	<a href="/">Go back</a>
</body>
</html>