<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	<link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Tangerine">
<meta charset="UTF-8">
<title>CRM App</title>
</head>
<body class="bg-danger">
	<h1 class="p-3 mb-2 text-warning bg-dark" style="font-family: 'Bakbak one';">Customer Relationship Management Portal</h1>
	<hr>
	<form action="search" class="form-inline float-right mb-3 pr-5">
		<input type="search" name="sName" placeholder="First Name"
			class="form-control-sm ml-5 mr-2 mb-3 "/>
		<button type="submit" class="btn btn-primary btn-sm mb-3">Search</button>
	</form>
	<div class="container" style="font-family: 'Bebas Neue', serif;">
		<a href="add" class="btn btn-primary btn-sm mb-3"> Register </a>
		<a href="" class="btn btn-primary btn-sm mb-3"> List All </a>
		<table class="table table-bordered table-striped">
			<tr>
				<th>Customer ID</th>
				<th>Customer First-Name</th>
				<th>Customer Last-Name</th>
				<th>Customer Email ID</th>
			</tr>
			<c:forEach items="${customers }" var="customer">
				<tr>
					<td>${customer.id }</td>
					<td>${customer.firstName }</td>
					<td>${customer.lastName }</td>
					<td>${customer.email }</td>
					<td>
						<a href="cusEditForm?id=${customer.id}" class="btn btn-success btn-sm mb-3"> Update </a>
						<a href="delete?id=${customer.id}" class="btn btn-dark btn-sm mb-3" 
						onclick="if (!(confirm('Are you sure you want to delete this Customer Record?'))) return false">Delete </a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>