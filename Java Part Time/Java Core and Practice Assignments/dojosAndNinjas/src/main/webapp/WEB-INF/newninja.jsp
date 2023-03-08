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
<title>Dojos and Ninjas - New Ninja</title>
</head>
<body class="container bg-dark text-white">
	<div class="row">
		<div class="col">
			<h2>New Ninja:</h2>
				<form:form action="/create/ninja" method="post" modelAttribute="ninja" class="form-group w-25">
	
					<form:label path="firstName">First Name:</form:label>
					<form:errors path="firstName" class="text-danger"/>
					<form:input type="text" path="firstName" class="form-control"/>
					
					<form:label path="lastName" class="mt-3">Last Name:</form:label>
					<form:errors path="lastName" class="text-danger"/>
					<form:input type="text" path="lastName" class="form-control"/>
					
					<form:label path="age" class="mt-3">Age:</form:label>
					<form:errors path="age" class="text-danger"/>
					<form:input type="number" path="age" class="form-control"/>
					
					<form:label path="dojo" class="mt-3">Select Dojo:</form:label>
					<form:select path="dojo" class="form-select">
						<c:forEach var="oneDojo" items="${dojoList}">
							<form:option value="${oneDojo.id}">
								<c:out value="${oneDojo.dojoName}"/>
							</form:option>
						</c:forEach>
					</form:select>
		
					<input type="submit" value="Submit Input" class="mt-3 btn btn-primary">
		
				</form:form>
		</div>
		<br>
		<a href="/" class="mt-3">Go back</a>
	</div>
</body>
</html>