<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Receipt</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${name}"/></h1>
	<p>Item Name: <c:out value="${itemName}"/></p>
	<p>Price: $<c:out value="${price}"/></p>
	<p>Description: <c:out value="${description}"/></p>
	<p class="test">Vendor: <c:out value="${vendor}"/></p>

</body>
</html>