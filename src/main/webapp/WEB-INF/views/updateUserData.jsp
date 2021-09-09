<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<style>
.card {
	margin: 0 auto; /* Added */
	float: none; /* Added */
	margin-bottom: 10px; /* Added */
}

#message {
	display: none;
	background: #f1f1f1;
	color: #000;
	position: relative;
	padding: 20px;
	margin-top: 10px;
}

#message p {
	padding: 10px 35px;
	font-size: 18px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
	color: red;
}

.invalid:before {
	position: relative;
	left: -35px;
}
</style>
<title>Registration</title>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Conference Registration</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="userhome?email=${email}">Home</a> <a
						class="nav-link" href="#">Update User Detail</a> <a class="nav-link"
						href="checkstatus?email=${email}">Check Status</a> <a
						class="nav-link" href="logout">Log Out</a>
				</div>

			</div>
			<div class="d-flex">
				<img src="data:image/jpeg;base64,${userPhoto}"
					class="rounded-circle" width="50" height="50"> <span class="nav-link"
					style="color: white;">${name}</span>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="card " style="border-radius: 10px; width: 50rem;">
		<div class="card-header text-center">
			<h5 class="card-title">Update Detail</h5>
		</div>
		<form:form action="updateuserdatadetails?email=${email}" method="post"
			enctype="multipart/form-data"
			style="border-radius: 10px; margin-left: 10px; margin-right: 10px;">
			<br>
			<div class="mb-3">
				<label for="exampleInputusername" class="form-label">User
					Name</label> <input type="text" class="form-control"
					id="exampleInputusername" value="${user.getName()}" aria-describedby="emailHelp" name="name"
					required="required">
			</div>
				<div class="mb-3">
					<label for="exampleInputusermobile" class="form-label">Mobile
						Number</label> <input type="tel" class="form-control"
						id="exampleInputusermobile" aria-describedby="emailHelp"
						name="mobile" pattern="^\d{10}$" value="${user.getMobile()}" required="required">
				</div>
				<div class="mb-3">
					<label for="exampleInputuserdob" class="form-label">DOB</label> <input
						type="date" class="form-control" id="exampleInputuserdob"
						aria-describedby="emailHelp" value="${user.getDob()}" name="dob" max="${tdate}"
						required="required">
				</div>
			<div class="mb-3">
				<label for="exampleInputuserimg" class="form-label">Change Photo</label> <input
					type="file" class="form-control" id="exampleInputuserimg"
					aria-describedby="emailHelp" name="image"
					accept="image/png, image/jpeg,image/jpg">
			</div>
			<div class="col-md-12 text-center">
				<button type="submit" class="btn btn-primary">Update</button>
			</div>
			<br>
		</form:form>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
</body>
</html>