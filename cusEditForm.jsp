<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Update details</title>
</head>
<hr>
<hr>

<body class="bg-danger">
<div class="container">

		<h1 class="p-3 mb-2 text-warning bg-dark" style="font-family: 'Bakbak one';">Update Customer details</h1>
		<hr>

		<p class="h4 mb-4">Update Student</p>

		<form action="updateInfo" method="POST">
		
			<div class="form-inline">
				<input type="text" name="id" value="${Customer.id}"
					class="form-control mb-4 col-4" placeholder="Id">
			</div>
		
			<div class="form-inline">
				<input type="text" name="firstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>

			<div class="form-inline">
				<input type="text" name="lastName" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			<div class="form-inline">
				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email ID">
			</div>
			<button type="submit" class="btn btn-info col-2">Update</button>
		</form>

		<hr>
		<a href="/CRM_Web_App">Back to Customer  List</a>
	</div>
	<hr>
	<hr>
</body>
</html>