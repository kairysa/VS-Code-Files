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
<title>Login</title>
</head>
<body>
	<main role="main" class="container d-flex justify-content-center my-5">
		<div class="card shadow-lg">
			<div class="card-body m-3">
				<h3 class="text-primary card-title"><strong>Login</strong></h3>
				<form:form action="/login" modelAttribute="newLogin" method="post" class="form-group">
					
					<form:label path="email" class="mt-3">Email:</form:label>
					<form:errors path="email" class="text-danger"/>
					<form:input type="text" path="email" class="form-control"/>

					<form:label path="password" class="mt-3">Password:</form:label>
					<form:errors path="password" class="text-danger"/>
					<form:input type="password" path="password" class="form-control"/>
					
					<input type="submit" class="btn btn-primary mt-3 w-100" value="Login">
				</form:form>
			</div>
			<div class="bg-light p-1 d-flex justify-content-center align-items-center">
				<p>Don't have an account? <a href="/register">Register</a>
			</div>
		</div>
	</main>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>