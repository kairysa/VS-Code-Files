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
			<h1>Welcome <c:out value="${user.userName}"/> to the Book Broker!</h1>
			<div class="d-flex">
				<p>Books from everyone's shelves: </p> 
				<a href="/books/new" class="w-75 d-flex justify-content-end">+ Add to my shelf</a>
			</div>
			<table class="table table-bordered text-white">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneBook" items="${books}">
						<tr>
							<td><c:out value="${oneBook.id}"/></td>
							<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"/></a></td>
							<td><c:out value="${oneBook.author}"/></td>
							<td><c:out value="${oneBook.user.userName}"/></td>
							<td class="d-flex">
								<c:choose>
									<c:when test="${user.id == oneBook.user.id}">
										<a href="/edit/${oneBook.id}" class="p-0 m-0">edit</a>
										<form action="/delete/${oneBook.id}" method="post">
											<input type="submit" class="btn btn-link m-0 p-0" value="delete">
										</form>
									</c:when>
									<c:when test="${user.id != oneBook.user.id}">
										<form:form action="/borrow/${oneBook.id}" method="post" modelAttribute="borrow">
											<form:input type="hidden" path="title" value="${oneBook.title}"/>
											<form:input type="hidden" path="author" value="${oneBook.author}"/>
											<form:input type="hidden" path="notes" value="${oneBook.notes}"/>
											<form:input type="hidden" path="user" value="${oneBook.user.id}"/>
											<form:input type="hidden" path="borrowerId" value="${user.id}"/>
											<input type="submit" class="btn btn-link m-0 p-0" value="borrow"/>
										</form:form>
									</c:when>
								</c:choose>
							</td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row p-3">
			<h4>Books I'm borrowing:</h4>
			<table class="table table-bordered text-white">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneBook" items="${borrows}">
						<c:if test="${user.id == oneBook.borrowerId}">
							<tr>
								<td><c:out value="${oneBook.id}"/></td>
								<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"/></a></td>
								<td><c:out value="${oneBook.author}"/></td>
								<td><c:out value="${oneBook.user.userName}"/></td>
								<td>
									<form:form action="/return/${oneBook.id}" method="post" modelAttribute="book">
										<form:input type="hidden" path="title" value="${oneBook.title}"/>
										<form:input type="hidden" path="author" value="${oneBook.author}"/>
										<form:input type="hidden" path="notes" value="${oneBook.notes}"/>
										<form:input type="hidden" path="user" value="${oneBook.user.id}"/>
										<input type="submit" class="btn btn-link m-0 p-0" value="return"/>		
									</form:form>
								</td>					
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<form action="/logout" method="post">
				<input type="submit" value="Logout" class="btn btn-primary">
			</form>
		</div>
	</div>
</body>
</html>