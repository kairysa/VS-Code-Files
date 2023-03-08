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
<title>Edit Book</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1>Change your Entry!</h1>
			<a href="/home" class="w-75 d-flex justify-content-end">Back to Dashboard</a>
			<form:form action="/edit/${book.id}" method="post" modelAttribute="book" class="form-group w-50">
				<form:label path="title" class="mt-3">Title:</form:label>
				<form:errors path="title" class="text-danger"/>
				<form:input type="text" path="title" class="form-control" value="${book.title}"/>
				
				<form:label path="author" class="mt-3">Author:</form:label>
				<form:errors path="author" class="text-danger"/>
				<form:input type="text" path="author" class="form-control" value="${book.author}"/>
				
				<form:label path="notes" class="mt-3">Notes:</form:label>
				<form:errors path="notes" class="text-danger"/>
				<form:textarea path="notes" class="form-control"/>
				
				<form:input type="hidden" path="user" value="${book.user.id}"/>
			
			<div class="d-flex w-100 justify-content-around mt-3">
				<input type="submit" class="btn btn-primary" value="Apply Changes"/>
			
			</form:form>
			<form action="/delete/${book.id}" method="post">
				<input type="submit" value="Delete Book" class="btn btn-danger">
			</form>
			</div>	
		</div>
	</div>
</body>
