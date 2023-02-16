<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books MVC Test</title>
</head>
<body class="bg bg-dark text-pink">
	<div class="container-fluid d-flex flex-column w-75 text-center">
		<h1 class="p-3 text-pink">Books!</h1>
		<div class="p-3 pink">
			<table class="table table-bordered table-dark text-pink">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Language</th>
						<th>Number of Pages</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneBook" items="${books}">
						<tr>
							<td><c:out value="${oneBook.id}"/>
							<td><a href="/books/<c:out value='${oneBook.id}'/>"><c:out value="${oneBook.title}"/></a></td>
							<td><c:out value="${oneBook.language}"/></td>
							<td><c:out value="${oneBook.numberOfPages}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/books/new">Create New Book</a>
		</div>
	</div>
</body>
</html>