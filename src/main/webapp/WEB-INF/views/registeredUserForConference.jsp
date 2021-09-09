<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</style>
<title>Home</title>
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
						href="createcon?email=${email}">Create new Conference</a> <a
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
	<div class="card " style="border-radius: 10px; width: 75rem;">
		<br>

		<table class="table">
			<caption class="caption-top">Registered Users Detail</caption>
			<thead class="table-dark">
				<tr>
					<th scope="col">Manuscript Type</th>
					<th scope="col">Area Of Research</th>
					<th scope="col">Title Of Paper</th>
					<th scope="col">Name Of Author1</th>
					<th scope="col">Author1 Email</th>
					<th scope="col">Rest Of The Authors</th>
					<th scope="col">Date Of Submission</th>
					<th scope="col">Status</th>
				</tr>
			<thead class="table-dark">
				<c:forEach items="${userList}" var="m">
					<tbody>
						<tr>
							<td scope="row">${m.getManuscriptType()}</td>
							<td scope="row">${m.getAreaOfResearch()}</td>
							<td scope="row">${m.getTitleOfPaper()}</td>
							<td scope="row">${m.getNameOfAuthor1()}</td>
							<td scope="row">${m.getUserEmailFk()}</td>
							<td scope="row">${m.getRestOfTheAuthors()}</td>
							<td scope="row">${m.getDateOfSubmittion()}</td>
							<td scope="row">${m.getStatus()}</td>
						</tr>
					<tbody>
				</c:forEach>
		</table>
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