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
<title>Edit Show</title>
</head>
<body class="bg bg-dark text-white">
	<div class="container text-white">
		<div class="row p-3">
			<h1>Edit <c:out value="${selectedShow.title}"/></h1>
			<a href="/shows" class="w-75 d-flex justify-content-end">Back to Dashboard</a>
		</div>
		<div class="row">
			<div class="col p-3">
				<form:form action="/shows/edit" modelAttribute="editShow" method="post" class="form-group w-50">
					<form:label path="title" class="mt-3">Title:</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input type="text" path="title" class="form-control" value="${selectedShow.title}"/>
					
					<form:label path="network" class="mt-3">Network:</form:label>
					<form:errors path="network" class="text-danger"/>
					<form:input type="text" path="network" class="form-control" value="${selectedShow.network}"/>
					
					<form:label path="description" class="mt-3">Description:</form:label>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" class="form-control"></form:textarea>
					
					<form:input type="hidden" path="user" value="${user.id}"/>
					<form:input type="hidden" path="id" value="${selectedShow.id}"/>
						
					<input type="submit" class="btn btn-primary mt-3" value="Submit">
				</form:form>
			</div>
			<form action="/shows/delete/${selectedShow.id}" method="post">
						<input type="submit" class="btn btn-danger mx-2" value="Delete"/>
			</form>
		</div>
	</div>
</body>
</html>