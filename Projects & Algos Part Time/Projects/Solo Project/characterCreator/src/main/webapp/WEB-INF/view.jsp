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
<title>View Character</title>
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
				      		<c:choose>
				        		<c:when test="${user.userName == null}">
				        			<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				        				Account
				        			</a>
				        		</c:when>
				      			<c:when test="${user.userName != null}">
				        			<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				        				<c:out value="${user.userName}"/>
				        			</a>
				        		</c:when>
				        	</c:choose>
				        	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				        		<c:choose>
					        		<c:when test="${user.id == null}">
					        	 		<a class="dropdown-item" href='/login'>Login</a>
					        			<a class="dropdown-item" href="/register">Register</a>
					        		</c:when>
					        		<c:when test="${user.id != null}">
					        			<a class="dropdown-item" href="/character/view">View Characters</a>
					        			<a class="dropdown-item" href='/logout'>Logout</a>
					        		</c:when>
					        	</c:choose>
				        	</div>
				      	</li>
				    </ul>
				  </div>
			</div>
		</nav>
	</header>
	<main role="main">
		<div class="container d-flex flex-column align-items-center p-3">
			<h3 class="jumbotron-heading"><c:out value="${selectedCharacter.name}"/>'s Details</h3>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>Character Name</th>
						<td><c:out value="${selectedCharacter.name}"/></td>
					</tr>
					
					<tr>
						<th>Race</th>
						<td><c:out value="${selectedCharacter.race}"/></td>
					</tr>
					<tr>
						<th>Hair Color</th>
						<td><c:out value="${selectedCharacter.hairColor}"/></td>
					</tr>
					<tr>
						<th>Eye Color</th>
						<td><c:out value="${selectedCharacter.eyeColor}"/></td>
					</tr>
					<tr>
						<th>Age</th>
						<td><c:out value="${selectedCharacter.age}"/></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><c:out value="${selectedCharacter.gender}"/></td>
					</tr>
				</tbody>
			</table>
		</div>
		
	</main>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>