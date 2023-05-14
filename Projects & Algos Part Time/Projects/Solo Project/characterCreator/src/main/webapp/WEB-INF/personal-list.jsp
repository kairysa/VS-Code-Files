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
<title>Your Characters</title>
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
			<h3 class="jumbotron-heading">Your Characters</h3>
			<a href="/character/create">Create your own character</a>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Character Name</th>
						<th>User</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneCharacter" items="${characterList}">
						<c:if test="${user.id == oneCharacter.user.id}">
							<tr>
								<td><c:out value="${oneCharacter.name}"/></td>
								<td><c:out value="${oneCharacter.user.userName}"/></td>
								<td>
									<a href="/character/edit/${oneCharacter.id}" class="p-0 m-0">edit</a>
									<a href="/character/view/${oneCharacter.id}" class="p-0 m-0">view</a>
									<a href="/character/delete/${oneCharacter.id}" class="p-0 m-0">delete</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</main>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>