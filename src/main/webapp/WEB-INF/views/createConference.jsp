<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
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
</style>
<title>Create</title>
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
					<a class="nav-link active" aria-current="page" href="home?email=${email}">Home</a> <a
						class="nav-link" href="updateuser?email=${email}">Update User Detail</a> <a class="nav-link"
						href="#">Create new Conference</a> <a class="nav-link"
						href="logout">Log Out</a>
				</div>

			</div>
			<div class="d-flex">
				<img src="data:image/jpeg;base64,${userPhoto}"
					class="rounded-circle" width="50" height="50"> <span
					class="nav-link" style="color: white;">${name}</span>
			</div>
		</div>
	</nav>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="card " style="border-radius: 10px; width: 50rem;">
		<div class="card-header text-center">
			<h5 class="card-title">Create Conference</h5>
		</div>
		<form action="insertcon?email=${email}" method="post"
			style="border-radius: 10px; margin-left: 10px; margin-right: 10px;">
			<br> <br>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Title of
					conference</label> <input type="text" class="form-control"
					id="exampleInputTite" aria-describedby="emailHelp" name="title"
					required="required">
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Publication
					issue</label> <input type="text" id="inputPassword5" class="form-control"
					aria-describedby="passwordHelpBlock" name="publicationIssue"
					required="required">
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Submission
					Deadline</label> <input type="date" id="inputSubmission"
					class="form-control" aria-describedby="passwordHelpBlock"
					name="submissionDeadline" min="${date}" required="required">
			</div>
			<div class="row">
				<div class="col-md-6">
					<label for="exampleInputusermobile" class="form-label">Start
						Date</label> <input type="date" class="form-control"
						id="exampleInputuserstart" aria-describedby="emailHelp"
						min="${date}" name="startDate" required="required">
				</div>
				<div class="col-md-6">
					<label for="exampleInputuserdob" class="form-label">End
						Date</label> <input type="date" class="form-control"
						id="exampleInputuserend" aria-describedby="emailHelp"
						name="endDate" min="${date}" required="required">
				</div>
			</div>
			<br>
			<div class="col-md-12 text-center">
				<button type="submit" class="btn btn-primary">Create</button>
			</div>
			<br>
		</form>
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