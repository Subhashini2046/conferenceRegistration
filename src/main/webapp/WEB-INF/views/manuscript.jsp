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
					<a class="nav-link active" aria-current="page" href="#">Home</a> <a
						class="nav-link" href="#">Update User Detail</a> <a class="nav-link"
						href="createcon?email=${email}">Create new Conference</a> <a
						class="nav-link" href="logout">Log Out</a>
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
			<h5 class="card-title">Submit Paper</h5>
		</div>
		<form action="insertmanuscript?email=${email}&conId=${conId}"
			enctype="multipart/form-data" method="post"
			style="border-radius: 10px; margin-left: 10px; margin-right: 10px;">
			<br> <br>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Manuscript
					Type</label><select class="form-control" id="mt" name="manuscriptType" required="required">
					<option value="Review Article">Review Article</option>
					<option value="Case Reports/ Studies">Case Reports/
						Studies</option>
					<option value="Research Article">Research Article</option>
					<option value="View Points">View Points</option>
					<option value="Special Reports">Special Reports</option>
					<option value="Commentaries">Commentaries</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Area Of
					Research</label> <input type="text" id="inputPassword5"
					class="form-control" aria-describedby="passwordHelpBlock"
					name="areaOfResearch" required="required">
			</div>
			<div class="mb-3">
				<label for="inputPassword5" class="form-label">Title Of
					Paper</label> <input type="text" id="inputSubmission" class="form-control"
					aria-describedby="passwordHelpBlock" name="titleOfPaper"
					required="required">
			</div>

			<div class="mb-3">
				<label for="exampleInputusermobile" class="form-label">Name
					Of Author1</label> <input type="text" class="form-control"
					id="exampleInputuserstart" aria-describedby="emailHelp"
					name="NameOfAuthor1" required="required">
			</div>
			<div class="mb-3">
				<label for="exampleInputuserdob" class="form-label">Name of
					Rest of the Authors (Comma Separated)</label> <input type="text"
					class="form-control" id="exampleInputuserend"
					aria-describedby="emailHelp" name="restOfTheAuthors">
			</div>
			<div class="mb-3">
				<label for="exampleInputuserimg" class="form-label">Upload
					Paper</label> <input type="file" class="form-control"
					id="exampleInputuserimg" aria-describedby="emailHelp"
					name="paperfileName" accept="application/pdf" required="required">
					<div id="emailHelp" class="form-text">Allowed file types:pdf.</div>
			</div>
			<br>
			<div class="col-md-12 text-center">
				<button type="submit" class="btn btn-primary">Submit</button>
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