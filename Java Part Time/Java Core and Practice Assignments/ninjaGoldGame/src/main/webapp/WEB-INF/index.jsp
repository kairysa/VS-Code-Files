<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body class="container-fluid d-flex flex-column p-3 text-center align-items-center bg-dark text-white">
	<h1>Ninja Gold Game!</h1>
	<h3>Your gold: <c:out value="${gold}"/></h3>
	<div class="d-flex text-center w-50 justify-content-center">
		<form action="/gold" method="post" class="border border-black p-3 m-2">
			<h2>Farm</h2>
			<br>
			<h4>Earns 10-20 gold</h4>
			<br>
			<input type="submit" class="btn btn-primary" value="Find Gold!">
			<input type="hidden" value="farm" name="farm">
		</form>
		
		<form action="/gold" method="post" class="border border-black p-3 m-2">
			<h2>Cave</h2>
			<br>
			<h4>Earns 5-10 gold</h4>
			<br>
			<input type="submit" class="btn btn-primary" value="Find Gold!">
			<input type="hidden" value="cave" name="cave">
		</form>
		
		<form action="/gold" method="post" class="border border-black p-3 m-2">
			<h2>House</h2>
			<br>
			<h4>Earns 2-5 gold</h4>
			<br>
			<input type="submit" class="btn btn-primary" value="Find Gold!">
			<input type="hidden" value="house" name="house">
		</form>
		
		<form action="/gold" method="post" class="border border-black p-3 m-2">
			<h2>Quest</h2>
			<br>
			<h4>Earn/Takes 0-50 gold</h4>
			<br>
			<input type="submit" class="btn btn-primary" value="Find Gold!">
			<input type="hidden" value="quest" name="quest">
		</form>
	</div>
	<h3 class="m-3">Activities</h3>
	<div class="w-50 overflow-auto border border-black text-start p-2" style="height: 120px;">
		<c:forEach var="x" items="${activities}">
			<p class="m-0"><c:out value="${x}"/></p>
		</c:forEach>
	</div>
</body>
</html>