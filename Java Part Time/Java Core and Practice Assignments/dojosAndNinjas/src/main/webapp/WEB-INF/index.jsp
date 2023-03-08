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
<title>Dojos and Ninjas - Dashboard</title>
</head>
<body class="container bg-dark text-white">
	<div class="row">
		<div class="col">
			<h1 class="p-3">Dojos</h1>
			<table class="table table-bordered text-white">
				<thead>
					<tr>
						<th>Dojo Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneDojo" items="${dojos}">
						<tr>
							<td><c:out value="${oneDojo.dojoName}"/></td>
							<td><a href="/dojo/${oneDojo.id}">See Students</a>	
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col">
			<br>
			<h2>New Dojo:</h2>
				<form:form action="/create/dojo" method="post" modelAttribute="dojo">
	
					<form:label path="dojoName">Dojo Name:</form:label>
					<form:errors path="dojoName" class="text-danger"/>
					<form:input type="text" path="dojoName" class="form-control"/>
		
					<input type="submit" value="Submit Input" class="mt-3 btn btn-primary">
		
				</form:form>
		</div>
	</div>
	<div class="row justify-content-center">
		<a href="/ninja">Add a ninja to a dojo</a>
	</div>
</body>
</html>