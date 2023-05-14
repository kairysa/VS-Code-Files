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
<title>Character Creator</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg bg-primary text-white p-2">
			<div class="container">
				<a class="navbar-brand text-white" href="/">Coding Dojo World!</a>
				<div class="d-flex justify-content-end collapse navbar-collapse text-white" id="navbarNavDropdown">
					<ul class="navbar-nav">
				      	<li class="nav-item">
				        	<a class="nav-link text-white" href="/">Home</a>
				      	</li>
				      	<li class="nav-item">
				        	<a class="nav-link text-white" href="/character">Characters</a>
				      	</li>
				      	<li class="nav-item">
				      		<a class="nav-link text-white" href="#">Support</a>
				      	</li>
				      	<li class="nav-item dropdown">
				        	<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				        		<c:out value="${user.userName}"/>
				        	</a>
				        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					        	<a class="dropdown-item" href="/character/view">View Characters</a>
					        	<a class="dropdown-item" href='/logout'>Logout</a>
				        	</div>
				      	</li>
				    </ul>
				  </div>
			</div>
		</nav>
	</header>
	<main role="main" class="container d-flex justify-content-center">
		<div class="card m-3 shadow-lg">
			<div class="card-body m-3">
				<h1>Character Creator</h1>
				<form:form action="/character/create/new" modelAttribute="newCharacter" method="post" class="form-group">
					<form:label path="name">Character Name:</form:label>
					<form:errors path="name" class="text-danger"/>
					<form:input type="text" path="name" class="form-control"/>
					
					<form:label path="race" class="mt-3">Race:</form:label>
					<form:select path="race" class="form-select">
						<option value="human">Human</option>
						<option value="elf">Elf</option>
						<option value="half-elf">Half-elf</option>
						<option value="goblin">Goblin</option>
						<option value="gnome">Gnome</option>
						<option value="dwarf">Dwarf</option>
						<option value="dragonoid">Dragonoid</option>
					</form:select>
					
					<form:label path="hairColor" class="mt-3">Hair Color:</form:label>
					<form:errors path="hairColor" class="text-danger"/>
					<form:input type="text" path="hairColor" class="form-control"/>
					
					<form:label path="eyeColor" class="mt-3">Eye Color:</form:label>
					<form:errors path="eyeColor" class="text-danger"/>
					<form:input type="text" path="eyeColor" class="form-control"/>
					
					<form:label path="age" class="mt-3">Age:</form:label>
					<form:errors path="age" class="text-danger"/>
					<form:input type="number" path="age" class="form-control"/>
					
					<form:label path="gender" class="mt-3">Gender:</form:label>
					<form:select path="gender" class="form-select">
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="prefer not to answer">Prefer not to answer</option>
					</form:select>
					
					<form:hidden path="user" value="${user.id}"></form:hidden>
					
					<input type="submit" class="btn btn-primary mt-3 w-100" value="Create"/>
				</form:form>
			</div>
		</div>
	</main>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>