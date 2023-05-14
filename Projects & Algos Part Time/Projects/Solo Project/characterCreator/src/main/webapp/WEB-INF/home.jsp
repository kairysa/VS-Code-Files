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
<title>Coding Dojo World</title>
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
	<section class="text-center p-3">
		<div class="container d-flex flex-column align-items-center">
			<c:choose>
				<c:when test="${user.id == null}">
					<h1 class="jumbotron-heading">Welcome to the World of Code!</h1>
					<p class="text-muted w-50">Create a character! Share PC parts with your friends! Advanced your skills in coding - become a jack of all trades, or specialize in specific fields! <a href="/register">Join today!</a></p>
				</c:when>
				<c:when test="${user.id != null}">
					<h1 class="jumbotron-heading">Welcome <c:out value="${user.userName}"/>!</h1>
					<p class="text-muted w-50">Check out the latest news below. Contact support for any questions or bugs and the team will get back to you as quickly as possible!</p>
				</c:when>
			</c:choose>
		</div>
	</section>
	<main role="main">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="card flex-md-row mb-4 box-shadow h-md-250">
						<div class="card-body d-flex flex-column align-items-start">
							<h3>News</h3>
							<p class="mb-1 text-muted">May 5th</p>
							<br>
							<p class="card-text mb-auto">Hotfixes and upcoming item price changes.</p>
							<a href="#">Read More</a>
						</div>
						<img class="card-img-right flex-auto d-none d-md-block" style="width: 20vmw; height: 250px;" src="https://thumbs.dreamstime.com/b/fix-button-8991236.jpg"/>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card flex-md-row mb-4 box-shadow h-md-250">
						<div class="card-body d-flex flex-column align-items-start">
							<h3>Dev Preview</h3>
							<p class="mb-1 text-muted">May 14th</p>
							<br>
							<p class="card-text mb-auto">All new specialization coming - Cyber Security! Take an early look at their skills and abilities.</p>
							<a href="#">Read More</a>
						</div>
						<img class="card-img-right flex-auto d-none d-md-block" style="width: 50vmw; height: 250px;" src="https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"/>
					</div>
				</div>
				<div class="col-md-6"></div>
			</div>
		</div>
	</main>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>