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
<title>Create a Show</title>
</head>
<body class="bg bg-dark text-white">
	<div class="container text-white">
		<div class="row p-3">
			<h1>Create a New TV Show</h1>
			<a href="/shows" class="w-75 d-flex justify-content-end">Back to Dashboard</a>
		</div>
		<div class="row">
			<div class="col p-3">
				<form:form action="/shows/new/create" modelAttribute="newShow" method="post" class="form-group w-50">
					<form:label path="title" class="mt-3">Title:</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input type="text" path="title" class="form-control"/>
					
					<form:label path="network" class="mt-3">Network:</form:label>
					<form:errors path="network" class="text-danger"/>
					<form:input type="text" path="network" class="form-control"/>
					
					<form:label path="description" class="mt-3">Description:</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" class="form-control"></form:textarea>
					
					<form:input type="hidden" path="user" value="${user.id}"/>
					
					<input type="submit" class="btn btn-primary mt-3" value="Submit">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>