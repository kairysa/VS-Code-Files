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
<title>View Book</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1><c:out value="${book.title}"/></h1>
			<div class="d-flex">
				<p>Here are <c:out value="${book.user.userName}"/>'s thoughts:</p> 
				<a href="/home" class="w-75 d-flex justify-content-end">Back to Dashboard</a>
			</div>
			<br class="text-white">
			<h4><c:out value="${book.notes}"/></h4>
			<br class="text-white">
			<form action="/logout" method="post">
				<input type="submit" value="Logout" class="btn btn-primary">
			</form>
		</div>
	</div>
</body>
</html>