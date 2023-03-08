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
<title>Edit Expense</title>
</head>
<body class="container-fluid d-flex flex-column align-items-center bg-dark text-white text-center">
	<h2>Edit Expense:</h2>
	<form:form class="card bg-light m-3 p-3 text-dark w-25" action="/edit/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		
		<form:label path="expenseName">Expense Name:</form:label>
		<form:errors path="expenseName" class="text-danger"/>
		<form:input type="text" path="expenseName" class="form-control"/>
		
		<form:label path="vendor" class="mt-3">Vendor:</form:label>
		<form:errors path="vendor" class="text-danger"/>
		<form:input type="text" path="vendor" class="form-control"/>
		
		<form:label path="amount" class="mt-3">Amount:</form:label>
		<form:errors path="amount" class="text-danger"/>
		<form:input type="number" path="amount" step="0.01" class="form-control"/>
		
		<form:label path="description" class="mt-3">Description:</form:label>
		<form:errors path="description" class="text-danger"/>
		<form:textarea path="description" class="form-control"/>
		
		<input type="submit" value="Submit Input" class="mt-3 btn btn-primary">
		
	</form:form>
</body>
</html>