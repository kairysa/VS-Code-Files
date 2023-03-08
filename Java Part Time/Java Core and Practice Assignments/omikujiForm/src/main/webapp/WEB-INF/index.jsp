<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
</head>
<body>
	<div class="container-fluid w-75 d-flex flex-column text-center align-items-center">
		<h1 class="p-3">Send an Omikuji!</h1>
		<div class="pink p-3 d-flex justify-content-center w-25">
			<form action="/omikuji/input" method="post" class="form-group w-100">
				
				<label for="number">Pick any number from 5 to 25</label>
				<input type="number" name="number" class="form-control" min="5" max="25">
				<br>
			
				<label for="city">Enter the name of any city</label>
				<input type="text" name="city" class="form-control">
				<br>
				
				<label for="name">Enter the name of any real person</label>
				<input type="text" name="name" class="form-control">
				<br>
				
				<label for="hobby">Enter professional endeavor or hobby</label>
				<input type="text" name="hobby" class="form-control">
				<br>
				
				<label for="thing">Enter any type of living thing</label>
				<input type="text" name="thing" class="form-control">
				<br>
				
				<label for="saysomething">Say something nice to someone</label>
				<textarea name="saysomething" class="form-control"></textarea>
				<br>
				
				<p>Send and show a friend!</p>
				<input type="submit" class="btn btn-primary w-50" value="Submit">
				
			</form>
		</div>
	</div>
</body>
</html>