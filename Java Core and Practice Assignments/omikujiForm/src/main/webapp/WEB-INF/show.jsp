<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Result</title>
</head>
<body>
	<div class="container-fluid w-75 d-flex flex-column text-center align-items-center">
		<h1 class="p-3">Here's Your Omikuji!</h1>
		<div class="pink p-3 d-flex justify-content-center w-25">
			<h3>In 10 years, you will live in <c:out value="${city}"/> with <c:out value="${name}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${saysomething}"/></h3>
		</div>
		<a href="/omikuji" class="p-3">Go back</a>
	</div>
</body>
</html>