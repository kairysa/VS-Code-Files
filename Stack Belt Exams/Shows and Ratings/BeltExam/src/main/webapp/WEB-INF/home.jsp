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
<title>Dashboard</title>
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="row p-3">
			<h1>Welcome <c:out value="${user.name}"/></h1>
			<div class="d-flex">
				<p>TV Shows: </p> 
				<a href="/shows/new" class="w-75 d-flex justify-content-end">+ Add show</a>
			</div>
			<table class="table table-bordered text-white">
				<thead>
					<tr>
						<th>Title</th>
						<th>Network</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneShow" items="${shows}">
						<tr>
							<td><c:out value="${oneShow.title}"/></td>
							<td><c:out value="${oneShow.network}"/></td>
							<td class="d-flex justify-content-around">
								<c:choose>
									<c:when test="${user.id == oneShow.user.id}">
										<a href="/shows/edit/${oneShow.id}" class="p-0 m-0">edit</a>
										<a href="/shows/view/${oneShow.id}" class="p-0 m-0">view</a>
										<form action="/shows/delete/${oneShow.id}" method="post">
											<input type="submit" class="btn btn-link m-0 p-0" value="delete">
										</form>
									</c:when>
									<c:when test="${user.id != oneShow.user.id}">
										<a href="/shows/view/${oneShow.id}" class="p-0 m-0">view</a>
									</c:when>
								</c:choose>
							</td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form action="/logout" method="post">
			<input type="submit" value="Logout" class="btn btn-primary">
		</form>
	</div>
</body>
</html>