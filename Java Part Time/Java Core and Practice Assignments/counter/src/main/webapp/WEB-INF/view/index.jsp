<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<div class="container-fluid w-75 d-flex flex-column text-center">
		<h1>Welcome User!</h1>
		<p>You have visited this page <c:out value="${count}"/> times.
		<div class="d-flex justify-content-evenly p-3">
			<form action="/addTwo" method="post">
				<input type="submit" class="btn btn-primary" value="Add Two" name="addTwo">
			</form>
			<form action="/clear" method="post">
				<input type="submit" class="btn btn-secondary" value="Clear">
			</form>
		</div>
	</div>
</body>
</html>