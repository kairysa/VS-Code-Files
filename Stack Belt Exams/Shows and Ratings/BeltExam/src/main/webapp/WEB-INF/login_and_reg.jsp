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
<title>Login and Registration</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1>TV Shows Database</h1>
		</div>
		<div class="row">
			<div class="col p-3">
				<h2 class="text-primary">Register!</h2>
				<form:form action="/register" modelAttribute="newUser" method="post" class="form-group w-50">
					<form:label path="name" class="mt-3">Name:</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input type="text" path="name" class="form-control"/>
					
					<form:label path="email" class="mt-3">Email:</form:label>
					<form:errors path="email" class="text-danger"/>
					<form:input type="text" path="email" class="form-control"/>

					<form:label path="password" class="mt-3">Password:</form:label>
					<form:errors path="password" class="text-danger"/>
					<form:input type="password" path="password" class="form-control"/>
					
					<form:label path="confirm" class="mt-3">Confirm Password:</form:label>
					<form:errors path="confirm" class="text-danger"/>
					<form:input type="password" path="confirm" class="form-control"/>
					
					<input type="submit" class="btn btn-primary mt-3" value="Register">
				</form:form>
			</div>
			<div class="col p-3">
				<h2 class="text-secondary">Login!</h2>
				<form:form action="/login" modelAttribute="newLogin" method="post" class="form-group w-50">
					<form:label path="email" class="mt-3">Email:</form:label>
					<form:errors path="email" class="text-danger"/>
					<form:input type="text" path="email" class="form-control"/>	

					<form:label path="password" class="mt-3">Password:</form:label>
					<form:errors path="password" class="text-danger"/>
					<form:input type="password" path="password" class="form-control"/>	
					
					<input type="submit" class="btn btn-primary mt-3" value="Login">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>