<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time Page</title>
</head>
<body>
	<div class="container w-100 d-flex justify-content-center p-4">
		<h1>Current Time: <c:out value="${time}"/></h1>
	</div>

</body>
<script src="/js/time.js"></script>
</html>