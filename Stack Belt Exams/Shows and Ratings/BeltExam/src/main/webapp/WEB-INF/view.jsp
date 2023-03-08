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
<title>View Show</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1><c:out value="${selectedShow.title}"/></h1>
				<a href="/shows" class="w-75 d-flex justify-content-end">Back to Dashboard</a>
			<table class="table text-white w-75 m-3">
				<tbody>
					<tr>
						<th>Posted By</th>
						<td><c:out value="${selectedShow.user.name}"/></td>
					</tr>
					<tr>
						<th>Network</th>
						<td><c:out value="${selectedShow.network}"/></td>
					</tr>
					<tr>	
						<th>Description</th>
						<td><c:out value="${selectedShow.description}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="p-3 d-flex">
			<c:if test="${user.id == selectedShow.user.id}">
					<a href="/shows/edit/${selectedShow.id}" class="btn btn-secondary px-4">Edit</a>
					<form action="/shows/delete/${selectedShow.id}" method="post">
						<input type="submit" class="btn btn-danger mx-3" value="Delete"/>
					</form>
			</c:if>
		</div>
		<div class="container">
			<div class="row p-3 text-white">
				<h3>Ratings</h3>
				<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="oneRating" items="${ratings}">
							<c:if test="${oneRating.show.id == selectedShow.id}">
								<tr>
									<td><c:out value="${oneRating.user.name}"/></td>
									<td><c:out value="${oneRating.rating}"/></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<form:form action="/rating/new" method="post" modelAttribute="rating" class="d-flex w-50 justify-content-around">
					<form:label path="rating">Leave a rating:</form:label>
					<form:input type="number" path="rating" class="form-control w-25"/>
					
					<form:input type="hidden" path="user" value="${user.id}"/>
					<form:input type="hidden" path="show" value="${selectedShow.id}"/>
					
					<input type="submit" class="btn btn-secondary" value="Rate">
					<form:errors path="rating" class="text-danger"/>
			</form:form>
		</div>
	</div>
</body>
</html>