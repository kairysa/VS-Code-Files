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
<title>New Book</title>
</head>
<body class="bg-dark text-pink container-fluid p-3 d-flex align-items-center flex-column">
	<h1 class="text-white p-3">New Book!</h1>
	<form:form action="/books/new/create" method="post" modelAttribute="book" class="w-25 bg-light card p-3 text-dark">
	
		<form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-danger"/>
		<form:input type="text" path="title" class="form-control"/>
		
		<form:label path="description" class="mt-3">Description:</form:label>
		<form:errors path="description" class="text-danger"/>
		<form:textarea path="description" class="form-control"></form:textarea>
		
		<form:label path="language" class="mt-3">Language:</form:label>
		<form:errors path="language" class="text-danger"/>
		<form:input type="text" path="language" class="form-control"/>
		
		<form:label path="numberOfPages" class="mt-3">Number of Pages:</form:label>
		<form:errors path="numberOfPages" class="text-danger"/>
		<form:input type="number" path="numberOfPages" class="form-control"/>
		
		<input type="submit" class="btn btn-primary mt-3" value="Submit">
	</form:form>


</body>
</html>