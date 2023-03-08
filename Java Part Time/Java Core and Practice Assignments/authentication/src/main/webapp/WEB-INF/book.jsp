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
<title>Add Book</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1>Add a Book to your shelf!</h1>
		</div>
		<div class="row">
			<div class="col p-3">
				<form:form action="/books/create" modelAttribute="newBook" method="post" class="form-group w-50">
					<form:label path="title" class="mt-3">Title:</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input type="text" path="title" class="form-control"/>
					
					<form:label path="author" class="mt-3">Author</form:label>
					<form:errors path="author" class="text-danger"/>
					<form:input type="text" path="author" class="form-control"/>
					
					<form:label path="notes" class="mt-3">Thoughts:</form:label>
					<form:errors path="notes" class="text-danger"/>
					<form:textarea path="notes" class="form-control"></form:textarea>
					
					<form:input type="hidden" path="user" value="${currentUser.id}"/>
					
					<input type="submit" class="btn btn-primary mt-3" value="Submit">
				</form:form>
			</div>